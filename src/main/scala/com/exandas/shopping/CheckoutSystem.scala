package com.exandas.shopping

case class CheckoutSystem(fruits:List[Fruit]) {
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
    return new CheckoutSystem(actualFruitList)
  }
}
