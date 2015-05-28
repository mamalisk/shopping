package com.exandas.shopping
sealed trait Fruit {
   def priceInCurrency : Currency
}

sealed trait Currency {
  def getActual : Long
}

class Apple extends Fruit {
  def priceInCurrency = ???
}

class Orange extends Fruit {
  def priceInCurrency = ???
}