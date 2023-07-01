/**
 * The function `addAndSubtract` takes in three numbers `num1`, `num2`, and `num3`.
 *
 * Inside the function, there are two nested helper functions: `sum` and `subtract`.
 * - The `sum` function takes two arguments `a` and `b` and returns their sum.
 * - The `subtract` function takes a `sum` and `c` as arguments and subtracts `c` from the result of `sum(num1, num2)`.
 *
 * The `result` variable is assigned the result of calling `subtract` with the `sum` function and `num3`.
 *
 * Finally, the `result` is printed on the console using `console.log`.
 *
 * Example usage:
 * - Calling `addAndSubtract(1, 17, 30)` will output -12, calculated as (1 + 17) - 30.
 */
function addAndSubtract(num1, num2, num3) {
  const result = subtract(sum, num3);

  console.log(result);

  function sum(a, b) {
    return a + b;
  }

  function subtract(sum, c) {
    return sum(num1, num2) - c;
  }
}

addAndSubtract(1, 17, 30);
