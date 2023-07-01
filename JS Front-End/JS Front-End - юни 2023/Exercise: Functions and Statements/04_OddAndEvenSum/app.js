/**
 * The function `oddAndEvenSum` takes in a number `num`.
 *
 * Inside the function, it converts the number `num` to an array of digits using `Array.from(String(num), Number)`
 * and assigns it to the variable `arr`.
 *
 * It then calculates the sum of even digits in the array by filtering the elements that are divisible by 2 using `filter((element) => element % 2 === 0)`
 * and reducing the filtered elements to their sum using `reduce((a, b) => a + b, 0)`.
 * The sum of even digits is assigned to the variable `evenSum`.
 *
 * Similarly, it calculates the sum of odd digits in the array by filtering the elements that are not divisible by 2 using `filter((element) => element % 2 !== 0)`
 * and reducing the filtered elements to their sum using `reduce((a, b) => a + b, 0)`.
 * The sum of odd digits is assigned to the variable `oddSum`.
 *
 * Finally, it logs the sums of odd and even digits using `console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`)`.
 *
 * Example usage:
 * - Calling `oddAndEvenSum(3495892137259234)` will output "Odd sum = 35, Even sum = 30".
 */
function oddAndEvenSum(num) {
  const arr = Array.from(String(num), Number);
  const evenSum = arr
    .filter((element) => element % 2 === 0)
    .reduce((a, b) => a + b, 0);
  const oddSum = arr
    .filter((element) => element % 2 !== 0)
    .reduce((a, b) => a + b, 0);
  console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
}

oddAndEvenSum(3495892137259234);
