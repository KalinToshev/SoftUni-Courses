/**
 * The function `validatePassword` takes a `password` string as input and performs several checks to validate the password.
 *
 * It uses regular expressions to define the following validation patterns:
 * - `lengthRegex`: Password must be between 6 and 10 characters long.
 * - `lettersDigitsRegex`: Password must consist only of letters (uppercase and lowercase) and digits.
 * - `digitsRegex`: Password must have at least 2 digits.
 *
 * The function initializes a variable `isValid` as `true`, assuming the password is valid initially.
 *
 * It checks each validation condition using the corresponding regular expression and if any condition fails, it logs an error message and sets `isValid` to `false`.
 *
 * After all the checks, if `isValid` is still `true`, it logs a success message indicating that the password is valid.
 *
 * Example usage:
 * - Calling `validatePassword("logIn")` will output:
 *   - Password must be between 6 and 10 characters
 * - Calling `validatePassword("MyPass123")` will output:
 *   - Password is valid
 * - Calling `validatePassword("Pa$s$s")` will output:
 *   - Password must have at least 2 digits
 */
function validatePassword(password) {
  const lengthRegex = /^.{6,10}$/;
  const lettersDigitsRegex = /^[a-zA-Z0-9]+$/;
  const digitsRegex = /\d/g;

  let isValid = true;

  if (!lengthRegex.test(password)) {
    console.log("Password must be between 6 and 10 characters");
    isValid = false;
  }

  if (!lettersDigitsRegex.test(password)) {
    console.log("Password must consist only of letters and digits");
    isValid = false;
  }

  if ((password.match(digitsRegex) || []).length < 2) {
    console.log("Password must have at least 2 digits");
    isValid = false;
  }

  if (isValid) {
    console.log("Password is valid");
  }
}

validatePassword("logIn");
validatePassword("MyPass123");
validatePassword("Pa$s$s");
