function solve(input) {
  const numberOfRiders = Number(input.shift());

  let riders = {};

  for (let i = 0; i < numberOfRiders; i++) {
    let [rider, fuel, position] = input.shift().split("|");
    fuel = Number(fuel);
    position = Number(position);

    riders[rider] = {
      name: rider,
      fuel,
      position,
    };
  }

  let line = input.shift();

  while (line !== "Finish") {
    const command = line.split(" - ")[0];

    switch (command) {
      case "StopForFuel":
        const [_, rider, minimumFuel, changedPosition] = line.split(" - ");

        if (riders[rider].fuel < Number(minimumFuel)) {
          console.log(
            `${rider} stopped to refuel but lost his position, now he is ${changedPosition}.`
          );
          riders[rider].position = changedPosition;
        } else {
          console.log(`${rider} does not need to stop for fuel!`);
        }
        break;
      case "Overtaking":
        const [__, rider1, rider2] = line.split(" - ");

        if (riders[rider1].position < riders[rider2].position) {
          const temp = riders[rider1].position;
          riders[rider1].position = riders[rider2].position;
          riders[rider2].position = temp;

          console.log(`${rider1} overtook ${rider2}!`);
        }
        break;
      case "EngineFail":
        const [___, riderName, lapsLeft] = line.split(" - ");

        console.log(
          `${riderName} is out of the race because of a technical issue, ${lapsLeft} laps before the finish.`
        );

        delete riders[riderName];
        break;
    }

    line = input.shift();
  }

  Object.values(riders).forEach((rider) => {
    console.log(`${rider.name}`);
    console.log(`  Final position: ${rider.position}`);
  });
}

/*
solve([
  "3",
  "Valentino Rossi|100|1",
  "Marc Marquez|90|2",
  "Jorge Lorenzo|80|3",
  "StopForFuel - Valentino Rossi - 50 - 1",
  "Overtaking - Marc Marquez - Jorge Lorenzo",
  "EngineFail - Marc Marquez - 10",
  "Finish",
]);
*/

/*
solve([
  "4",
  "Valentino Rossi|100|1",
  "Marc Marquez|90|3",
  "Jorge Lorenzo|80|4",
  "Johann Zarco|80|2",
  "StopForFuel - Johann Zarco - 90 - 5",
  "Overtaking - Marc Marquez - Jorge Lorenzo",
  "EngineFail - Marc Marquez - 10",
  "Finish",
]);
*/
