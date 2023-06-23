function reverseArrayOfNumbers(n, inputArr) {
    let arr= [];
    for (let index = 0; index < n; index++) {
        arr.push(inputArr[index]);
    }

    let output='';
    for (let index = arr.length - 1; index >= 0; index--) {
        output += `${arr[index]} `;
    }

    console.log(output.trim());
}

reverseArrayOfNumbers(3, [10, 20, 30, 40, 50]);