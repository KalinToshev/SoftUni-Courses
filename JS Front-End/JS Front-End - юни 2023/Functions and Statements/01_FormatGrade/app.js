/**
 * Formats a grade based on a given numerical value and prints the result.
 *
 * @param {number} grade - The numerical grade to format.
 */
function formatGrade(grade) {
  let result = "";

  if (grade < 3.0) {
    result = "Fail (2)";
  } else if (grade < 3.5) {
    result = `Poor (${grade.toFixed(2)})`;
  } else if (grade < 4.5) {
    result = `Good (${grade.toFixed(2)})`;
  } else if (grade < 5.5) {
    result = `Very good (${grade.toFixed(2)})`;
  } else {
    result = `Excellent (${grade.toFixed(2)})`;
  }

  console.log(result);
}

// Example usage:
formatGrade(3.33); //Output: Poor (3.33)
formatGrade(4.5); //Output: Very good (4.50)
formatGrade(2.99); //Output: Fail (2)
