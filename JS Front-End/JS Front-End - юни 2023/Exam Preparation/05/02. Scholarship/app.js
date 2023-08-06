window.addEventListener("load", solve);

function solve() {
  const nextBtn = document.querySelector("#next-btn");

  const ulPreviewElement = document.querySelector("#preview-list");

  const ulCandidatesElement = document.querySelector("#candidates-list");

  nextBtn.addEventListener("click", applyForScholarship);

  function applyForScholarship(e) {
    e.preventDefault();

    const studentName = document.querySelector("#student");
    const university = document.querySelector("#university");
    const score = document.querySelector("#score");

    if (
      studentName.value === "" ||
      university.value === "" ||
      score.value === ""
    ) {
      return;
    }

    const liElement = createLiElement(studentName, university, score);

    ulPreviewElement.appendChild(liElement);

    e.target.disabled = true;

    clearFields(studentName, university, score);
  }

  function clearFields(studentName, university, score) {
    studentName.value = "";
    university.value = "";
    score.value = "";
  }

  function createLiElement(studentName, university, score) {
    const liElement = document.createElement("li");
    liElement.classList.add("application");

    const articleElement = document.createElement("article");

    const h4Element = document.createElement("h4");
    h4Element.textContent = studentName.value;

    const pElement = document.createElement("p");
    pElement.textContent = `University: ${university.value}`;

    const pElement2 = document.createElement("p");
    pElement2.textContent = `Score: ${score.value}`;

    articleElement.appendChild(h4Element);
    articleElement.appendChild(pElement);
    articleElement.appendChild(pElement2);

    const editBtn = document.createElement("button");
    editBtn.classList.add("action-btn", "edit");
    editBtn.textContent = "edit";

    editBtn.addEventListener("click", editStudent);

    function editStudent(e) {
      e.preventDefault();

      const editBtn = e.target;
      const liElement = editBtn.parentElement;

      const studentName = liElement.querySelector("h4").textContent;
      const university = liElement
        .querySelector("p:nth-of-type(1)")
        .textContent.split(": ")[1];
      const score = liElement
        .querySelector("p:nth-of-type(2)")
        .textContent.split(": ")[1];

      const studentNameInput = document.querySelector("#student");
      const universityInput = document.querySelector("#university");
      const scoreInput = document.querySelector("#score");

      studentNameInput.value = studentName;
      universityInput.value = university;
      scoreInput.value = score;

      ulPreviewElement.removeChild(liElement);

      nextBtn.disabled = false;
    }

    const applyBtn = document.createElement("button");
    applyBtn.classList.add("action-btn", "apply");
    applyBtn.textContent = "apply";

    applyBtn.addEventListener("click", applyStudent);

    function applyStudent(e) {
      e.preventDefault();

      nextBtn.removeAttribute("disabled");

      liElement.removeChild(editBtn);
      liElement.removeChild(applyBtn);

      ulCandidatesElement.appendChild(liElement);

      ulPreviewElement.removeChild(liElement);

    }

    liElement.appendChild(articleElement);
    liElement.appendChild(editBtn);
    liElement.appendChild(applyBtn);

    return liElement;
  }
}
