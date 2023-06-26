/**
* Prints a series of numbers and calculates their sum.
*
* @param {number} startNum - The starting number of the series.
* @param {number} endNum - The ending number of the series.
*/
function printSum(startNum, endNum) {
  let result = 0;
  let numbersOutput = "";
  for (let index = startNum; index <= endNum; index++) {
    numbersOutput += `${index} `;
    result += index;
  }
  console.log(numbersOutput);
  console.log(`Sum: ${result}`);
}

printSum(0, 26);
