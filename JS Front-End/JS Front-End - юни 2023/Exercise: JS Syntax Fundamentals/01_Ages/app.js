function typeOfAPerson(age) {
  let output = ""; // Variable to store the output

  if (age >= 66) {
    // If the age is 66 or above
    output = "elder"; // Set the output as "elder"
  } else if (age >= 20) {
    // If the age is between 20 and 65
    output = "adult"; // Set the output as "adult"
  } else if (age >= 14) {
    // If the age is between 14 and 19
    output = "teenager"; // Set the output as "teenager"
  } else if (age >= 3) {
    // If the age is between 3 and 13
    output = "child"; // Set the output as "child"
  } else if (age >= 0) {
    // If the age is between 0 and 2
    output = "baby"; // Set the output as "baby"
  } else {
    // If the age is negative
    output = "out of bounds"; // Set the output as "out of bounds"
  }

  console.log(output); // Print the output
}

typeOfAPerson(1); // Call the function with an example age value
