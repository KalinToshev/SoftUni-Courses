/**
 * Extracts hashtags from a given text and prints them on separate lines.
 *
 * @param {string} text - The input text containing hashtags.
 */
function findHashtags(text) {
  // Split the text into individual words
  const words = text.split(" ");

  // Create an empty array to store the extracted hashtags
  let hashtags = [];

  // Iterate over each word in the words array
  for (const word of words) {
    // Regular expression to match words starting with '#' followed by one or more letters
    let letters = /^[#]+[a-zA-Z]+$/g;

    // Check if the word starts with '#' and matches the letters pattern
    if (word.startsWith("#") && word.match(letters)) {
      // Remove the '#' symbol from the word and add it to the hashtags array
      let noHash = word.substring(1);
      hashtags.push(noHash);
    }
  }

  // Print the extracted hashtags on separate lines
  console.log(hashtags.join("\n"));
}

// Example usage:
findHashtags(
  "Nowadays everyone uses # to #Fs31 tag a #special word in #socialMedia"
);
