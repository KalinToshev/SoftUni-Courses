function solve(input) {
  let groceries = input.shift().split("!");

  let command = input.shift();
  while (command !== "Go Shopping!") {
    switch (command.split(" ")[0]) {
      case "Urgent":
        if (groceries.includes(command.split(" ")[1])) break;

        groceries.unshift(command.split(" ")[1]);
        break;
      case "Unnecessary":
        if (!groceries.includes(command.split(" ")[1])) break;

        groceries.splice(groceries.indexOf(command.split(" ")[1]), 1);
        break;
      case "Correct":
        if (!groceries.includes(command.split(" ")[1])) break;

        groceries[groceries.indexOf(command.split(" ")[1])] = command.split(" ")[2];
        break;
      case "Rearrange":
        if (!groceries.includes(command.split(" ")[1])) break;

        groceries.splice(groceries.indexOf(command.split(" ")[1]), 1);

        groceries.push(command.split(" ")[1]);
        break;
    }

    command = input.shift();
  }

  console.log(groceries.join(", "));
}

solve([
  "Milk!Pepper!Salt!Water!Banana",
  "Urgent Salt",
  "Unnecessary Grapes",
  "Correct Pepper Onion",
  "Rearrange Grapes",
  "Correct Tomatoes Potatoes",
  "Go Shopping!",
]);
