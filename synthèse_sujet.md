# Contexte

Créer une application pour développer une application pour Wacdo pour gérer les affectations des employés des divers restaurants.

# Tech & Outils

- Backend : Spring Boot (Java)
- Frontend : Angular (TS ?)
- Database : SQLite
    - Ce n'est pas une app pour un grand publique avec de la charge CCU
- Sécurité : JWT (JSON Web Token)

# Data Model

- Collaborateur
    - nom
    - prénom
    - email
    - date de première embauche
    - administrateur (true / false)
    - mot de passe

- Restaurant
    - nom
    - rue
    - ville
    - zipcode

- Fonction
    - Intitulé

- Affectation
    - collaborateur
    - restaurant
    - fonction
    - début
    - fin (vide = affectation en cours)

# Fonctionalités

Application utilisable uniquement par les utilisateurs admin authentifiés

## Menu principal

Permet d'accéder à :

- La Gestion des Restaurants
- La Gestion des Collaborateurs
- La Gestion des Fonctions
- La Recherche des Affectations

## Gestion des Restaurants

- Liste des restaurants (filtrable)
    - Critères de recherche
        - nom
        - zipcode
        - ville
    - Cliquer sur un Restaurant affiche ses détails
- Bouton pour créer un nouveau restaurant

## Détails d'un Restaurant

- Détails du Restaurant
- Liste des affectations **en cours** (filtrable)
    - Critères de recherche
        - intitulé de fonction
        - nom du collaborateur
        - date de début d'affectation
- Bouton "Modifier"
    - Affiche l'historiqueq des affectations (filtrable)
    - Permet d'affecter un nouveau collaborateur
```
Note : Je présume que les informations du restaurant (nom, adresse, etc...) sont modifiables ?
```
```
Note : La partie du bouton "Modifier" est extrêmement floue dans l'énnoncé et il me semble qu'il y a matière à être plus ergonomique ici plutôt que de basculer sur un nouvel écran...

Quelque chose m'échappe, il faudrait en discuter !
```

## Gestion des Collaborateurs

- Liste des Collaborateurs (filtrable)
    - Critères de recherche
        - nom
        - prénom
        - email
    - Cliquer sur un Collaborateur affiche le détail du Collaborateur
- Bouton "Nouveau" pour ajouter un Collaborateur
- Bouton "Rechercher des collaborateurs non affectés"
```
Note : le bouton "Rechercher des collaborateurs non affectés" ne devrait-il pasa être un critère de recherche plutôt ?
```

## Détails d'un Collaborateur

- Détails d'un collaborateur
- Liste des affectations **en cours**
    - Critères de recherche
        - nom de fonction
        - date de début d'affectation
    - Ces affectations sont modifiables
- Historique des affectations (filtrable)
    - Critères de recherche
        - nom de fonction
        - date de début d'affectation
- Bouton "Modifier" pour l'affecter à une nouvelle Fonction
```
Note : Je présume que les détails du collaborateur sont éditables?
```
```
Note : Pas sûr que les listes d'affectations soient deux éléments distincts mais l'énnoncé semble les distinguer.
```

## Gestion des Fonctions

- Liste des Fonctions
    - Les fonctions sont modifiables
- Bouton "Nouvelle fonction" pour ajouter une nouvelle fonction

## Recherche des Affectations

- Liste des Affectations (filtrable)
    - Critères de recherche
        - nom de poste
        - date de début
        - date de fin
        - ville

# Tests

- Tests unitaires via JUnit
```
Note : Aucune idée de l'état de l'art pour les tests automatisés de UX/UI. Angular peut être ?
A voir
```

# Validations

- Tests Unitaires = Tester en isolation un bout de code
- Tests d'intégration = Tester avec un environnement isolé
- Valider côté Angular pour l'UX/UI
- Valider côté Spring pour la cohérence des données

# Questions personnelles

- L'énnoncé ne parle pas de restrictions pour lier un Collaborateur à un Restaurant spécifique. Cela me semble improbable de pouvoir "réellement" affecter un Collaborateur à deux établissements distincts mais c'est peut être une volonté du client ?