/**
 * The `printEmployeesNumbers` function takes an array of employee names as input.
 * It creates an object `employees` where each employee name is used as a key and the length of the name is the value.
 * The function then iterates over the entries of the `employees` object and prints each employee's name and corresponding personal number.
 *
 * Example usage:
 * - const input = [
 *     "Silas Butler",
 *     "Adnaan Buckley",
 *     "Juan Peterson",
 *     "Brendan Villarreal",
 *   ];
 *   printEmployeesNumbers(input);
 *   - Creates an `employees` object with the names as keys and their lengths as values.
 *   - Prints the name and personal number for each employee.
 *
 * The above example will output:
 *   Name: Silas Butler -- Personal Number: 12
 *   Name: Adnaan Buckley -- Personal Number: 14
 *   Name: Juan Peterson -- Personal Number: 13
 *   Name: Brendan Villarreal -- Personal Number: 20
 *
 * Note: The output may vary depending on the input.
 */
function printEmployeesNumbers(input) {
  const employees = input.reduce((acc, curr) => {
    acc[curr] = curr.length;
    return acc;
  }, {});

  Object.entries(employees).forEach(([name, number]) => {
    console.log(`Name: ${name} -- Personal Number: ${number}`);
  });
}

printEmployeesNumbers([
  "Silas Butler",
  "Adnaan Buckley",
  "Juan Peterson",
  "Brendan Villarreal",
]);
