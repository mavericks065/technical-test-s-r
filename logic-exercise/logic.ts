const checkAllDigitsArePresent = (longNumber: number): boolean => {
    if (!longNumber)
        return false;

    const number = longNumber.toString();
    const inputtedDigits = [];
    let element;
    for (let index = 0; index < number.length; index++) {
        element = number[index]
        if (!inputtedDigits.includes(element)) {
            inputtedDigits.push(element)
        }
        if (inputtedDigits.length == 10)
            return true;
    }
    return false;
};

const digits = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];

export default checkAllDigitsArePresent;
