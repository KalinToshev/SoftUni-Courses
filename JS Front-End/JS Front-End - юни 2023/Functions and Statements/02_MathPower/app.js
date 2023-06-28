/**
 * Calculates and prints the value of a number raised to a given power.
 *
 * @param {number} base - The base number.
 * @param {number} exponent - The exponent.
 */
function calculatePower(base, exponent) {
  const result = Math.pow(base, exponent);
  console.log(result);
}

// Example usage:
calculatePower(2, 3); // Output: The result of 2 raised to the power of 3 is: 8
