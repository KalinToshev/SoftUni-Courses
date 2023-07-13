function deleteByEmail() {
    const email = document.querySelector('input[name="email"]').value;
    const emailBoxes = Array.from(document.querySelectorAll('td:nth-child(even)'));

    const userEmailBox = emailBoxes.find((box) => box.textContent === email);

    const resultBox = document.querySelector('#result');

    if (userEmailBox) {
        userEmailBox.parentElement.remove();
        resultBox.textContent = 'Deleted.'
    } else {
        resultBox.textContent = 'Not found.'
    }
}