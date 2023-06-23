function evenAndOddSubtraction(inputArr) {
    //Parse each string to number
    for (let index = 0; index < inputArr.length; index++) {
        inputArr[index] = Number(inputArr[index]);
    }

    //Create two variables - for even and odd sum
    let evenSum = 0;
    let oddSum = 0;

    //Iterate through all elements in the array with a loop and check if the number is odd or even
    for (let index = 0; index < inputArr.length; index++) {
        if (inputArr[index] % 2 === 0) {
            evenSum += inputArr[index];
        } else {
            oddSum += inputArr[index];
        }
    }

    //Print the difference
    console.log(evenSum - oddSum);
}

evenAndOddSubtraction([3,5,7,9]);