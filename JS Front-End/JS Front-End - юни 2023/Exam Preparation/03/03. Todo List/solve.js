const todoList = document.getElementById("todo-list");

function attachEvents() {
  const loadAllButton = document.getElementById("load-button");
  loadAllButton.addEventListener("click", loadAllTasks);

  const addTaskButton = document.getElementById("add-button");
  addTaskButton.addEventListener("click", addTask);
}

async function addTask(e) {
  const taskInput = document.getElementById("title");
  const task = { name: taskInput.value };

  const response = await fetch("http://localhost:3030/jsonstore/tasks/", {
    method: "post",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(task),
  });

  if (response.ok) {
    taskInput.value = "";
    loadAllTasks();
  }
}

async function loadAllTasks(e) {
  todoList.innerHTML = "";

  const response = await fetch("http://localhost:3030/jsonstore/tasks/");
  const data = await response.json();

  const tasks = Object.values(data);

  tasks.forEach((task) => {
    const li = document.createElement("li");
    li.setAttribute("data-id", task._id);

    const span = document.createElement("span");
    span.textContent = task.name;

    const removeButton = document.createElement("button");
    removeButton.textContent = "Remove";

    removeButton.addEventListener("click", async (e) => {
      const id = e.target.parentNode.getAttribute("data-id");
      const response = await fetch(
        `http://localhost:3030/jsonstore/tasks/${id}`,
        {
          method: "delete",
        }
      );

      if (response.ok) {
        loadAllTasks();
      }
    });

    const editButton = document.createElement("button");
    editButton.textContent = "Edit";

    editButton.addEventListener("click", async (e) => {
      const submitBtn = document.createElement("button");
      submitBtn.textContent = "Submit";

      const inputField = document.createElement("input");
      inputField.setAttribute("type", "text");
      inputField.value = task.name;

      editButton.replaceWith(submitBtn);
      span.replaceWith(inputField);

      submitBtn.addEventListener("click", async (e) => {
        const name = inputField.value;

        const response = await fetch(
            `http://localhost:3030/jsonstore/tasks/${task._id}`,
            {
                method: "put",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ name }),
            }
        );

        if (response.ok) {
            loadAllTasks();
        }
      });
    });

    li.appendChild(span);
    li.appendChild(removeButton);
    li.appendChild(editButton);

    todoList.appendChild(li);
  });
}

attachEvents();
