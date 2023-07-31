window.addEventListener("load", solve);

function solve() {
  const publishBtn = document.querySelector("#publish-btn");

  const inputFields = {
    title: document.querySelector("#task-title"),
    category: document.querySelector("#task-category"),
    content: document.querySelector("#task-content"),
  };

  const taskForReviewUl = document.querySelector("#review-list");

  publishBtn.addEventListener("click", () => {
    const title = inputFields.title.value;
    const category = inputFields.category.value;
    const content = inputFields.content.value;

    if (title === "" || category === "" || content === "") {
      alert("All fields are required!");
      return;
    }

    const h4Element = document.createElement("h4");
    h4Element.textContent = title;

    const pCategoryElement = document.createElement("p");
    pCategoryElement.textContent = `Category: ${category}`;

    const pContentElement = document.createElement("p");
    pContentElement.textContent = `Content: ${content}`;

    const articleElement = document.createElement("article");
    articleElement.appendChild(h4Element);
    articleElement.appendChild(pCategoryElement);
    articleElement.appendChild(pContentElement);

    const editBtn = document.createElement("button");
    editBtn.textContent = "Edit";
    editBtn.classList.add("action-btn", "edit");

    editBtn.addEventListener("click", (e) => {
      inputFields.title.value =
        e.currentTarget.parentElement.querySelector("h4").textContent;
      inputFields.category.value = e.currentTarget.parentElement
        .querySelector("p:nth-of-type(1)")
        .textContent.split(": ")[1];
      inputFields.content.value = e.currentTarget.parentElement
        .querySelector("p:nth-of-type(2)")
        .textContent.split(": ")[1];

      e.currentTarget.parentElement.remove();
    });

    const postBtn = document.createElement("button");
    postBtn.textContent = "Post";
    postBtn.classList.add("action-btn", "post");

    postBtn.addEventListener("click", (e) => {
      let post = e.currentTarget.parentElement;
      let clonedPost = post.cloneNode(true);

      clonedPost.querySelector(".edit").remove();
      clonedPost.querySelector(".post").remove();

      document.querySelector("#published-list").appendChild(clonedPost);

      e.currentTarget.parentElement.remove();
    });

    const liElement = document.createElement("li");
    liElement.classList.add("rpost");

    liElement.appendChild(articleElement);
    liElement.appendChild(editBtn);
    liElement.appendChild(postBtn);

    taskForReviewUl.appendChild(liElement);

    //Clear input fields
    inputFields.title.value = "";
    inputFields.category.value = "";
    inputFields.content.value = "";
  });
}