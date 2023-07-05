/**
 * The `manageMeetings` function takes an array of appointment strings as input.
 * Each appointment string contains a weekday and a person's name separated by a space.
 * The function manages the meetings by checking for conflicts in the schedule and storing successful meetings.
 * It uses a schedule object to keep track of the scheduled appointments.
 * If a conflict is detected, it prints a conflict message.
 * Otherwise, it schedules the meeting, updates the schedule object, and adds the meeting to the list of successful meetings.
 * Finally, it prints the list of successful meetings.
 *
 * Example usage:
 * - const appointments = [
 *     "Friday Bob",
 *     "Saturday Ted",
 *     "Monday Bill",
 *     "Monday John",
 *     "Wednesday George",
 *   ];
 *   manageMeetings(appointments);
 *   - Manages the meetings based on the given appointments and prints the successful meetings.
 *
 * The above example will output:
 *   Scheduled for Friday
 *   Scheduled for Saturday
 *   Scheduled for Monday
 *   Conflict on Monday!
 *   Scheduled for Wednesday
 *   Friday -> Bob
 *   Saturday -> Ted
 *   Monday -> Bill
 *   Wednesday -> George
 */
function manageMeetings(appointments) {
  const schedule = {};
  const successfulMeetings = [];

  for (let i = 0; i < appointments.length; i++) {
    const [weekday, person] = appointments[i].split(" ");

    if (schedule[weekday]) {
      console.log(`Conflict on ${weekday}!`);
    } else {
      console.log(`Scheduled for ${weekday}`);
      schedule[weekday] = person;
      successfulMeetings.push(`${weekday} -> ${person}`);
    }
  }

  console.log(successfulMeetings.join("\n"));
}

const appointments = [
  "Friday Bob",
  "Saturday Ted",
  "Monday Bill",
  "Monday John",
  "Wednesday George",
];

manageMeetings(appointments);
