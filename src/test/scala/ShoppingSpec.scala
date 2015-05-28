package com.exandas.shopping


class ShoppingSpec extends SpecSetup(
   "As a customer",
   "I want to be able to buy apples and oranges and be provided with a total cost",
   "In order to know how much I need to pay"
) {
  describe("Checkout System") {
    it("should be able individual fruits to the card"){
       val checkoutSystem : CheckoutSystem = CheckoutSystem(List(new Apple(), new Apple(), new Orange()))
       checkoutSystem.fruits should have size 3
    }
    it("should be able to receive strings of fruits to the card") {
      val checkoutSystem = CheckoutSystem.getFor(List("apple", "orange"))
      checkoutSystem.fruits should have size 2
    }

    it("should fail for unknown fruit") {
      intercept[Exception] {
        CheckoutSystem.getFor(List("Pear"))
      }

    }

    it("should print the total cost") {
      var checkoutSystem = CheckoutSystem.getFor(List[String]())
      val totalCost = checkoutSystem.totalCost
      totalCost should be ("£0.0")
      checkoutSystem = CheckoutSystem.getFor(List("apple", "apple","orange"))
      checkoutSystem.totalCost should be ("£1.45")
    }

    it("should be able to accept offers") {
      val checkoutSystem = CheckoutSystem.getFor(List[String]())
      checkoutSystem.offers should have size 0
      checkoutSystem.addOffer(Offer("Apple",(2,1)))
      checkoutSystem.offers should have size 1
    }

    it("should be able to perform discounts based on offers") {
      val checkoutSystem = CheckoutSystem.getFor(List[String]("apple","apple","apple","apple","apple"))
      checkoutSystem.addOffer(Offer("Apple",(4,1)))
      checkoutSystem.offers should have size 1
      checkoutSystem.totalCost should be ("£1.2")
    }
  }

  describe("Offer"){
    it("should throw exception for unknown fruit"){
      intercept[IllegalArgumentException] {
        Offer("Pear",(3,2))
      }
    }
    it("should throw exception for wrong discount") {
      intercept[IllegalArgumentException] {
        Offer("Orange",(2,3))
      }
    }
  }

  describe("Fruits") {
    it("should be able to hold a price"){

      new Apple().priceInCurrency should be (Pound(0.60))
      new Orange().priceInCurrency should be (Pound(0.25))
    }
  }
}

