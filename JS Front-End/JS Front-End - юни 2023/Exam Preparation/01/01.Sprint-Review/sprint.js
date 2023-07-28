function sprintReview(input) {
  //Get the first element of the array and convert it to number
  //then remove it from the array
  let n = Number(input.shift());

  //Create array to store the assignees
  let assignees = [];

  //Loop thgouth the next n elements from the array
  for (let i = 0; i < n; i++) {
    //Get the current element
    let current = input.shift();

    //Split the current element by ':'
    let [name, taskId, title, status, estimatedPoints] = current.split(":");

    //Create object to store the assignee
    //One assignee can have multiple tasks
    let assignee = {
      name,
      tasks: [],
    };

    //Create object to store the task and convert the estimatedPoints to number
    let task = {
      taskId,
      title,
      status,
      estimatedPoints: Number(estimatedPoints),
    };

    //Add the task to the assignee
    assignee.tasks.push(task);

    //Check if the assignee is already in the array
    let found = assignees.find((x) => x.name === name);

    //If the assignee is not found
    if (!found) {
      //Add the assignee to the array
      assignees.push(assignee);
    } else {
      //Get the index of the assignee and add the new task to the assignee
      let index = assignees.indexOf(found);
      assignees[index].tasks.push(task);
    }
  }

  //Loop through the next elements from the array
  for (let i = 0; i < input.length; i++) {
    //each command containing information separated with the symbol ":".
    let [command, name, taskId, title, status, estimatedPoints] =
      input[i].split(":");

    //Find the assignee with the given name
    let found = assignees.find((x) => x.name === name);

    //Switch the command
    switch (command) {
      case "Add New":
        //"Add New:{assignee}:{taskId}:{title}:{status}:{estimatedPoints}"
        //Create object to store the task and convert the estimatedPoints to number
        let task = {
          taskId,
          title,
          status,
          estimatedPoints: Number(estimatedPoints),
        };

        //Add the task to the assignee
        //If the assignee is not found
        if (!found) {
          console.log(`Assignee ${name} does not exist on the board!`);
        } else {
          //Get the index of the assignee and add the new task to the assignee
          let index = assignees.indexOf(found);
          assignees[index].tasks.push(task);
        }
        break;
      case "Change Status":
        //"Change Status:{assignee}:{taskId}:{newStatus}"
        let newStatus = input[i].split(":")[3];
        //If the assignee is not found
        if (!found) {
          console.log(`Assignee ${name} does not exist on the board!`);
        } else {
          //If the assignee does not have the task with the given taskId, print message
          let foundTask = found.tasks.find((x) => x.taskId === taskId);
          if (!foundTask) {
            console.log(`Task with ID ${taskId} does not exist for ${name}!`);
          } else {
            //Get the index of the task and change the status
            let index = found.tasks.indexOf(foundTask);
            found.tasks[index].status = newStatus;
          }
        }
        break;
      case "Remove Task":
        //"Remove Task:{assignee}:{index}"
        //Remove the task at the given index from the assignee's collection

        //If the assignee is not found
        if (!found) {
          console.log(`Assignee ${name} does not exist on the board!`);
        } else {
          //If the index is out of range, print message
          if (Number(taskId) < 0 || Number(taskId) > found.tasks.length - 1) {
            console.log(`Index is out of range!`);
            break;
          }

          //Remove the assignee at the given index
          found.tasks.splice(Number(taskId), 1);
        }
        break;
    }
  }

  //Print the total points of all ToDo, In Progress, Code Review, and Done tasks, each on a new line
  let totalToDo = 0;
  let totalInProgress = 0;
  let totalCodeReview = 0;
  let totalDone = 0;

  //Calculate the total points for each status
  for (let i = 0; i < assignees.length; i++) {
    for (let j = 0; j < assignees[i].tasks.length; j++) {
      if (assignees[i].tasks[j].status === "ToDo") {
        totalToDo += assignees[i].tasks[j].estimatedPoints;
      } else if (assignees[i].tasks[j].status === "In Progress") {
        totalInProgress += assignees[i].tasks[j].estimatedPoints;
      } else if (assignees[i].tasks[j].status === "Code Review") {
        totalCodeReview += assignees[i].tasks[j].estimatedPoints;
      } else if (assignees[i].tasks[j].status === "Done") {
        totalDone += assignees[i].tasks[j].estimatedPoints;
      }
    }
  }

  //Print the total points for each status
  console.log(`ToDo: ${totalToDo}pts`);
  console.log(`In Progress: ${totalInProgress}pts`);
  console.log(`Code Review: ${totalCodeReview}pts`);
  console.log(`Done Points: ${totalDone}pts`);

  //Decide if the sprint was successful or not
  let totalPoints = totalToDo + totalInProgress + totalCodeReview;

  //If the points of the done task is more or equal to the total points of the ToDo, In Progress,
  //and Code Review tasks, the sprint is successful
  if (totalDone >= totalPoints) {
    console.log(`Sprint was successful!`);
  } else {
    console.log(`Sprint was unsuccessful...`);
  }
}

sprintReview([
  "4",
  "Kiril:BOP-1213:Fix Typo:Done:1",
  "Peter:BOP-1214:New Products Page:In Progress:2",
  "Mariya:BOP-1215:Setup Routing:ToDo:8",
  "Georgi:BOP-1216:Add Business Card:Code Review:3",
  "Add New:Sam:BOP-1237:Testing Home Page:Done:3",
  "Change Status:Georgi:BOP-1216:Done",
  "Change Status:Will:BOP-1212:In Progress",
  "Remove Task:Georgi:3",
  "Change Status:Mariya:BOP-1215:Done",
]);
