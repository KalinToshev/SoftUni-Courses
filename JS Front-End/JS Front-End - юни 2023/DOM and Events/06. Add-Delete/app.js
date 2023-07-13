function addItem() {
    const textValue = document.querySelector('#newItemText').value;

    const newItem = document.createElement('li');
    newItem.textContent = textValue;

    const deleteButton = document.createElement('a');
    deleteButton.href = '#';
    deleteButton.textContent = '[Delete]';
    deleteButton.addEventListener('click', (e) => {
        e.target.parentElement.remove();
    })

    newItem.append(deleteButton);

    document.querySelector('#items').appendChild(newItem);
}