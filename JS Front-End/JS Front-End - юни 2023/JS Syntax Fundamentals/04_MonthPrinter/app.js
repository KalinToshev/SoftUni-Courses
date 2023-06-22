function printMonthName(monthNumber) {
    const monthNames = [
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    ];

    if (monthNumber >= 1 && monthNumber <= 12) {
        const monthIndex = monthNumber - 1;
        const monthName = monthNames[monthIndex];
        console.log(monthName);
    } else {
        console.log("Error!");
    }
}

printMonthName(5);
