/**
 * The function `factorialDevision` calculates the division of two factorials, `num1!` divided by `num2!`, and prints the result with two decimal places.
 *
 * It starts by calling the `calcFactorial` function to calculate the factorial of `num1` and assigns the result to `facOne`.
 * Then, it calls `calcFactorial` again to calculate the factorial of `num2` and assigns the result to `facTwo`.
 *
 * Next, it performs the division `facOne / facTwo` and uses the `toFixed(2)` method to round the result to two decimal places.
 * The result is then printed using `console.log()`.
 *
 * The `calcFactorial` function is defined inside `factorialDevision` and recursively calculates the factorial of a given number `num`.
 * If `num` is 0 or 1, it returns 1 as the base case.
 * Otherwise, it recursively multiplies `num` by the factorial of `num - 1` until it reaches the base case.
 *
 * Example usage:
 * - Calling `factorialDevision(5, 2)` will output:
 *    "60.00"
 */
function factorialDevision(num1, num2) {
  let facOne = calcFactorial(num1);
  let facTwo = calcFactorial(num2);

  console.log((facOne / facTwo).toFixed(2));

  function calcFactorial(num) {
    if (num === 0 || num === 1) {
      return 1;
    } else {
      return num * calcFactorial(num - 1);
    }
  }
}

factorialDevision(5, 2);
