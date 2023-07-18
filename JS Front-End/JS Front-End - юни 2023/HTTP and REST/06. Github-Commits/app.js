function loadCommits() {
  const username = document.getElementById("username").value;
  const repo = document.getElementById("repo").value;
  const commitsList = document.getElementById("commits");
  commitsList.innerHTML = ""; // Clear the contents of the list before appending new content

  fetch(`https://api.github.com/repos/${username}/${repo}/commits`)
    .then((response) => {
      if (!response.ok) {
        throw new Error(`${response.status} (${response.statusText})`);
      }
      return response.json();
    })
    .then((data) => {
      data.forEach((commit) => {
        const listItem = document.createElement("li");
        listItem.textContent = `${commit.author.name}: ${commit.commit.message}`;
        commitsList.appendChild(listItem);
      });
    })
    .catch((error) => {
      const listItem = document.createElement("li");
      listItem.textContent = `Error: ${error.message}`;
      commitsList.appendChild(listItem);
      console.error("Error:", error);
    });
}