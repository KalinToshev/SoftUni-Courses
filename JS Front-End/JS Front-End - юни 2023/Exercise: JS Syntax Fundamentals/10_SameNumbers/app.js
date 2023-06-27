/**
 * Checks if all the digits in a given number are the same and prints the result.
 * Also prints the sum of all the digits.
 *
 * @param {number} number - The input integer number to check.
 */
function checkDigits(number) {
  const digits = String(number).split("");

  const firstDigit = digits[0];

  let allSame = true;
  let sum = 0;

  for (let i = 0; i < digits.length; i++) {
    sum += Number(digits[i]);

    if (digits[i] !== firstDigit) {
      allSame = false;
    }
  }

  console.log(allSame);
  console.log(sum);
}

// Example usage
checkDigits(1234); // Output: true, 4
