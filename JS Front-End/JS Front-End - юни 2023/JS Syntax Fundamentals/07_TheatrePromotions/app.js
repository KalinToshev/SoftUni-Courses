function calculateTicketPrice(day, age) {
    let ticketPrice;

    if (day === 'Weekday') {
        if (age >= 0 && age <= 18) {
            ticketPrice = 12;
        } else if (age > 18 && age <= 64) {
            ticketPrice = 18;
        } else if (age > 64 && age <= 122) {
            ticketPrice = 12;
        } else {
            ticketPrice = -1;
        }
    } else if (day === 'Weekend') {
        if (age >= 0 && age <= 18) {
            ticketPrice = 15;
        } else if (age > 18 && age <= 64) {
            ticketPrice = 20;
        } else if (age > 64 && age <= 122) {
            ticketPrice = 15;
        } else {
            ticketPrice = -1;
        }
    } else if (day === 'Holiday') {
        if (age >= 0 && age <= 18) {
            ticketPrice = 5;
        } else if (age > 18 && age <= 64) {
            ticketPrice = 12;
        } else if (age > 64 && age <= 122) {
            ticketPrice = 10;
        } else {
            ticketPrice = -1;
        }
    }

    if (ticketPrice != -1) {
        console.log(ticketPrice + '$');
    } else {
        console.log('Error!');
    }
}

calculateTicketPrice('Weekday', 42);