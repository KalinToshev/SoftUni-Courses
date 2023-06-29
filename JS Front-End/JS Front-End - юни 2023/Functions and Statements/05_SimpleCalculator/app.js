/**
 * The code defines an object named calculator that contains arrow functions for arithmetic operations.
 * - multiply: Multiplies two numbers.
 * - divide: Divides the first number by the second number.
 * - sum: Adds two numbers.
 * - subtract: Subtracts the second number from the first number.
 * The calculate function takes in two numbers (num1 and num2) and an operation (operation).
 * It checks if the operation exists as a property in the calculator object.
 * If the operation is found, it invokes the corresponding arrow function with the given numbers as arguments and returns the result.
 * If the operation is not found, it returns 0.
 * Example usage:
 * Calling calculate(5, 5, "multiply") will return the result of multiplying 5 and 5, which is 25.
 * The result is stored in the result variable and then printed on the console using console.log.
*/
const calculator = {
  multiply: (a, b) => a * b,
  divide: (a, b) => a / b,
  sum: (a, b) => a + b,
  subtract: (a, b) => a - b,
};

const calculate = (num1, num2, operation) =>
  calculator[operation] ? calculator[operation](num1, num2) : 0;

const result = calculate(5, 5, "multiply");
console.log(result);
