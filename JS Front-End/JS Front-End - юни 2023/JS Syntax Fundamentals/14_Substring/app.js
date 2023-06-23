function cutString(inputStr, startIndex, countOfElements) {
    //create variable to store the final result
    let result;

    //slice the input string with given start index and the count of elements after
    result = inputStr.substr(startIndex, countOfElements);

    //output the result
    console.log(result);
}

cutString('SkipWord', 4, 7);