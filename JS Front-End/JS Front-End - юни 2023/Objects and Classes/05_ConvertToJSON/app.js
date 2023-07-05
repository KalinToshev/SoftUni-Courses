/**
 * The `convertToJSON` function takes three parameters: `name`, `lastName`, and `hairColor`.
 * It creates a `person` object using object shorthand notation, where the properties are assigned the values of the corresponding parameters.
 * Then, it uses `JSON.stringify` to convert the `person` object into a JSON string representation.
 * Finally, it logs the JSON string to the console.
 *
 * Example usage:
 * - convertToJSON("George", "Jones", "Brown");
 *   - Creates a `person` object with the provided values and logs the corresponding JSON string to the console.
 *
 * The above example will output:
 *   {"name":"George","lastName":"Jones","hairColor":"Brown"}
 */
function convertToJSON(name, lastName, hairColor) {
  const person = {
    name,
    lastName,
    hairColor,
  };
  console.log(JSON.stringify(person));
}

convertToJSON("George", "Jones", "Brown");
