/**
 * Calculates the total price of an order based on the product and quantity,
 * and prints the result formatted to the second decimal place.
 * @param {string} product - The product name (coffee, water, coke, snacks).
 * @param {number} quantity - The quantity of the product.
 */
function calculateOrderPrice(product, quantity) {
  let price;
  switch (product) {
    case "coffee":
      price = 1.5;
      break;
    case "water":
      price = 1.0;
      break;
    case "coke":
      price = 1.4;
      break;
    case "snacks":
      price = 2.0;
      break;
    default:
      console.log("Invalid product");
      return;
  }

  const totalPrice = price * quantity;
  console.log(totalPrice.toFixed(2));
}

// Example usage:
calculateOrderPrice("water", 5); // Output: 5.00
calculateOrderPrice("coffee", 2); // Output: 3.00
