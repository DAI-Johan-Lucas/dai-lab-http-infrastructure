// Fonction pour récupérer les données depuis l'API
function fetchDataPerson() {
    fetch('http://localhost:7000/api/persons')
        .then(response => response.json())
        .then(data => {
            populateTable(data);
        })
        .catch(error => {
            console.error('Error can\'t fetch data:', error);
        });
}

// Fonction pour remplir le tableau avec les données JSON
function populateTable(data) {
    const tableHeaders = document.getElementById('tableHeaders');
    const tableBody = document.getElementById('tableBody');

    tableHeaders.innerHTML = '';
    tableBody.innerHTML = '';

    if (data.length > 0) {
        // Parcourt les données et ajoute chaque entrée dans le tableau
        data.forEach(item => {
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

            // Modify button
            const editCell = row.insertCell();
            const editButton = document.createElement('button');
            editButton.textContent = 'Modify';
            editButton.onclick = function() {
                const idToEdit = item.id;
                window.location.href = `create.html?id=${idToEdit}`;
            };
            editCell.appendChild(editButton);

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
    fetch(`http://localhost:7000/api/persons/${id}`, {
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

window.onload = function() {
    fetchDataPerson();
};

window.onscroll = function() {
    var navbar = document.querySelector('.navbar');
    if (window.pageYOffset > 50) {
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
    }
};

function submitUpdateEmployeeForm() {
    // Récupérer les valeurs du formulaire
    const loginId = document.getElementById('loginId').value;
    const password = document.getElementById('password').value;
    const nom = document.getElementById('nom').value;
    const prenom = document.getElementById('prenom').value;
    const dob = document.getElementById('dob').value;
    const contractStartDate = document.getElementById('contractStartDate').value;
    const fonction = document.getElementById('fonction').value;
    const phone = document.getElementById('phone').value;
    const licenseType = document.getElementById('licenseType').value;
    const adresse = document.getElementById('adresse').value;
    const decheterie = document.getElementById('decheterie').value;

    // Créer un objet avec les valeurs
    const data = {
        idlogin: loginId,
        mdplogin: password,
        nom: nom,
        prenom: prenom,
        datenaissance: dob,
        datedebutcontrat: contractStartDate,
        fonction: fonction,
        numtelephone: phone,
        typepermis: licenseType,
        fk_adresse: adresse,
        fk_decheterie: decheterie
    };

    // Convertir l'objet en JSON
    const json = JSON.stringify(data);

    // Envoyer une requête PUT à l'API
    fetch('https://localhost/api/employes/' + loginId, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: json
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}