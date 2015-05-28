package com.exandas.shopping


class ShoppingSpec extends SpecSetup(
   "As a customer",
   "I want to be able to buy apples and oranges and be provided with a total cost",
   "In order to know how much I need to pay"
) {
  describe("Checkout System") {
    it("should be able individual fruits to the card"){
       val checkoutSystem = CheckoutSystem(new Apple(), new Apple(), new Orange())
       checkoutSystem.fruits should have size 3
    }
  }

  describe("Fruits") {
    it("should be able to hold a price"){
      import com.exandas.shopping.Pound
      new Apple().priceInCurrency should be (Pound(0.60))
      new Orange().priceInCurrency should be (Pound(0.25))
    }
  }
}

