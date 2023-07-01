/**
 * The function `palindromeIntegers` takes an array `arrWithPositiveNums` containing positive integers.
 *
 * It uses the `forEach` method to iterate over each element in the array.
 * For each element, it converts it to a string using `toString()` method and assigns it to `normalElement`.
 * It then uses `split("")` to split `normalElement` into an array of characters, `reversedElement`, and reverses the order of the characters using `reverse()`.
 * After that, it joins the characters of `reversedElement` back into a string using `join("")`.
 *
 * It compares `normalElement` with `reversedElement` to check if they are equal, assigning the result to `isPalindrome`.
 * If they are equal, it means the original number is a palindrome, and it logs `true`. Otherwise, it logs `false`.
 *
 * Example usage:
 * - Calling `palindromeIntegers([123, 323, 421, 121])` will output:
 *   - false (123 is not a palindrome)
 *   - true (323 is a palindrome)
 *   - false (421 is not a palindrome)
 *   - true (121 is a palindrome)
 */
function palindromeIntegers(arrWithPositiveNums) {
  arrWithPositiveNums.forEach((element) => {
    const normalElement = element.toString();
    const reversedElement = normalElement.split("").reverse().join("");
    const isPalindrome = normalElement === reversedElement;
    console.log(isPalindrome);
  });
}

palindromeIntegers([123, 323, 421, 121]);
