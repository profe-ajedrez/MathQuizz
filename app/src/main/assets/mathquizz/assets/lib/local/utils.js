
let generateNumber;
generateNumber = (min, max ) => {
    return  Math.floor(Math.random() * (max - min + 1) + min);
};


let decomposeNumber;
decomposeNumber= (number) => {
    let digits = [];
    while (number !== 0) {
        digits.push( number % 10);
        number = Math.floor(number / 10);
    }
    return digits;
};


let loadOperator;
loadOperator = (selector, operatorPath, operatorFile) => {
    let elemento = '<img class="" src="';
    elemento += operatorPath + operatorFile + '" />';
    $(selector).fadeOut();
    $(selector).html(elemento);
    $(selector).fadeIn();
}

let loadNumberToContainer;
loadNumberToContainer = (digits, selector='', imgOfNumbers) =>{
    let contenido = '';
    let i;

    for (i = digits.length - 1; i >= 0; i--) {
        contenido += '<img class="" src="' + imgOfNumbers[digits[i]] + '" />';
    }

    if (digits.length == 2) {
        contenido = '<img class="" src="' + imgOfNumbers[10] + '" />' + contenido;
    }
    if (digits.length == 1) {
        contenido = '<img class="" src="' + imgOfNumbers[10] + '" />' +
                    '<img class="" src="' + imgOfNumbers[10] + '" />' +
                    contenido;
    }

    $(selector).fadeOut();
    $(selector).html(contenido);
    $(selector).fadeIn();
};

