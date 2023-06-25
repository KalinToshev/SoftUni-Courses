/*
Calculate the total price without any discount 
based on the type of the group and the day of the week.
*/
function calculateTotalPriceWithoutDiscount(typeOfTheGroup, dayOfTheWeek) {
  switch (typeOfTheGroup) {
    case "Students":
      switch (dayOfTheWeek) {
        case "Friday":
          return 8.45;
        case "Saturday":
          return 9.8;
        case "Sunday":
          return 10.46;
      }
      break;
    case "Business":
      switch (dayOfTheWeek) {
        case "Friday":
          return 10.9;
        case "Saturday":
          return 15.6;
        case "Sunday":
          return 16;
      }
      break;
    case "Regular":
      switch (dayOfTheWeek) {
        case "Friday":
          return 15;
        case "Saturday":
          return 20;
        case "Sunday":
          return 22.5;
      }
      break;
  }
}

/*
Apply the appropriate discount to the 
total price based on the group size and type.
*/
function applyDiscount(totalPrice, groupOfPeople, typeOfTheGroup) {
  if (typeOfTheGroup === "Students" && groupOfPeople >= 30) {
    totalPrice -= totalPrice * 0.15; // Apply a 15% discount for student groups of 30 or more
  } else if (typeOfTheGroup === "Business" && groupOfPeople >= 100) {
    totalPrice -=
      calculateTotalPriceWithoutDiscount(typeOfTheGroup, dayOfTheWeek) * 10; // 10 people stay for free for business groups of 100 or more
  } else if (
    typeOfTheGroup === "Regular" &&
    groupOfPeople >= 10 &&
    groupOfPeople <= 20
  ) {
    totalPrice -= totalPrice * 0.05; // Apply a 5% discount for regular groups of 10 to 20 people
  }
  return totalPrice;
}

/*
Calculate the final price for a group 
based on the group size, type, and day of the week.
*/
function calculateGroupFinalPrice(groupOfPeople, typeOfTheGroup, dayOfTheWeek) {
  let totalPrice =
    calculateTotalPriceWithoutDiscount(typeOfTheGroup, dayOfTheWeek) *
    groupOfPeople;
  totalPrice = applyDiscount(totalPrice, groupOfPeople, typeOfTheGroup);

  console.log(`Total price: ${totalPrice.toFixed(2)}`);
}

// Example usage
calculateGroupFinalPrice(30, "Students", "Sunday");
