function attachEvents() {
  // Function to make a GET request
  async function fetchData(url) {
    const response = await fetch(url);
    const data = await response.json();
    return data;
  }

  // Function to create and append an option element to the posts select element
  function createPostOption(post) {
    const option = document.createElement("option");
    option.value = post.id;
    option.textContent = post.title;
    document.getElementById("posts").appendChild(option);
  }

  // Function to clear the options inside the "posts" select element
  function clearPostsOptions() {
    const postsSelect = document.getElementById("posts");
    postsSelect.innerHTML = "";
  }

  // Function to display the post details and comments
  function displayPostDetails(post, comments) {
    // Display the post title and body
    document.getElementById("post-title").textContent = post.title;
    document.getElementById("post-body").textContent = post.body;

    // Display the comments
    const postCommentsUl = document.getElementById("post-comments");
    postCommentsUl.innerHTML = ""; // Clear previous comments

    comments.forEach((comment) => {
      if (comment.postId === post.id) {
        const li = document.createElement("li");
        li.textContent = comment.text;
        li.setAttribute("id", `${comment.id}`); // Set the id attribute for each comment
        postCommentsUl.appendChild(li);
      }
    });
  }

  // Function to load posts and populate the posts select element
  async function loadPosts() {
    // Clear existing options
    clearPostsOptions();

    const postsData = await fetchData(
      "http://localhost:3030/jsonstore/blog/posts"
    );
    for (const postId in postsData) {
      createPostOption(postsData[postId]);
    }

    // Load the post details for the first option placed
    const firstOptionValue = document.querySelector(
      "#posts option:first-child"
    ).value;
    if (firstOptionValue) {
      const firstOptionPost = postsData[firstOptionValue];
      const commentsData = await fetchData(
        "http://localhost:3030/jsonstore/blog/comments"
      );
      const comments = Object.values(commentsData);
      displayPostDetails(firstOptionPost, comments);
    }
  }

  // Immediately Invoked Function Expression (IIFE) to load posts and details on page load
  (async function () {
    await loadPosts();
  })();

  // Event listener for the "Load Posts" button
  document.getElementById("btnLoadPosts").addEventListener("click", loadPosts);

  // Function to handle the "View Post" button click
  async function viewPost() {
    const selectedPostId = document.getElementById("posts").value;
    if (!selectedPostId) {
      alert("Please select a post.");
      return;
    }

    const postsData = await fetchData(
      "http://localhost:3030/jsonstore/blog/posts"
    );
    const commentsData = await fetchData(
      "http://localhost:3030/jsonstore/blog/comments"
    );

    const selectedPost = postsData[selectedPostId];
    const comments = Object.values(commentsData);

    displayPostDetails(selectedPost, comments);
  }

  // Event listener for the "View Post" button
  document.getElementById("btnViewPost").addEventListener("click", viewPost);
}

attachEvents();
