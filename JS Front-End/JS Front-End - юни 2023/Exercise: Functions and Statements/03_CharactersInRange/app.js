/**
 * The function `printCharacters` takes in two characters `char1` and `char2`.
 *
 * Inside the function, it first obtains the Unicode code point of `char1` using `char1.charCodeAt(0)`
 * and assigns it to the variable `startCode`.
 * It also obtains the Unicode code point of `char2` using `char2.charCodeAt(0)`
 * and assigns it to the variable `endCode`.
 *
 * Then, it declares an empty array `arr`.
 *
 * If `startCode` is less than `endCode`, it calls the `generateCharacterArray` helper function
 * passing `startCode + 1` and `endCode - 1` as arguments to generate an array of characters between them.
 * The resulting array is assigned to `arr`.
 *
 * If `startCode` is greater than `endCode`, it calls the `generateCharacterArray` helper function
 * passing `endCode + 1` and `startCode - 1` as arguments to generate an array of characters between them.
 * The resulting array is assigned to `arr`.
 *
 * Finally, it logs the elements of `arr` joined by a space using `console.log(arr.join(" "))`.
 *
 * The helper function `generateCharacterArray` takes in a `startCode` and `endCode`
 * and generates an array of characters by iterating from `startCode` to `endCode`.
 * It uses `String.fromCharCode(code)` to convert each code point back to its corresponding character
 * and pushes it to the `array`.
 * The function then returns the generated array.
 *
 * Example usage:
 * - Calling `printCharacters("a", "d")` will output "b c".
 * - Calling `printCharacters("#", ":")` will output "$ % & ' ( ) * + , -".
 * - Calling `printCharacters("C", "#")` will output "D E F G H I J K L M N O P Q R S T U V W X Y Z $ % & ' ( ) * + , -".
 */
function printCharacters(char1, char2) {
  const startCode = char1.charCodeAt(0);
  const endCode = char2.charCodeAt(0);
  let arr = [];

  if (startCode < endCode) {
    arr = generateCharacterArray(startCode + 1, endCode - 1);
    console.log(arr.join(" "));
  }

  if (startCode > endCode) {
    arr = generateCharacterArray(endCode + 1, startCode - 1);
    console.log(arr.join(" "));
  }

  function generateCharacterArray(startCode, endCode) {
    let array = [];

    for (let code = startCode; code <= endCode; code++) {
      array.push(String.fromCharCode(code));
    }

    return array;
  }
}

printCharacters("a", "d");
printCharacters("#", ":");
printCharacters("C", "#");
