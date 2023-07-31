const baseUrl = "http://localhost:3030/jsonstore/tasks/";

const loadCoursesBtn = document.querySelector("#load-course");

const courseList = document.querySelector("#list");

loadCoursesBtn.addEventListener("click", (e) => {
  e.preventDefault();

  fetch(baseUrl)
    .then((res) => res.json())
    .then((data) => {
      courseList.innerHTML = "";

      Object.values(data).forEach((course) => {
        const h2Element = document.createElement("h2");
        h2Element.textContent = course.title;

        const h3Element1 = document.createElement("h3");
        h3Element1.textContent = course.teacher;

        const h3Element2 = document.createElement("h3");
        h3Element2.textContent = course.type;

        const h4Element = document.createElement("h4");
        h4Element.textContent = course.description;

        const editCourseBtn = document.createElement("button");
        editCourseBtn.textContent = "Edit Course";
        editCourseBtn.classList.add("edit-btn");

        const finishCourseBtn = document.createElement("button");
        finishCourseBtn.textContent = "Finish Course";
        finishCourseBtn.classList.add("finish-btn");

        const containerElement = document.createElement("div");
        containerElement.classList.add("container");
        containerElement.setAttribute("data-id", course._id);

        containerElement.appendChild(h2Element);
        containerElement.appendChild(h3Element1);
        containerElement.appendChild(h3Element2);
        containerElement.appendChild(h4Element);
        containerElement.appendChild(editCourseBtn);
        containerElement.appendChild(finishCourseBtn);

        courseList.appendChild(containerElement);

        finishCourseBtn.addEventListener("click", (e) => {
            e.preventDefault();
    
            const id = e.currentTarget.parentElement.getAttribute("data-id");
    
            fetch(baseUrl + id, {
                method: "DELETE",
            });
    
            e.currentTarget.parentElement.remove();

            loadCoursesBtn.click();
        });

        editCourseBtn.addEventListener("click", (e) => {
          e.preventDefault();

          e.currentTarget.parentElement.remove();

          document.querySelector("#course-name").value = course.title;
          document.querySelector("#course-type").value = course.type;
          document.querySelector("#description").value = course.description;
          document.querySelector("#teacher-name").value = course.teacher;

          document.querySelector("#edit-course").removeAttribute("disabled");
          document
            .querySelector("#edit-course")
            .setAttribute("data-id", course._id);
          document.querySelector("#add-course").disabled = true;

          document
            .querySelector("#edit-course")
            .addEventListener("click", (e) => {
              e.preventDefault();

              const courseName = document.querySelector("#course-name").value;
              const courseType = document.querySelector("#course-type").value;
              const courseDescription =
                document.querySelector("#description").value;
              const courseTeacher =
                document.querySelector("#teacher-name").value;

              if (
                courseName === "" ||
                courseType === "" ||
                courseDescription === "" ||
                courseTeacher === ""
              ) {
                alert("All fields are required!");
                return;
              }

              const course = {
                title: courseName,
                type: courseType,
                description: courseDescription,
                teacher: courseTeacher,
                _id: e.currentTarget.getAttribute("data-id"),
              };

              fetch(baseUrl + course._id, {
                method: "PUT",
                headers: {
                  "Content-Type": "application/json",
                },
                body: JSON.stringify(course),
              });

              loadCoursesBtn.click();

              document
                .querySelector("#edit-course")
                .setAttribute("disabled", true);
              document.querySelector("#add-course").disabled = false;

              document.querySelector("#course-name").value = "";
              document.querySelector("#course-type").value = "";
              document.querySelector("#description").value = "";
              document.querySelector("#teacher-name").value = "";
            });
        });
      });
    });
});

const addCourseBtn = document.querySelector("#add-course");

addCourseBtn.addEventListener("click", (e) => {
  e.preventDefault();

  //Get the values from the input fields
  const courseName = document.querySelector("#course-name").value;
  const courseType = document.querySelector("#course-type").value;
  const courseDescription = document.querySelector("#description").value;
  const courseTeacher = document.querySelector("#teacher-name").value;

  //Make sure all fields are filled
  if (
    courseName === "" ||
    courseType === "" ||
    courseDescription === "" ||
    courseTeacher === ""
  ) {
    alert("All fields are required!");
    return;
  }

  //Create the course object
  const course = {
    title: courseName,
    type: courseType,
    description: courseDescription,
    teacher: courseTeacher,
  };

  //Send the request
  fetch(baseUrl, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(course),
  });

  //Reload the courses
  loadCoursesBtn.click();

  //Clear the input fields
  document.querySelector("#course-name").value = "";
  document.querySelector("#course-type").value = "";
  document.querySelector("#description").value = "";
  document.querySelector("#teacher-name").value = "";
});
