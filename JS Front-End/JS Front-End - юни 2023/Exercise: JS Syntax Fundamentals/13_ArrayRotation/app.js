/**
 * Rotates an array by the specified number of rotations.
 * The first element goes to the end depending on the number of rotations.
 *
 * @param {Array} arr - The input array.
 * @param {number} rotations - The number of rotations to perform.
 * @returns {void} - Prints the resulting array elements separated by a single space.
 */
function rotateArray(arr, rotations) {
  // Calculate the effective number of rotations within the length of the array
  const effectiveRotations = rotations % arr.length;

  // Slice the array into two parts and rearrange them based on the rotations
  const rotatedArray = [
    ...arr.slice(effectiveRotations),
    ...arr.slice(0, effectiveRotations),
  ];

  // Print the resulting array elements separated by a single space
  console.log(rotatedArray.join(" "));
}

rotateArray([51, 47, 32, 61, 21], 2);
