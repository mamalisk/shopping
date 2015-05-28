package com.exandas.shopping

import org.scalatest.{Matchers, GivenWhenThen, FunSpec}
case class SpecSetup(role:String, feature:String, cause:String) extends FunSpec with GivenWhenThen with Matchers{
  info(s"$info\n$feature\n$cause")
}
