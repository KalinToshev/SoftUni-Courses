/**
 * Searches for a specific word within a given text and prints the word if found.
 * Case-insensitive search is performed.
 *
 * @param {string} searchedWord - The word to search for.
 * @param {string} text - The input text to search within.
 */
function findSubstring(searchedWord, text) {
  // Split the text into individual words
  let words = text.split(" ");

  // Flag to indicate if the word is found
  let isWordFound = false;

  // Iterate over each word in the words array
  for (let word of words) {
    // Perform case-insensitive comparison
    if (word.toLowerCase() === searchedWord.toLowerCase()) {
      // Set the flag to true and exit the loop
      isWordFound = true;
      break;
    }
  }

  // Print the result based on whether the word is found or not
  if (isWordFound) {
    console.log(searchedWord);
  } else {
    console.log(`${searchedWord} not found!`);
  }
}

// Example usage:
findSubstring("javascript", "The Best programming language is JavaScript");
