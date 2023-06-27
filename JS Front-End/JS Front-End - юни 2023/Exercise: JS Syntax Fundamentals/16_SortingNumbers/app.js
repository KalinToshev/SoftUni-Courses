/**
 * Sorts an array of numbers in ascending order and creates a new array with elements arranged in a specific pattern.
 *
 * @param {number[]} numbers - The array of numbers.
 * @returns {number[]} - The sorted array with elements arranged in a specific pattern.
 */
function sortNumbers(numbers) {
  // Create an empty array to store the sorted elements in a specific pattern
  let arr = [];

  // Sort the numbers array in ascending order
  numbers.sort((a, b) => a - b);

  // Iterate until the numbers array is empty
  while (numbers.length > 0) {
    // Take the smallest number from the beginning of the array and add it to the result array
    arr.push(numbers.shift());

    // Take the largest number from the end of the array and add it to the result array
    arr.push(numbers.pop());
  }

  // Return the sorted array with elements arranged in a specific pattern
  return arr;
}

sortNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);
