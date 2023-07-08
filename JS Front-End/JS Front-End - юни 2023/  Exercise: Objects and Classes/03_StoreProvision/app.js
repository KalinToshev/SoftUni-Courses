/**
 * The `storeProvision` function takes two arrays as input: `currentStock` and `deliveredStock`.
 * The function combines the two arrays into a single array called `products`.
 * It then iterates over the `products` array and creates an object called `stock`.
 * The `stock` object keeps track of the quantity of each product in the inventory.
 * If a product already exists in the `stock` object, the quantity is incremented.
 * If a product does not exist in the `stock` object, a new property is created with the product name and quantity.
 * Finally, the function prints each product and its corresponding quantity from the `stock` object.
 *
 * Example usage:
 * - const currentStock = ["Chips", "5", "CocaCola", "9", "Bananas", "14"];
 *   const deliveredStock = ["Pasta", "4", "Beer", "2"];
 *   storeProvision(currentStock, deliveredStock);
 *   - Combines the `currentStock` and `deliveredStock` arrays into a single `products` array.
 *   - Creates a `stock` object to keep track of the product quantities.
 *   - Prints each product and its quantity from the `stock` object.
 *
 * The above example will output:
 *   Chips -> 5
 *   CocaCola -> 9
 *   Bananas -> 14
 *   Pasta -> 4
 *   Beer -> 2
 *
 * Note: The output may vary depending on the input.
 */
function storeProvision(currentStock, deliveredStock) {
  const products = [...currentStock, ...deliveredStock];

  const stock = products.reduce((acc, curr, index) => {
    if (index % 2 === 0) {
      if (!acc.hasOwnProperty(curr)) {
        acc[curr] = Number(products[index + 1]);
      } else {
        acc[curr] += Number(products[index + 1]);
      }
    }

    return acc;
  }, {});

  Object.keys(stock).forEach((key) => {
    console.log(`${key} -> ${stock[key]}`);
  });
}

storeProvision(
  ["Chips", "5", "CocaCola", "9", "Bananas", "14", "Pasta", "4", "Beer", "2"],
  ["Flour", "44", "Oil", "12", "Pasta", "7", "Tomatoes", "70", "Bananas", "30"]
);
