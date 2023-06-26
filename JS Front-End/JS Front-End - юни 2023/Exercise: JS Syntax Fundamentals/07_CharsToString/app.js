/**
 * Combines three single characters into a single string and prints it to the console.
 *
 * @param {string} char1 - The first character.
 * @param {string} char2 - The second character.
 * @param {string} char3 - The third character.
 */
function combineCharacters(char1, char2, char3) {
  let combinedString = char1 + char2 + char3;
  console.log(combinedString);
}

// Example usage
combineCharacters("A", "B", "C"); // Output: "ABC"
