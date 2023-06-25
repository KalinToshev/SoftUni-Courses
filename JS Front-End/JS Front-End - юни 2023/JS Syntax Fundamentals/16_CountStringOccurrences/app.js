function countStringOccurences(text, word) {
    let words = text.split(' ');
    let counter = 0;

    for (let w of words) {
        if (w === word) {
            counter++;
        }
    }

    console.log(counter);
}

countStringOccurences('This is a word and it also is a sentence', 'is');