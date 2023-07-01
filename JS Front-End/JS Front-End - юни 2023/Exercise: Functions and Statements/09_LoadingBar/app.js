/**
 * The function `loadingBar` simulates a loading bar with a given percentage `num`.
 *
 * It starts by initializing a variable `loadingBar` with the string '..........', representing an empty loading bar.
 * Then, it converts `loadingBar` to an array called `progressBar` using the `split('')` method.
 *
 * If `num` is not equal to 100, it calculates the number of filled slots in the loading bar by dividing `num` by 10 and flooring the result using `Math.floor()`.
 * It then iterates over `progressBar` and replaces the empty slots with '%' up to the `filledCount`.
 *
 * After modifying `progressBar`, it prints the current progress as a percentage, followed by the updated loading bar using `console.log()`.
 * It also prints the message "Still loading..." to indicate that the loading process is ongoing.
 *
 * If `num` is equal to 100, it fills the entire `progressBar` with '%' using the `fill('%', 0, 10)` method.
 * It then prints the message "100% Complete!" and displays the full loading bar using `console.log()`.
 *
 * Example usage:
 * - Calling `loadingBar(30)` will output:
 *    "30% [%%%%......]"
 *    "Still loading..."
 */
function loadingBar(num) {
  let loadingBar = "..........";
  let progressBar = loadingBar.split("");

  if (num != 100) {
    let filledCount = Math.floor(num / 10);
    for (let i = 0; i < filledCount; i++) {
      progressBar[i] = "%";
    }

    console.log(`${num}% [${progressBar.join("")}]`);
    console.log("Still loading...");
  } else {
    progressBar.fill("%", 0, 10);
    console.log("100% Complete!");
    console.log(`[${progressBar.join("")}]`);
  }
}

// Test with parameter 30
loadingBar(30);
