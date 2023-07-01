/**
 * The function `perfectNumber` determines whether a given number `num` is a perfect number or not.
 *
 * It starts by initializing a variable `sum` to 0, which will be used to accumulate the sum of the divisors of `num`.
 *
 * It then iterates over the numbers from 1 to `num - 1` and checks if `num` is divisible by the current number `index` using the modulo operator (`num % index === 0`).
 * If `index` is a divisor of `num`, it adds `index` to the `sum`.
 *
 * After the loop, it checks if the `sum` is equal to `num`. If they are equal, it prints "We have a perfect number!".
 * Otherwise, it prints "It's not so perfect."
 *
 * Example usage:
 * - Calling `perfectNumber(6)` will output: "We have a perfect number!"
 * - Calling `perfectNumber(28)` will output: "We have a perfect number!"
 * - Calling `perfectNumber(1236498)` will output: "It's not so perfect."
 */
function perfectNumber(num) {
  let sum = 0;

  for (let index = 1; index < num; index++) {
    if (num % index === 0) {
      sum += index;
    }
  }

  if (sum === num) {
    console.log("We have a perfect number!");
  } else {
    console.log("It's not so perfect.");
  }
}

perfectNumber(6);
perfectNumber(28);
perfectNumber(1236498);
