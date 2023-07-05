/**
 * The `convertToObject` function takes a JSON string as input and converts it into a JavaScript object.
 *
 * It uses the `JSON.parse` method to parse the JSON string and store the result in a `person` object variable.
 *
 * Then, it iterates over the keys of the `person` object using `Object.keys` and prints each key-value pair using `console.log`.
 *
 * Example usage:
 * - convertToObject('{"name": "George", "age": 40, "town": "Sofia"}');
 *   - Converts the given JSON string into an object and prints its key-value pairs.
 *
 * The above example will output:
 *   name: George
 *   age: 40
 *   town: Sofia
 */
function convertToObject(json) {
  const person = JSON.parse(json);

  Object.keys(person).forEach((key) => {
    console.log(`${key}: ${person[key]}`);
  });
}

convertToObject('{"name": "George", "age": 40, "town": "Sofia"}');
