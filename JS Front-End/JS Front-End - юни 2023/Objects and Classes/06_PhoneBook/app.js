/**
 * The `phoneBook` function takes an array of strings as input.
 * Each string in the array represents a name and phone number separated by a space.
 * The function converts the array into a phone book object, where the names are the keys and the phone numbers are the values.
 * It uses the `reduce` method to iterate over the array and build the phone book object.
 * Finally, it prints each entry in the phone book by iterating over the keys of the phone book object.
 *
 * Example usage:
 * - phoneBook([
 *     "Tim 0834212554",
 *     "Peter 0877547887",
 *     "Bill 0896543112",
 *     "Tim 0876566344"
 *   ]);
 *   - Converts the array into a phone book object and prints the entries in the phone book.
 *
 * The above example will output:
 *   Tim -> 0834212554
 *   Peter -> 0877547887
 *   Bill -> 0896543112
 *   Tim -> 0876566344
 */
function phoneBook(arr) {
  const phoneObj = arr.reduce((acc, curr) => {
    const [name, phone] = curr.split(" ");
    acc[name] = phone;

    return acc;
  }, {});

  Object.keys(phoneObj).forEach((key) =>
    console.log(`${key} -> ${phoneObj[key]}`)
  );
}

phoneBook([
  "Tim 0834212554",
  "Peter 0877547887",
  "Bill 0896543112",
  "Tim 0876566344",
]);
