/**
 * Class representing a Hero.
 * @class
 */
class Hero {
  /**
   * Create a Hero.
   * @constructor
   * @param {string} name - The name of the hero.
   * @param {number} level - The level of the hero.
   * @param {string[]} items - The items of the hero.
   */
  constructor(name, level, items) {
    this.name = name;
    this.level = level;
    this.items = items;
  }

  /**
   * Get the string representation of the hero.
   * @returns {string} The string representation of the hero.
   */
  toString() {
    return `Hero: ${this.name}\nlevel => ${
      this.level
    }\nitems => ${this.items.join(", ")}`;
  }
}

/**
 * Class representing a Heroes Register.
 * @class
 */
class HeroesRegister {
  /**
   * Create a Heroes Register.
   * @constructor
   */
  constructor() {
    this.heroes = [];
  }

  /**
   * Add a hero to the register.
   * @param {string} heroData - The data of the hero in the format "name / level / item1, item2, ..."
   */
  addHero(heroData) {
    const [name, level, itemsString] = heroData.split(" / ");
    const items = itemsString.split(", ");
    const hero = new Hero(name, Number(level), items);
    this.heroes.push(hero);
  }

  /**
   * Print the data of all heroes in the register.
   */
  printHeroes() {
    this.heroes
      .sort((a, b) => a.level - b.level)
      .forEach((hero) => console.log(hero.toString()));
  }
}

// Example usage
const input = [
  "Isacc / 25 / Apple, GravityGun",
  "Derek / 12 / BarrelVest, DestructionSword",
  "Hes / 1 / Desolator, Sentinel, Antara",
];

const register = new HeroesRegister();
input.forEach((heroData) => register.addHero(heroData));
register.printHeroes();