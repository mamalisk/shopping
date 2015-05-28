package com.exandas.shopping

case class Offer(fruit:String, discount : (Int,Int)){
  if(discount._2 > discount._1) throw new RuntimeException("wrong discount")
  require(discount._2 > discount._1, "wrong discount")
  require(fruit.equalsIgnoreCase("apple") || fruit.equalsIgnoreCase("orange"), s"unknown fruit $fruit")

}

case class CheckoutSystem(fruits:List[Fruit]) {

   var offers : List[Offer] = List[Offer]()

   def totalCost : String = {
       val result = fruits.foldRight(0d)((r,c) => r.priceInCurrency.getActual + c)
       s"£$result"
    }


}

object CheckoutSystem {
  def getFor(fruitsList:List[String]) : CheckoutSystem = {
    import Conversions._
    var actualFruitList : List[Fruit] = List[Fruit]()
    fruitsList.foreach( fruitString => actualFruitList = actualFruitList.::(fruitString) )
    new CheckoutSystem(actualFruitList)
  }
}
