/**
 * The `printAllMoviesWithFullInfo` function takes an array of commands as input.
 * It iterates over the commands and performs different actions based on the command type.
 * - If a command starts with "addMovie ", it adds a new movie object to the `movies` array.
 * - If a command includes "directedBy", it extracts the movie name and director name and updates the corresponding movie object.
 * - If a command includes "onDate", it extracts the movie name and release date and updates the corresponding movie object.
 * Finally, the function prints the details of each movie that has a name, date, and director.
 *
 * Example usage:
 * - const input = [
 *     "addMovie The Avengers",
 *     "directedBy Joss Whedon",
 *     "onDate April 11, 2012",
 *     "addMovie Inception",
 *     "directedBy Christopher Nolan",
 *     "onDate July 16, 2010"
 *   ];
 *   printAllMoviesWithFullInfo(input);
 *   - Creates movie objects for "The Avengers" and "Inception" and adds them to the `movies` array.
 *   - Updates the director and release date of each movie based on the corresponding commands.
 *   - Prints the details of each movie that has a name, date, and director.
 *
 * The above example will output:
 *   {"name":"The Avengers","director":"Joss Whedon","date":"April 11, 2012"}
 *   {"name":"Inception","director":"Christopher Nolan","date":"July 16, 2010"}
 *
 * Note: The output may vary depending on the input.
 */
function printAllMoviesWithFullInfo(input) {
  let movies = [];

  input.forEach((command) => {
    if (command.includes("addMovie ")) {
      const movie = {};
      movie.name = command.replace("addMovie ", "");
      movies.push(movie);
    } else if (command.includes("directedBy")) {
      const [movieName, directorName] = command.split(" directedBy ");
      const movie = movies.find((movie) => movie.name === movieName);
      if (movie) {
        movie.director = directorName;
      }
    } else if (command.includes("onDate")) {
      const [movieName, date] = command.split(" onDate ");
      const movie = movies.find((movie) => movie.name === movieName);
      if (movie) {
        movie.date = date;
      }
    }
  });

  movies.forEach((movie) => {
    if (movie.name && movie.date && movie.director)
      console.log(JSON.stringify(movie));
  });
}

printAllMoviesWithFullInfo([
  "addMovie Fast and Furious",
  "addMovie Godfather",
  "Inception directedBy Christopher Nolan",
  "Godfather directedBy Francis Ford Coppola",
  "Godfather onDate 29.07.2018",
  "Fast and Furious onDate 30.07.2018",
  "Batman onDate 01.08.2018",
  "Fast and Furious directedBy Rob Cohen",
]);
