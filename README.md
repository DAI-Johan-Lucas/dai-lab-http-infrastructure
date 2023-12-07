# dai-lab-http-infrastructure
Develop a complete infrastructure with static and dynamic Web servers, running on docker-compose

Commande pour lancer le server static :

Se mettre dans la racine du ficher Dockerfile et lancer la commande suivante :

`docker build -t web .`

Une fois le build terminé, nous pouvons lancer le server static depuis l'application docker compose, ou alors avec la
commande suivante :

`docker run -p 80:80 web`