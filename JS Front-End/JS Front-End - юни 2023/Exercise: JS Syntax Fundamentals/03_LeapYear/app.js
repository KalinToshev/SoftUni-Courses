/*
This function check whether a year is a leap. Leap years 
are either divisible by 4 but not by 100 or are
divisible by 400. If the year is leap, the output is "yes", 
otherwise the output is "no"
*/
function checkIfYearIsLeap(year) {
  if ((year % 4 === 0 && year % 100 !== 0) || year % 400 === 0) {
    console.log("yes");
  } else {
    console.log("no");
  }
}

checkIfYearIsLeap(4);
