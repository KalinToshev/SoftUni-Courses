/**
 * Prints three characters in reversed order with a space between them.
 *
 * @param {string} char1 - The first character.
 * @param {string} char2 - The second character.
 * @param {string} char3 - The third character.
 */

function printReversed(char1, char2, char3) {
  let reversedString = char3 + " " + char2 + " " + char1;
  console.log(reversedString);
}

// Example usage
printReversed("A", "B", "C"); // Output: "C B A"
