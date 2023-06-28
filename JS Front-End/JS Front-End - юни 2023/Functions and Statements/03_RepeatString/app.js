/**
 * Repeats a given string a specified number of times and returns the resulting string.
 * @param {string} str - The string to repeat.
 * @param {number} count - The number of times to repeat the string.
 * @returns {string} - The repeated string.
 */
function repeatString(str, count) {
  let newStr = "";
  createStringByRepeat();
  return newStr;
  function createStringByRepeat() {
    for (let index = 0; index < count; index++) {
      newStr += str;
    }
  }
}

console.log(solve("asd", 3));
