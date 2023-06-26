/**
* Prints a multiplication table (from 1 to 10) for a given number.
*
* @param {number} num - The number for which the multiplication table will be generated.
*/
function multiplicationTable(num) {
  for (let index = 1; index <= 10; index++) {
    console.log(`${num} X ${index} = ${num * index}`);
  }
}

multiplicationTable(2);
