# server-lab-http-infrastructure
Develop a complete infrastructure with static and dynamic Web servers, running on docker-compose

STEP 1 : 

Commande pour lancer le server static :

Se mettre dans la racine du ficher Dockerfile et lancer la commande suivante :

`docker build -t static-web-server .`

Une fois le build terminé, nous pouvons lancer le server static depuis l'application Docker Desktop, ou alors avec la
commande suivante :

`docker run -p 80:80 web`

STEP 2 :

Création d'un fichier docker-compose.yml à la racine du serveur static.

Se placer dans le dossier static et lancer la commande suivante :

`docker compose up`

Possibilité de recompiler le docker compose avec la commande suivante :

`docker compose build`

Pour lancer le docker compose en mode détaché / l'éteindre :

`docker compose start`

`docker compose stop`

Ou alors le faire depuis l'application Docker Desktop.