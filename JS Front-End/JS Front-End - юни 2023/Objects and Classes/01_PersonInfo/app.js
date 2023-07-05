/**
 * The function `createPerson` creates and returns an object representing a person. It takes three parameters: `firstName`, `lastName`, and `age`.
 *
 * Inside the function, a new object named `person` is created using object literal shorthand notation.
 * The properties `firstName`, `lastName`, and `age` are assigned the respective parameter values.
 *
 * Finally, the `person` object is returned from the function.
 *
 * Example usage:
 * - Calling `createPerson("Ivan", "Ivanov", "20")` will return an object:
 *   {
 *     firstName: "Ivan",
 *     lastName: "Ivanov",
 *     age: "20"
 *   }
 *   This object represents a person with the first name "Ivan", last name "Ivanov", and age "20".
 *   The returned object is then assigned to the variable `personIvan` and logged to the console using `console.log()`.
 */
function createPerson(firstName, lastName, age) {
  const person = {
    firstName,
    lastName,
    age,
  };

  return person;
}

const personIvan = createPerson("Ivan", "Ivanov", "20");
console.log(personIvan);
