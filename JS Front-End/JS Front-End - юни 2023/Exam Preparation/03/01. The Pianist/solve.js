function solve(input) {
  const n = Number(input.shift());

  let pieces = {};

  for (let i = 0; i < n; i++) {
    const currentPiece = input.shift();

    const [name, composer, key] = currentPiece.split("|");

    pieces[name] = {
      composer,
      key,
    };
  }

  const commandLine = input.shift();

  while (commandLine !== "Stop") {
    const command = commandLine.split("|")[0];

    switch (command) {
      case "Add":
        const [piece, composer, key] = commandLine.split("|").slice(1);

        if (pieces.hasOwnProperty(piece)) {
          console.log(`${piece} is already in the collection!`);
        } else {
          pieces[piece] = {
            composer,
            key,
          };
          console.log(
            `${piece} by ${composer} in ${key} added to the collection!`
          );
        }
        break;
      case "Remove":
        const pieceToRemove = commandLine.split("|")[1];

        if (pieces.hasOwnProperty(pieceToRemove)) {
          delete pieces[pieceToRemove];
          console.log(`Successfully removed ${pieceToRemove}!`);
        } else {
          console.log(
            `Invalid operation! ${pieceToRemove} does not exist in the collection.`
          );
        }
        break;
      case "ChangeKey":
        const [pieceToChange, newKey] = commandLine.split("|").slice(1);

        if (pieces.hasOwnProperty(pieceToChange)) {
          pieces[pieceToChange].key = newKey;
          console.log(`Changed the key of ${pieceToChange} to ${newKey}!`);
        } else {
          console.log(
            `Invalid operation! ${pieceToChange} does not exist in the collection.`
          );
        }
        break;
    }

    commandLine = input.shift();
  }

  Object.keys(pieces).forEach((piece) => {
    console.log(
      `${piece} -> Composer: ${pieces[piece].composer}, Key: ${pieces[piece].key}`
    );
  });
}

solve([
  "3",
  "Fur Elise|Beethoven|A Minor",
  "Moonlight Sonata|Beethoven|C# Minor",
  "Clair de Lune|Debussy|C# Minor",
  "Add|Sonata No.2|Chopin|B Minor",
  "Add|Hungarian Rhapsody No.2|Liszt|C# Minor",
  "Add|Fur Elise|Beethoven|C# Minor",
  "Remove|Clair de Lune",
  "ChangeKey|Moonlight Sonata|C# Major",
  "Stop",
]);
