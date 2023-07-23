function attachEvents() {
  const loadButton = document.querySelector("#btnLoad");
  const createButton = document.querySelector("#btnCreate");
  const personInputField = document.querySelector("#person");
  const phoneInputField = document.querySelector("#phone");
  const phonebook = document.querySelector("#phonebook");

  function loadPhonebook() {
    phonebook.innerHTML = "";

    fetch("http://localhost:3030/jsonstore/phonebook")
      .then((res) => res.text())
      .then((body) => {
        let records = Object.values(JSON.parse(body));

        records.forEach((r) => {
          const person = r.person;
          const phone = r.phone;
          const id = r._id;

          const personLi = document.createElement("li");
          personLi.textContent = `${person}: ${phone}`;
          personLi.id = id;

          const deleteButton = document.createElement("button");
          deleteButton.textContent = "Delete";
          deleteButton.classList.add("btnDelete");

          personLi.appendChild(deleteButton);

          phonebook.appendChild(personLi);
        });

        deleteRecord(Array.from(document.querySelectorAll(".btnDelete")));
      });
  }

  function deleteRecord(deleteButtons) {
    deleteButtons.forEach((b) => {
      b.addEventListener("click", (e) => {
        const id = e.currentTarget.parentElement.id;

        fetch(`http://localhost:3030/jsonstore/phonebook/${id}`, {
          method: "delete",
        });

        document.getElementById(`${id}`).remove();
      });
    });
  }

  loadButton.addEventListener("click", loadPhonebook);

  createButton.addEventListener("click", () => {
    const person = personInputField.value;
    const phone = phoneInputField.value;

    let newContact = {
      person: person,
      phone: phone,
    };

    fetch("http://localhost:3030/jsonstore/phonebook", {
      method: "post",
      headers: { "Content-type": "application/json" },
      body: JSON.stringify(newContact),
    });

    personInputField.value = "";
    phoneInputField.value = "";
  });
}

attachEvents();
