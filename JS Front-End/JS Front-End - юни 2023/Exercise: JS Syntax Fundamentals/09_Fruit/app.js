/**
 * Calculates the amount of money needed to buy a specific weight of a fruit at a given price per kilogram
 * and prints the result with a formatted message.
 *
 * @param {string} typeOfFruit - The type of fruit to buy.
 * @param {number} weight - The weight of the fruit in grams.
 * @param {number} pricePerKilo - The price per kilogram of the fruit.
 */
function calculateMoneyNeededToBuyFruit(typeOfFruit, weight, pricePerKilo) {
  let money = (pricePerKilo / 1000) * weight;
  console.log(
    `I need $${money.toFixed(2)} to buy ${(weight / 1000).toFixed(2)} kilograms ${typeOfFruit}.`
  );
}

calculateMoneyNeededToBuyFruit("apple", 1563, 2.35);
