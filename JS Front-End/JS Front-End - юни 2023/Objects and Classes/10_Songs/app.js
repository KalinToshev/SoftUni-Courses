/**
 * The `songs_app` function takes an array of input representing songs.
 * The first element of the input array indicates the total number of songs.
 * The last element of the input array indicates the type of songs to be printed.
 * Each song is described by three parts: type, name, and time, separated by underscores.
 * The function creates `Song` objects based on the input descriptions and stores them in an array.
 * Each `Song` object has properties for type, name, and time.
 * The function then filters the songs based on the specified type and prints the names of the filtered songs.
 * If the type is "all", it prints the names of all the songs.
 *
 * Example usage:
 * - const input = [
 *     4,
 *     "favourite_DownTown_3:14",
 *     "listenLater_Andalouse_3:24",
 *     "favourite_In To The Night_3:58",
 *     "favourite_Live It Up_3:48",
 *     "listenLater",
 *   ];
 *   songs_app(input);
 *   - Creates four `Song` objects with the given type, name, and time.
 *   - Prints the names of the songs based on the type "listenLater".
 *
 * The above example will output:
 *   Andalouse
 *
 * Note: The output may vary depending on the input.
 */
function songs_app(input) {
  class Song {
    constructor(type, name, time) {
      this.type = type;
      this.name = name;
      this.time = time;
    }
  }

  let songs = [];
  let numberOfSongs = input.shift();
  let typeSong = input.pop();

  for (let i = 0; i < numberOfSongs; i++) {
    let [type, name, time] = input[i].split("_");
    let song = new Song(type, name, time);
    songs.push(song);
  }

  if (typeSong === "all") {
    songs.forEach((i) => console.log(i.name));
  } else {
    let filtered = songs.filter((i) => i.type === typeSong);
    filtered.forEach((i) => console.log(i.name));
  }
}

songs_app([
  4,
  "favourite_DownTown_3:14",
  "listenLater_Andalouse_3:24",
  "favourite_In To The Night_3:58",
  "favourite_Live It Up_3:48",
  "listenLater",
]);
