function mathArithmeticOperation(num1, num2, arithmeticSymbol) {
    let result;
    switch (arithmeticSymbol) {
        case "+":
            result = num1 + num2; 
            break;
        case "-":
            result = num1 - num2;
            break;
        case "*":
            result = num1 * num2;
            break;
        case "/":
            result = num1 / num2;
            break;
        case "%":
            result = num1 % num2;
            break;
        case "**":
            result = num1 ** num2;
            break;
        default:
            result = "Invalid Arithmetic Symbol!";
            break;
    }
    console.log(result);
}

solve(5, 6, "-");