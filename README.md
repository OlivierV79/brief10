# Brief 10 - Application ForkNow

## Execution de l'application

- Pour créer une base de données avec les parametres suivant:

  - localhost:5432/forknow
  - username: postgres
  - password: postgres

- Pour lancer l'application, saisir dans le terminal :
  - .\gradlew bootrun

## Informations techniques

- Spring Security à été utilisé pour la securité.
  - Gestion des utilisateurs
  - Gestion de l'accès aux différentes pages de l'application
- Thymeleaf a été utilié pour le rendu dynamique.
  - Nom de l'utilisateur précisé sur la page principale
  - Affichage des restaurants dans la BDD

## Fonctionnalités

- L'utilisateur peut créer un compte utilisateur
- L'utilisateur peut se connecter à l"application
- L'utilisateur peut se déconnecter de l"application
- L'utilisateur peut créer un restaurant
- L'utilisateur peut visualiser tous les restaurants créés
