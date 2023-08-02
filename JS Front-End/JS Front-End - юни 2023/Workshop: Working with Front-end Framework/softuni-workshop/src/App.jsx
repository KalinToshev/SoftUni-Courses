import { useState } from "react";
import UserTitle from "./UserTitle";
import ValidationButton from "./ValidationButton";

function Heading({ children }) {
  return <h4>{children}</h4>;
}

function App() {
  const user = {
    firstName: "John",
    lastName: "Doe",
    age: 25,
    courses: ["React", "JavaScript", "HTML & CSS"],
  };
  const [isValid, setIsValid] = useState(false);

  return (
    <div className="card">
      <UserTitle firstName={user.firstName} lastName={user.lastName} />
      <Heading>General Information</Heading>
      <div>Age: {user.age}</div>
      <div>Is validated: {isValid ? "true" : "false"}</div>
      <ul>
        {user.courses.map((course, index) => (
          <li key={index}>{course}</li>
        ))}
      </ul>
      <ValidationButton isValid={isValid} onClick={() => setIsValid(true)} />
    </div>
  );
}

export default App;
