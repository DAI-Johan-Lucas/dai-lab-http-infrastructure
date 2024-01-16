function fetchDataPerson() {
    fetch('https://localhost/api/persons')
        .then(response => response.json())
        .then(data => {
            populateTable(data);
        })
        .catch(error => {
            console.error('Error can\'t fetch persons:', error);
        });
}

function populateAddressDropdown() {
    fetch('https://localhost/api/addresses')
        .then(response => response.json())
        .then(data => {
            const dropdown = document.getElementById('Address');

            dropdown.innerHTML = '';

            data.forEach(item => {
                const option = document.createElement('option');
                option.value = item.id;
                option.text = item.street + ' ' + item.npa + ', ' + item.city + ' ' + item.country;
                dropdown.appendChild(option);
            });
        })
        .catch(error => {
            console.error('Error can\'t fetch addresses:', error);
        });
}

function populateTable(data) {
    const tableBody = document.getElementById('tableBody');

    tableBody.innerHTML = '';

    if (data.length > 0) {
        // Parcourt les données et ajoute chaque entrée dans le tableau
        data.forEach(item => {
            const headers = Object.keys(data[0]);
            const row = tableBody.insertRow();
            headers.forEach(header => {
                const cell = row.insertCell();
                if (header === 'Birthday') {
                    cell.textContent = new Date(item[header]).toLocaleDateString('fr-FR');
                } else {
                    cell.textContent = item[header] !== null && item[header] !== undefined ? item[header] : '-';
                }
                cell.setAttribute('data-title', header);
            });

            // Delete button
            const deleteCell = row.insertCell();
            const deleteButton = document.createElement('button');
            deleteButton.textContent = 'Delete';
            const idToDelete = item.id;
            deleteButton.onclick = function() {
                deleteElementById(idToDelete);
            };
            deleteCell.appendChild(deleteButton);
        });
    }
}

function deleteElementById(id) {
    fetch(`https://localhost/api/persons/${id}`, {
        method: 'DELETE',
    })
        .then(response => {
            if (response.ok) {
                console.log(`ID: ${id} has been successfully deleted.`);
                window.location.reload();
            } else {
                console.error('The deletion has failed.');
            }
        })
        .catch(error => {
            console.error('Error during deletion:', error);
        });
}

window.onscroll = function() {
    var navbar = document.querySelector('.navbar');
    if (window.pageYOffset > 50) {
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
    }
};

function submitPerson() {
    // Récupérer les valeurs du formulaire
    const id = document.getElementById('ID').value;
    const firstname = document.getElementById('First').value;
    const lastname = document.getElementById('Last').value;
    const birthdate = document.getElementById('Birthday').value;
    const phone = document.getElementById('Phone').value;
    const fk_address = document.getElementById('Address').value;

    // Créer un objet avec les valeurs
    const data = {
        id: id,
        firstname: firstname,
        lastname: lastname,
        birthdate: birthdate,
        phone: phone,
        fk_address: fk_address
    };

    // Convertir l'objet en JSON
    const json = JSON.stringify(data);

    // Envoyer une requête POST à l'API
    fetch('https://localhost/api/persons', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: json
    })
        .then(response => {
            if (!response.ok) {
                return response.text().then(text => {
                    throw new Error(text);
                });
            }
            //return response.json();
            return response.text().then(text => text ? JSON.parse(text) : {});
        })
        .then(data => {
            if (data) {
                console.log('Success:', data);
                window.location.href = 'index.html';
                alert('The member has been successfully created.');
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('Error has occured during the creation.\n' + error.message);
        });

}