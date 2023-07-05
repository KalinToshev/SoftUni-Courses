/**
 * The `cats` function takes an array of cat descriptions as input.
 * Each cat description consists of a name and an age separated by a space.
 * The function creates `Cat` objects based on the descriptions and stores them in an array.
 * Each `Cat` object has a `meow` method that prints a message with the cat's name and age.
 * Finally, it calls the `meow` method for each cat in the array to make them meow.
 *
 * Example usage:
 * - const input = ["Mellow 2", "Tom 5"];
 *   cats(input);
 *   - Creates two `Cat` objects with the names "Mellow" and "Tom" and ages 2 and 5 respectively.
 *   - Prints the messages "Mellow, age 2 says Meow" and "Tom, age 5 says Meow".
 *
 * The above example will output:
 *   Mellow, age 2 says Meow
 *   Tom, age 5 says Meow
 */
function cats(input) {
  let cats = [];

  class Cat {
    constructor(name, age) {
      this.name = name;
      this.age = age;
    }

    meow() {
      console.log(`${this.name}, age ${this.age} says Meow`);
    }
  }

  input.forEach((element) => {
    const [name, age] = element.split(" ");
    const cat = new Cat(name, age);
    cats.push(cat);
  });

  cats.forEach((cat) => {
    cat.meow();
  });
}

cats(["Mellow 2", "Tom 5"]);
