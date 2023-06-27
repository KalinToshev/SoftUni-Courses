/**
 * Replaces asterisks in a given text with corresponding words from a list of words.
 *
 * @param {string} words - The comma-separated list of words.
 * @param {string} text - The text containing asterisks to be replaced.
 */
function revealWords(words, text) {
  // Split the comma-separated words into an array
  const wordArr = words.split(", ");

  // Create a copy of the original text
  let replacedText = text;

  // Iterate through each word in the word array
  for (const word of wordArr) {
    // Create a temporary string with asterisks of the same length as the current word
    let temp = "*".repeat(word.length);

    // Replace the asterisks in the replacedText with the current word
    replacedText = replacedText.replace(temp, word);
  }

  // Print the resulting text with replaced words
  console.log(replacedText);
}

revealWords(
  "great, learning, languages",
  "softuni is ***** place for ******** new programming *********"
);
