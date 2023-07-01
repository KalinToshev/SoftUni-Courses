/**
 * The function `nXnMatrix` generates and prints an n x n matrix where each element is equal to the input `num`.
 *
 * It creates a matrix using the `Array(num).fill(Array(num).fill(num))` expression, which fills an array with `num` elements, where each element is an array filled with `num` elements, all having the value `num`.
 *
 * It then iterates over each row in the matrix using the `forEach` method and logs the row elements joined by a space using `row.join(" ")`.
 *
 * Example usage:
 * - Calling `nXnMatrix(3)` will output:
 *   - 3 3 3
 *   - 3 3 3
 *   - 3 3 3
 */
function nXnMatrix(num) {
  const matrix = Array(num).fill(Array(num).fill(num));

  matrix.forEach((row) => {
    console.log(row.join(" "));
  });
}

nXnMatrix(3);
