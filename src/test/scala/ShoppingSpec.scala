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
  }

  describe("Fruits") {
    it("should be able to hold a price"){

      new Apple().priceInCurrency should be (Pound(0.60))
      new Orange().priceInCurrency should be (Pound(0.25))
    }
  }
}

