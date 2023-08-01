window.addEventListener('load', solve);

function solve() {
    const addBtn = document.querySelector('#add-btn');

    const inputFields = {
        genre: document.querySelector('#genre'),
        songName: document.querySelector('#name'),
        author: document.querySelector('#author'),
        date: document.querySelector('#date'),
    }

    const songsList = document.querySelector('.all-hits-container');

    const savedSongList = document.querySelector('.saved-container');

    const totalLikes = document.querySelector('.likes p');

    addBtn.addEventListener('click', (e) => {
        e.preventDefault();

        const genreValue = inputFields.genre.value;
        const songNameValue = inputFields.songName.value;
        const authorValue = inputFields.author.value;
        const dateValue = inputFields.date.value;

        if (genreValue === "" || songNameValue === "" || authorValue === "" || dateValue === "") {
            alert('All fields are required!');
            return;
        }

        const imageElement = document.createElement('img');
        imageElement.src = './static/img/img.png';

        const h2GenreElement = document.createElement('h2');
        h2GenreElement.textContent = `Genre: ${genreValue}`;

        const h2SongNameElement = document.createElement('h2'); 
        h2SongNameElement.textContent = `Name: ${songNameValue}`;

        const h2AuthorElement = document.createElement('h2');
        h2AuthorElement.textContent = `Author: ${authorValue}`;

        const h3DateElement = document.createElement('h3');
        h3DateElement.textContent = `Date: ${dateValue}`;

        const saveBtn = document.createElement('button');
        saveBtn.textContent = 'Save song';
        saveBtn.classList.add('save-btn');

        saveBtn.addEventListener('click', (e) => {
            const savedSong = e.target.parentElement;

            const saveBtn = savedSong.querySelector('.save-btn');
            saveBtn.remove();

            const likeBtn = savedSong.querySelector('.like-btn');
            likeBtn.remove();

            savedSongList.appendChild(savedSong);
        });

        const likeBtn = document.createElement('button');
        likeBtn.textContent = 'Like song';
        likeBtn.classList.add('like-btn');

        likeBtn.addEventListener('click', (e) => {
            const currentLikes = Number(totalLikes.textContent.split(' ')[2]);
            totalLikes.textContent = `Total likes: ${currentLikes + 1}`;

            likeBtn.disabled = true;
        });

        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Delete';
        deleteBtn.classList.add('delete-btn');

        deleteBtn.addEventListener('click', (e) => {
            const songToDelete = e.target.parentElement;
            songToDelete.remove();
        });

        const divElement = document.createElement('div');
        divElement.classList.add('hits-info');

        divElement.appendChild(imageElement);
        divElement.appendChild(h2GenreElement);
        divElement.appendChild(h2SongNameElement);
        divElement.appendChild(h2AuthorElement);
        divElement.appendChild(h3DateElement);
        divElement.appendChild(saveBtn);
        divElement.appendChild(likeBtn);
        divElement.appendChild(deleteBtn);

        songsList.appendChild(divElement);

        //Clear input fields
        inputFields.genre.value = '';
        inputFields.songName.value = '';
        inputFields.author.value = '';
        inputFields.date.value = '';
    });
}