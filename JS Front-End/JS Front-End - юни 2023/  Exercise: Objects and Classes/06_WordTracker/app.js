class Word {
  constructor(name) {
    this.name = name;
    this.occurrences = 0;
  }

  toString() {
    return `${this.name} - ${this.occurrences}`;
  }
}

class WordsTracker {
  constructor() {
    this.words = [];
  }

  trackWords(inputData) {
    const stringWords = inputData[0].split(" ");
    for (let i = 0; i < stringWords.length; i++) {
      const word = new Word(stringWords[i]);
      this.words.push(word);
    }

    inputData.shift();

    inputData.forEach((strWrd) => {
      const word = this.words.find((w) => w.name === strWrd);
      if (word) {
        word.occurrences += 1;
      }
    });
  }

  printWords() {
    this.words
      .sort((a, b) => b.occurrences - a.occurrences)
      .forEach((word) => console.log(word.toString()));
  }
}

const wordsTracker = new WordsTracker();

const input = [
  "this sentence",
  "In",
  "this",
  "sentence",
  "you",
  "have",
  "to",
  "count",
  "the",
  "occurrences",
  "of",
  "the",
  "words",
  "this",
  "and",
  "sentence",
  "because",
  "this",
  "is",
  "your",
  "task",
];

wordsTracker.trackWords(input);
wordsTracker.printWords();
