/**
 * Sorts an array of names alphabetically and prints a numbered list.
 *
 * @param {string[]} names - The array of names.
 */
function printSortedNames(names) {
  // Sort the names alphabetically in ascending order
  names.sort((a, b) => a.localeCompare(b));

  // Print the numbered list of names
  for (let i = 0; i < names.length; i++) {
    console.log(`${i + 1}.${names[i]}`);
  }
}
