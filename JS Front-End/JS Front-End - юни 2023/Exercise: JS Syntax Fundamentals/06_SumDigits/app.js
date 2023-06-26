/**
* Calculates the sum of all digits in a given number.
*
* @param {number} number - The number whose digits will be summed.
*/
function sumAllDigitsFromGivenNumber(number) {
  //Split the number into digits arr
  let digits = number.toString().split("");
  //Initialize sum variable to store the sum of the digits
  let sum = 0;
  for (let digit of digits) {
    //Turn each digit of digits arr into number type 
    //and add it to sum variable
    sum += Number(digit);
  }
  //Output the sum variable value
  console.log(sum);
}

sumAllDigitsFromGivenNumber(245678);
