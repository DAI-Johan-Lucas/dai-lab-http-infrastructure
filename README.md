# server-lab-http-infrastructure
Develop a complete infrastructure with static and dynamic Web servers, running on docker-compose

## STEP 1 : 

Commande pour lancer le server static :

Se mettre dans la racine du ficher Dockerfile et lancer la commande suivante :

`docker build -t static-web-server .`

Une fois le build terminé, nous pouvons lancer le server static depuis l'application Docker Desktop, ou alors avec la
commande suivante :

`docker run -p 80:80 web`

## STEP 2 :

Création d'un fichier docker-compose.yml à la racine du serveur static.

Se placer dans le dossier static et lancer la commande suivante :

`docker compose up`

Possibilité de recompiler le docker compose avec la commande suivante :

`docker compose build`

Pour lancer le docker compose en mode détaché / l'éteindre :

`docker compose start`

`docker compose stop`

Ou alors le faire depuis l'application Docker Desktop.

## STEP 2 :

#### Création de la base de données

Pour le step 3, nous avons décidé d'utiliser une base de données postgres SQL.

La première étape a consisté à créer le service postgres dans le docker-compose.yml, pour cela nous avons ajouter les
lignes suivantes :

```
  postgresql:
    image: 'bitnami/postgresql:16'
    container_name: dai-lab-http-infrastructure
    environment:
      - POSTGRESQL_USERNAME=dai
      - POSTGRESQL_PASSWORD=dai
      - POSTGRESQL_DATABASE=dai
      - POSTGRESQL_POSTGRES_PASSWORD=root
    ports:
      - "5432:5432"
    volumes:
      - .:/data:ro
    networks:
      - dai-net
```

Notez l'utilisation d'un network pour relier les deux services. Cela implique l'ajout de la ligne suivante :

```
networks:
  dai-net:
    driver: bridge
```

Nous avons ensuite utilisé DataGrip notre schéma de notre base de données ainsi que l'insertion de données par défaut.

Toujours dans DataGrip, nous avons créé une nouvelle "Data Sources" que nous utiliserons dans notre application Java
pour nous connecter à la base de données :

![Data Sources](./figures/DataSources.png)

Dans la nouvelle data source, nous avons créé une nouvelle Database "dai" :

![Data Sources](./figures/DataBase.png)

Comme on peut le voir sur l'image, nous avons ensuite créé notre schéma family avec le ficher :
`./src/main/java/server/API/sql/init_database_dai-lab-http-infrastructure.sql`
Puis nous l'avons rempli avec le fichier :
`./src/main/java/server/API/sql/populate_dai-lab-http-infrastructure.sql`

#### Création de l'API

Pour ce qui est de la création de l'API, nous avons créé une classe "Database" qui se charge de la connexion à notre
base de données précédemment créée.

Nous avons ensuite créé une classe pour chaque table de notre base de données "Family" à savoir "Person", "Address"
ainsi qu'une classe "PersonController" qui se charge de faire le lien entre notre API et notre base de données via
des requêtes SQL.

Pour finir, nous avons créé une classe "Api" qui se charge de lancer notre API sur le port 7000.
Elle indique également les routes disponibles pour effectuer des requêtes.

#### Vérification avec Bruno

Pour vérifier que notre API fonctionne correctement, nous avons utilisé le logiciel Bruno.

Bruno est un logiciel de client API qui peut être téléchargé ici :
https://www.usebruno.com/downloads

Sur notre interface Bruno, nous avons créé une nouvelle collection "dai-lab-http-infrastructure" correspondant à notre
projet puis nous avons créé une requête pour chaque route de notre API :
- **getAll** : http://localhost:7000/api/persons
- **getOne** : http://localhost:7000/api/persons/{id}
- **create** : http://localhost:7000/api/persons
- **update** : http://localhost:7000/api/persons/{id}
- **delete** : http://localhost:7000/api/persons/{id}

Ceci permet de vérifier que nous pouvons bien obtenir nos données ainsi que les modifier/supprimer.