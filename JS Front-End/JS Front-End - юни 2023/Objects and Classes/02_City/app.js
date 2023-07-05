/**
 * The function `printCityInfo` takes an object `obj` as a parameter and prints each key-value pair in the object.
 *
 * It iterates over each key in the object using a `for...in` loop.
 * Inside the loop, it accesses the value corresponding to the current key using `obj[key]`.
 * It then logs the key-value pair to the console using `console.log()`, with the key and value separated by " -> ".
 *
 * Example usage:
 * - Calling `printCityInfo({ name: "Plovdiv", area: 389, population: 1162358, country: "Bulgaria", postCode: "4000" })` will print the following:
 *   name -> Plovdiv
 *   area -> 389
 *   population -> 1162358
 *   country -> Bulgaria
 *   postCode -> 4000
 *   It prints each key-value pair in the object on a separate line.
 */
function printCityInfo(obj) {
  for (let key in obj) {
    console.log(key + " -> " + obj[key]);
  }
}

printCityInfo({
  name: "Plovdiv",
  area: 389,
  population: 1162358,
  country: "Bulgaria",
  postCode: "4000",
});
