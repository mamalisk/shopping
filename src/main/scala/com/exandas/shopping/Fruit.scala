package com.exandas.shopping

sealed trait Fruit {
   def priceInCurrency : Currency
}

sealed trait Currency {
}

class Apple extends Fruit {
  def priceInCurrency : Currency = Pound(0.6)
}

class Orange extends Fruit {
  def priceInCurrency = Pound(0.25)
}

case class Pound(value:Double) extends Currency {
}