package com.exandas.shopping

/**
 * Created by kostas on 28/05/2015.
 */
object Conversions {
   implicit def longToPound(value: Long) = Pound(value)
   implicit def stringToFruit(string : String) : Fruit = {
     string.toLowerCase match {
       case "apple" => new Apple()
       case "orange" => new Orange()
       case _ => throw new Exception(s"unknown fruit: $string")
     }
   }
}
