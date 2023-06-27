/**
 * Retrieves elements from an array based on the step value.
 *
 * @param {string[]} array - The array of strings.
 * @param {number} step - The step value.
 * @returns {string[]} - The array containing elements at the specified step.
 */
function retrieveElements(array, step) {
  let result = [];

  for (let i = 0; i < array.length; i += step) {
    result.push(array[i]);
  }

  return result;
}

retrieveElements(["5", "20", "31", "4", "20"], 2);
