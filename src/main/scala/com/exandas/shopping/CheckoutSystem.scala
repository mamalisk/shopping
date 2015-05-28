package com.exandas.shopping

case class Offer(fruit:String, discount : (Int,Int)){
  require(discount._2 < discount._1, "wrong discount")
  require(fruit.equalsIgnoreCase("apple") || fruit.equalsIgnoreCase("orange"), s"unknown fruit $fruit")

}

case class CheckoutSystem(fruits:List[Fruit]) {

   var offers : List[Offer] = List[Offer]()

   def totalCost : String = {
       var result = s"£"
       val appleCost = new Apple().priceInCurrency.getActual
       val orangeCost = new Orange().priceInCurrency.getActual
        if(offers.size > 0) {
           val apples = fruits.filter(_.isInstanceOf[Apple])
           val oranges = fruits.filter(_.isInstanceOf[Orange])
           val applesOffer = offers.filter(_.fruit.equalsIgnoreCase("apple")).headOption
           val orangeOffer = offers.filter(_.fruit.equalsIgnoreCase("orange")).headOption
           var total : Double = 0
           applesOffer match {
             case Some(offer) => {
                 val discount = offer.discount
                 total += (Math.floorDiv(apples.size,discount._1) + Math.floorMod(apples.size,discount._1)) * appleCost
             }
             case None => println("no discount for apples")
           }
          orangeOffer match {
            case Some(offer) => {
              val discount = offer.discount
              total += (Math.floorDiv(oranges.size,discount._1) + Math.floorMod(oranges.size,discount._1)) * orangeCost
            }
            case None => println("no discount for oranges")
          }
          result += s"$total"
       } else {

          result += s"${fruits.foldRight(0d)((r,c) => r.priceInCurrency.getActual + c)}"
        }
       result
    }

   def addOffer(offer : Offer): Unit = {
     if(offers.exists(_.fruit.equalsIgnoreCase(offer.fruit))){
       offers = offers.dropWhile(_.fruit.equalsIgnoreCase(offer.fruit))
     }
     offers = offers.::(offer)
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
