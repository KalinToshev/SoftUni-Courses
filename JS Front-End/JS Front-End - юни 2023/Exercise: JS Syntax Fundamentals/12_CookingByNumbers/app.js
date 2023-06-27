/**
 * Performs cooking operations on a number based on the given commands.
 *
 * @param {number} number - The initial number to be cooked.
 * @param {...string} commands - The cooking commands to be executed.
 * @returns {void} - Prints the intermediate results after each command.
 */
function cookNumber(number, ...commands) {
  let sum = Number(number);

  // Iterate over each command in the commands array
  for (let index = 0; index < commands.length; index++) {
    let command = commands[index];

    // Execute the corresponding cooking operation based on the command
    switch (command) {
      case "chop":
        sum /= 2; // Divide the number by 2
        break;
      case "dice":
        sum = Math.sqrt(sum); // Take the square root of the number
        break;
      case "spice":
        sum += 1; // Add 1 to the number
        break;
      case "bake":
        sum *= 3; // Multiply the number by 3
        break;
      case "fillet":
        sum -= sum * 0.2; // Reduce the number by 20%
        break;
    }

    // Print the intermediate result after each command
    console.log(sum);
  }
}

cookNumber("9", "dice", "spice", "chop", "bake", "fillet");
