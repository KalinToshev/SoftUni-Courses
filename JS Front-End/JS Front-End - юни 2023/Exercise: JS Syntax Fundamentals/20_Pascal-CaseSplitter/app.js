/**
 * Splits a PascalCase string into individual words and prints them separated by commas.
 *
 * @param {string} inputString - The input string in PascalCase format.
 */
function splitPascalCase(inputString) {
  // Split the input string into words based on the occurrence of an uppercase letter
  let words = inputString.split(/(?=[A-Z])/);

  // Join the words with a comma and space in between
  let result = words.join(", ");

  // Print the resulting words
  console.log(result);
}

splitPascalCase("SplitMeIfYouCanHaHaYouCantOrYouCan");
