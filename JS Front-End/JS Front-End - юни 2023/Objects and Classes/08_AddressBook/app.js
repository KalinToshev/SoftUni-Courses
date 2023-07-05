/**
 * The `store_and_print_addresses` function takes an array of address strings as input.
 * Each address string contains a name and an address separated by a colon.
 * The function stores the addresses in an address book object, where names are the keys and addresses are the values.
 * If a name already exists in the address book, the function updates the address for that name.
 * Finally, it prints the addresses in alphabetical order of names.
 *
 * Example usage:
 * - const addresses = [
 *     "Bob:Huxley Rd",
 *     "John:Milwaukee Crossing",
 *     "Peter:Fordem Ave",
 *     "Bob:Redwing Ave",
 *     "George:Mesta Crossing",
 *     "Ted:Gateway Way",
 *     "Bill:Gateway Way",
 *     "John:Grover Rd",
 *     "Peter:Huxley Rd",
 *     "Jeff:Gateway Way",
 *     "Jeff:Huxley Rd",
 *   ];
 *   store_and_print_addresses(addresses);
 *   - Stores the addresses in the address book and prints them in alphabetical order of names.
 *
 * The above example will output:
 *   Bill -> Gateway Way
 *   Bob -> Redwing Ave
 *   George -> Mesta Crossing
 *   Jeff -> Huxley Rd
 *   John -> Grover Rd
 *   Peter -> Huxley Rd
 *   Ted -> Gateway Way
 */
function store_and_print_addresses(addresses) {
  let address_book = {};
  addresses.forEach(function (item) {
    let [name, addr] = item.split(":");

    if (address_book.hasOwnProperty(name)) {
      address_book[name] = addr;
    } else {
      address_book[name] = addr;
    }
  });

  let sortedAddressBooks = Object.keys(address_book).sort();

  sortedAddressBooks.forEach(function (name) {
    console.log(name + " -> " + address_book[name]);
  });
}

// Example usage:
let input = [
  "Bob:Huxley Rd",
  "John:Milwaukee Crossing",
  "Peter:Fordem Ave",
  "Bob:Redwing Ave",
  "George:Mesta Crossing",
  "Ted:Gateway Way",
  "Bill:Gateway Way",
  "John:Grover Rd",
  "Peter:Huxley Rd",
  "Jeff:Gateway Way",
  "Jeff:Huxley Rd",
];

store_and_print_addresses(input);
