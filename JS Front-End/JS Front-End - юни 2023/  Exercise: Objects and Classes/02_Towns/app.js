/**
 * The `printTownsAsObjects` function takes an array of strings representing town data as input.
 * Each string is in the format "town | latitude | longitude".
 * The function maps over the input array and creates an array of objects, where each object represents a town.
 * The town name, latitude, and longitude are extracted from each string and assigned as properties to the object.
 * Finally, the function iterates over the array of objects and prints each town object in a specific format.
 *
 * Example usage:
 * - const input = [
 *     "Sofia | 42.696552 | 23.32601",
 *     "Beijing | 39.913818 | 116.363625",
 *   ];
 *   printTownsAsObjects(input);
 *   - Creates an array of town objects with town name, latitude, and longitude properties.
 *   - Prints each town object in a specific format.
 *
 * The above example will output:
 *   { town: 'Sofia', latitude: '42.70', longitude: '23.33' }
 *   { town: 'Beijing', latitude: '39.91', longitude: '116.36' }
 *
 * Note: The output may vary depending on the input.
 */
function printTownsAsObjects(input) {
  input
    .map((city) => {
      const [town, latitude, longitude] = city.split(" | ");
      return { town, latitude, longitude };
    })
    .forEach((city) => {
      console.log(
        `{ town: '${city.town}', latitude: '${Number(city.latitude).toFixed(
          2
        )}', longitude: '${Number(city.longitude).toFixed(2)}' }`
      );
    });
}

printTownsAsObjects([
  "Sofia | 42.696552 | 23.32601",
  "Beijing | 39.913818 | 116.363625",
]);
