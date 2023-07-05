/**
 * The `cityTaxes` function creates and returns a city object with properties and methods related to taxes, population, and treasury.
 *
 * The function takes three parameters: `name`, `population`, and `treasury` representing the name of the city, its population, and its treasury amount, respectively.
 *
 * Inside the function, a `city` object is created with the following properties:
 * - `name`: Stores the name of the city.
 * - `population`: Stores the population of the city.
 * - `treasury`: Stores the treasury amount of the city.
 * - `taxRate`: Represents the tax rate for the city (10% in this case).
 *
 * The object also includes the following methods:
 * - `collectTaxes`: Calculates the amount of taxes based on the population and tax rate and adds it to the treasury.
 * - `applyGrowth`: Increases the population of the city by a certain percentage.
 * - `applyRecession`: Decreases the treasury of the city by a certain percentage.
 *
 * The created `city` object is returned by the function.
 *
 * Example usage:
 * - const city = cityTaxes("Tortuga", 7000, 15000);
 *   - Creates a city object named "Tortuga" with a population of 7000 and a treasury of 15000.
 * - city.collectTaxes();
 *   - Calculates and adds taxes to the treasury based on the population and tax rate.
 * - city.applyGrowth(5);
 *   - Increases the population of the city by 5%.
 * - console.log(city.population);
 *   - Prints the updated population of the city.
 *
 * The above example will output:
 *   { name: 'Tortuga', population: 7000, treasury: 15000, taxRate: 10, collectTaxes: [Function: collectTaxes], applyGrowth: [Function: applyGrowth], applyRecession: [Function: applyRecession] }
 *   21500
 *   7350
 */

function cityTaxes(name, population, treasury) {
  const city = {
    name: name,
    population: population,
    treasury: treasury,
    taxRate: 10,
    collectTaxes: function () {
      this.treasury += Math.floor(this.population * this.taxRate);
    },
    applyGrowth: function (percentage) {
      const growth = Math.floor(this.population * (percentage / 100));
      this.population += growth;
    },
    applyRecession: function (percentage) {
      const recession = Math.floor(this.treasury * (percentage / 100));
      this.treasury -= recession;
    },
  };

  return city;
}

// Example usage
const city = cityTaxes("Tortuga", 7000, 15000);
console.log(city);

city.collectTaxes();
console.log(city.treasury);

city.applyGrowth(5);
console.log(city.population);
