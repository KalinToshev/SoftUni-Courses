/**
 * The function `findSmallestNumber` takes in a variable number of arguments using the spread operator (...nums).
 *
 * Inside the function, the spread arguments are stored in the `nums` array.
 * The array `nums` is then sorted in ascending order using the `sort` method and a compare function `(a, b) => a - b`.
 * The compare function ensures that the array is sorted numerically.
 *
 * The smallest number is obtained by accessing the first element of the sorted array, which is at index 0.
 *
 * Finally, the smallest number is printed on the console using `console.log`.
 *
 * Example usage:
 * - Calling `findSmallestNumber(2, 5, 3)` will output 2, as it is the smallest number among the arguments.
 */
function findSmallestNumber(...nums) {
  const smallest = nums.sort((a, b) => a - b)[0];
  console.log(smallest);
}

findSmallestNumber(2, 5, 3);
