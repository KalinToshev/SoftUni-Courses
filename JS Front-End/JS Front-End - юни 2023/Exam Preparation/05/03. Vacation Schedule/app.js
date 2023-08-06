/*
<div class="container">
<h2>Carren Davis</h2>
<h3>2023-06-09</h3>
<h3>5</h3>
<button class="change-btn">Change</button>
<button class="done-btn">Done</button>
</div>
*/

const baseURL = "http://localhost:3030/jsonstore/tasks/";

const loadVacationsBtn = document.getElementById("load-vacations");

loadVacationsBtn.addEventListener("click", loadVacations);

const addVacationBtn = document.getElementById("add-vacation");

addVacationBtn.addEventListener("click", addVacation);

async function loadVacations(e) {
  e.preventDefault();

  const response = await fetch(baseURL);
  const data = await response.json();

  const vacations = Object.values(data);

  const vacationsContainer = document.getElementById("list");

  vacationsContainer.innerHTML = "";

  vacations.forEach((v) => {
    const div = document.createElement("div");
    div.classList.add("container");

    const h2 = document.createElement("h2");
    h2.textContent = v.name;

    const h3 = document.createElement("h3");
    h3.textContent = v.date;

    const h3_2 = document.createElement("h3");
    h3_2.textContent = v.days;

    const changeBtn = document.createElement("button");
    changeBtn.classList.add("change-btn");
    changeBtn.textContent = "Change";

    changeBtn.addEventListener("click", async (e) => {
      e.preventDefault();

      const editBtn = document.getElementById("edit-vacation");
      editBtn.disabled = false;

      const addBtn = document.getElementById("add-vacation");
      addBtn.disabled = true;

      const name = document.getElementById("name");
      name.value = v.name;

      const date = document.getElementById("from-date");
      date.value = v.date;

      const days = document.getElementById("num-days");
      days.value = v.days;

      div.remove();

      editBtn.addEventListener("click", async (e) => {
        const updateResponse = await fetch(baseURL + v._id, {
          method: "PATCH",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            name: name.value,
            date: date.value,
            days: days.value,
          }),
        });

        loadVacationsBtn.click();
      });
    });

    const doneBtn = document.createElement("button");
    doneBtn.classList.add("done-btn");
    doneBtn.textContent = "Done";

    doneBtn.addEventListener("click", async (e) => {
        e.preventDefault();
    
        const deleteResponse = await fetch(baseURL + v._id, {
            method: "DELETE",
        });
    
        loadVacationsBtn.click();
    });

    div.appendChild(h2);
    div.appendChild(h3);
    div.appendChild(h3_2);
    div.appendChild(changeBtn);
    div.appendChild(doneBtn);

    vacationsContainer.appendChild(div);
  });
}

async function addVacation(e) {
  e.preventDefault();

  const name = document.getElementById("name").value;
  const date = document.getElementById("from-date").value;
  const days = document.getElementById("num-days").value;

  const response = await fetch(baseURL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ name, date, days }),
  });

  if (response.ok) {
    loadVacations(e);
  }

  document.getElementById("name").value = "";
  document.getElementById("from-date").value = "";
  document.getElementById("num-days").value = "";
}
