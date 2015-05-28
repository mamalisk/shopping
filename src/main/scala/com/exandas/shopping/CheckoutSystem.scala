package com.exandas.shopping

case class CheckoutSystem(fruits:List[Fruit]) {

}

object CheckoutSystem {
  def getFor(fruitsList:List[String]) : CheckoutSystem = {
    import Conversions._
    var actualFruitList : List[Fruit] = List[Fruit]()
    fruitsList.foreach( fruitString => actualFruitList = actualFruitList.::(fruitString) )
    return new CheckoutSystem(actualFruitList)
  }
}
