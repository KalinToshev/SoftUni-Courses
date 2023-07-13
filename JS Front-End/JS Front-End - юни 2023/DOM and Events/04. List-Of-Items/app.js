function addItem() {
    const textValue = document.querySelector('#newItemText').value;
    const newItem = document.createElement('li');
    newItem.textContent = textValue;
    document.querySelector('#items').appendChild(newItem);
}