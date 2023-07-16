function subtract() {
  // Get the values from the input fields
  const firstNumber = parseFloat(document.getElementById("firstNumber").value);
  const secondNumber = parseFloat(document.getElementById("secondNumber").value);

  // Perform the subtraction
  const result = firstNumber - secondNumber;

  // Display the result in the result div
  document.getElementById("result").innerText = result;
}
