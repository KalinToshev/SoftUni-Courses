window.addEventListener("load", solve);

function solve() {
  const publishBtn = document.querySelector("#form-btn");

  const previewUl = document.querySelector("#preview-list");

  publishBtn.addEventListener("click", publish);

  function publish(e) {
    e.preventDefault();

    const liItem = createStoryPreview();

    previewUl.appendChild(liItem);

    // Clear input fields
    document.querySelector("#first-name").value = "";
    document.querySelector("#last-name").value = "";
    document.querySelector("#age").value = "";
    document.querySelector("#story-title").value = "";
    document.querySelector("#genre").value = "";
    document.querySelector("#story").value = "";

    //Make punlish button disabled
    publishBtn.disabled = true;
  }

  function createStoryPreview() {
    const firstNameValue = document.querySelector("#first-name").value;
    const lastNameValue = document.querySelector("#last-name").value;
    const ageValue = document.querySelector("#age").value;
    const storyTitleValue = document.querySelector("#story-title").value;
    const genreValue = document.querySelector("#genre").value;
    const storyValue = document.querySelector("#story").value;

    if (
      firstNameValue === "" ||
      lastNameValue === "" ||
      ageValue === "" ||
      storyTitleValue === "" ||
      genreValue === "" ||
      storyValue === ""
    ) {
      alert("All fields are required!");
      return;
    }

    const h4Element = document.createElement("h4");
    h4Element.textContent = `Name: ${firstNameValue} ${lastNameValue}`;

    const pAgeElement = document.createElement("p");
    pAgeElement.textContent = `Age: ${ageValue}`;

    const pTitleElement = document.createElement("p");
    pTitleElement.textContent = `Title: ${storyTitleValue}`;

    const pGenreElement = document.createElement("p");
    pGenreElement.textContent = `Genre: ${genreValue}`;

    const pStoryElement = document.createElement("p");
    pStoryElement.textContent = storyValue;

    const articleElement = document.createElement("article");
    articleElement.appendChild(h4Element);
    articleElement.appendChild(pAgeElement);
    articleElement.appendChild(pTitleElement);
    articleElement.appendChild(pGenreElement);
    articleElement.appendChild(pStoryElement);

    const saveStoryBtn = document.createElement("button");
    saveStoryBtn.textContent = "Save Story";
    saveStoryBtn.classList.add("save-btn");

    saveStoryBtn.addEventListener("click", saveStory);

    function saveStory(e) {
      e.preventDefault();

      //Remove everything from the #main element
      const mainElement = document.querySelector("div#main");

      mainElement.innerHTML = "";

      //Create h1 element
      const h1Element = document.createElement("h1");
      h1Element.textContent = "Your scary story is saved!";

      mainElement.appendChild(h1Element);
    }

    const editStroryBtn = document.createElement("button");
    editStroryBtn.textContent = "Edit Story";
    editStroryBtn.classList.add("edit-btn");

    editStroryBtn.addEventListener("click", editStory);

    function editStory(e) {
      e.preventDefault();

      //Load data from preview to form
      const firstName = document.querySelector(".story-info h4").textContent.split(" ")[1];
      const lastName = document.querySelector(".story-info h4").textContent.split(" ")[2];
      const age = document.querySelector(".story-info p:nth-of-type(1)").textContent.split(" ")[1];
      const title = document.querySelector(".story-info p:nth-of-type(2)").textContent.split(" ")[1];
      const genre = document.querySelector(".story-info p:nth-of-type(3)").textContent.split(" ")[1];
      const story = document.querySelector(".story-info p:nth-of-type(4)").textContent;

      document.querySelector("#first-name").value = firstName;
      document.querySelector("#last-name").value = lastName;
      document.querySelector("#age").value = age;
      document.querySelector("#story-title").value = title;
      document.querySelector("#genre").value = genre;
      document.querySelector("#story").value = story;

      //Remove story from preview
      e.target.parentElement.remove();

      //Make punlish button enabled
      publishBtn.disabled = false;
    }

    const deleteStoryBtn = document.createElement("button");
    deleteStoryBtn.textContent = "Delete Story";
    deleteStoryBtn.classList.add("delete-btn");

    deleteStoryBtn.addEventListener("click", deleteStory);

    function deleteStory(e) {
      e.preventDefault();

      //Remove story from preview
      e.target.parentElement.remove();

      //Make punlish button enabled
      publishBtn.disabled = false;
    }

    const liElement = document.createElement("li");
    liElement.classList.add("story-info");
    liElement.appendChild(articleElement);
    liElement.appendChild(saveStoryBtn);
    liElement.appendChild(editStroryBtn);
    liElement.appendChild(deleteStoryBtn);

    return liElement;
  }
}
