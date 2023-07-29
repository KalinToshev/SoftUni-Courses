function attachEvents() {
  //Get the button with id "load-board-btn"
  const loadBtn = document.getElementById("load-board-btn");

  //Add event listener to the button
  loadBtn.addEventListener("click", loadBoard);

  //Get the button with id "create-task-btn"
  const createBtn = document.getElementById("create-task-btn");

  //Add event listener to the button
  createBtn.addEventListener("click", createTask);

  //Create function loadBoard
  function loadBoard() {
    //Get all columns
    const toDo = document.querySelector("#todo-section .task-list");
    const inProgress = document.querySelector(
      "#in-progress-section .task-list"
    );
    const codeReview = document.querySelector(
      "#code-review-section .task-list"
    );
    const done = document.querySelector("#done-section .task-list");

    //Clear the board
    clearBoard(toDo, inProgress, codeReview, done);

    //Fetch the data from the server
    fetch("http://localhost:3030/jsonstore/tasks/")
      .then((response) => response.json())
      .then((task) => {
        Object.values(task).forEach((task) => {
          switch (task.status) {
            case "ToDo":
              addNewTaskToRelevantColumn(task, toDo, "Move to In Progress");
              break;
            case "In Progress":
              addNewTaskToRelevantColumn(
                task,
                inProgress,
                "Move to Code Review"
              );
              break;
            case "Code Review":
              addNewTaskToRelevantColumn(task, codeReview, "Move to Done");
              break;
            case "Done":
              addNewTaskToRelevantColumn(task, done, "Close");
              break;
          }
        });
      });
  }

  //Create function createTask
  function createTask() {
    //Get the input value
    const title = document.getElementById("title");
    const description = document.getElementById("description");

    //Check if the input value is empty
    if (title.value == "" || description.value == "") {
      alert("Please fill all fields!");
      return;
    }

    //Create new task
    fetch("http://localhost:3030/jsonstore/tasks/", {
      method: "post",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        title: title.value,
        description: description.value,
        status: "ToDo",
      }),
    });

    loadBoard();

    //Clear the input fields
    title.value = "";
    description.value = "";
  }

  function clearBoard(toDo, inProgress, codeReview, done) {
    toDo.innerHTML = "";
    inProgress.innerHTML = "";
    codeReview.innerHTML = "";
    done.innerHTML = "";
  }

  function addNewTaskToRelevantColumn(task, column, buttonValue) {
    const liItem = document.createElement("li");
    liItem.classList.add("task");

    const titleElement = document.createElement("h3");
    titleElement.textContent = task.title;

    const descriptionElement = document.createElement("p");
    descriptionElement.textContent = task.description;

    const buttonElement = document.createElement("button");
    buttonElement.textContent = buttonValue;

    liItem.appendChild(titleElement);
    liItem.appendChild(descriptionElement);
    liItem.appendChild(buttonElement);
    
    column.appendChild(liItem);

    // Get the button element within the newly created liItem
    const button = liItem.querySelector("button");

    // Add an event listener to the button
    button.addEventListener("click", function () {
      // Handle the button click event here
      // You can use 'task' and 'buttonValue' inside this function
      // to perform the necessary actions based on the task status and button value.
      switch (buttonValue) {
        case "Move to In Progress":
          // Implement the logic for moving the task to "In Progress" column
          moveTaskToNewColumn("Move to Code Review", "In Progress");
          loadBoard();
          break;
        case "Move to Code Review":
          // Implement the logic for moving the task to "Code Review" column
          moveTaskToNewColumn("Move to Done", "Code Review");
          loadBoard();
          break;
        case "Move to Done":
          // Implement the logic for moving the task to "Done" column
          moveTaskToNewColumn("Close", "Done");
          loadBoard();
          break;
        case "Close":
          // Implement the logic for closing the task
          fetch(`http://localhost:3030/jsonstore/tasks/${task._id}`, {
            method: "delete",
          });
          loadBoard();
          break;
      }
    });

    function moveTaskToNewColumn(buttonText, taskStatus) {
      button.textContent = buttonText;
      task.status = taskStatus;
      fetch(`http://localhost:3030/jsonstore/tasks/${task._id}`, {
        method: "put",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(task),
      });
    }
  }
}

attachEvents();
