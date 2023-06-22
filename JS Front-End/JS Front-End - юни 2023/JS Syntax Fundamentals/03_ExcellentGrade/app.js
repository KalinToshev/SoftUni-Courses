function gradeFeedback(grade) {
    let outputMessage = "";
    if(grade >= 5.50) {
        outputMessage = "Excellent";
    } else {
        outputMessage = "Not excellent";
    }
    console.log(outputMessage);
}

gradeFeedback(5.99);