/**
 * The code defines an arrow function named `result` that takes in three parameters (`a`, `b`, and `c`).
 * It initializes a variable `negativeCount` to 0 to keep track of the count of negative numbers.
 *
 * Each parameter is checked individually, and if it is less than 0 (negative), the `negativeCount` is incremented.
 *
 * After checking all three parameters, the code determines if the `negativeCount` is an even or odd number.
 * If `negativeCount` is divisible by 2 (even), it means there are an even number of negative numbers, so the function returns "Positive".
 * Otherwise, it means there are an odd number of negative numbers, so the function returns "Negative".
 *
 * Example usage:
 * - Calling `result(2, 2, -3)` will return "Negative" since there is one negative number among the three parameters.
 *
 * The result is stored in the `result` variable and then printed on the console using `console.log`.
 */
const result = (a, b, c) => {
  let negativeCount = 0;

  if (a < 0) {
    negativeCount++;
  }

  if (b < 0) {
    negativeCount++;
  }

  if (c < 0) {
    negativeCount++;
  }

  if (negativeCount % 2 === 0) {
    return "Positive";
  } else {
    return "Negative";
  }
};

console.log(result(2, 2, -3));
