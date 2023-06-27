/**
 * Checks the current speed of a vehicle in a specific area and determines if the vehicle is speeding.
 * Prints a message indicating the speed status.
 *
 * @param {number} currentSpeed - The current speed of the vehicle in km/h.
 * @param {string} area - The area or road type where the vehicle is being driven.
 *                        Valid values: "motorway", "interstate", "city", "residential".
 */
function roadRadar(currentSpeed, area) {
  // Define the speed limits for each area
  const speedLimits = {
    motorway: 130,
    interstate: 90,
    city: 50,
    residential: 20,
  };

  // Retrieve the speed limit for the specified area
  const speedLimit = speedLimits[area];

  // Calculate the difference between the current speed and the speed limit
  const difference = currentSpeed - speedLimit;

  // Determine if the vehicle is speeding
  const isSpeeding = difference > 0;

  // Initialize the status message
  let status = "";

  // Check if the vehicle is speeding and assign the appropriate status
  if (isSpeeding) {
    if (difference <= 20) {
      status = "speeding";
    } else if (difference <= 40) {
      status = "excessive speeding";
    } else {
      status = "reckless driving";
    }
  }

  // Print the appropriate message based on the speed status
  if (isSpeeding) {
    console.log(
      `The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - ${status}`
    );
  } else {
    console.log(`Driving ${currentSpeed} km/h in a ${speedLimit} zone`);
  }
}

roadRadar(40, "city");
