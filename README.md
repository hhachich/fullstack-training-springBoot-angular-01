# Spring Boot & Angular Application - README

## Introduction

Ce projet est une application de gestion des paiements des étudiants, développée en utilisant **Spring Boot** pour le backend et **Angular Material** pour le frontend. L'objectif principal est de permettre la gestion des étudiants et de leurs paiements, tout en fournissant une interface utilisateur moderne et réactive grâce à Angular. Ce projet couvre l'architecture d'une application complète, allant de la gestion des données à la sécurisation des routes et à la gestion des interactions utilisateur.

## Fonctionnalités

- **Gestion des étudiants** : Ajout, mise à jour, et suppression des étudiants.
- **Gestion des paiements** : Suivi des paiements des étudiants avec la possibilité d'ajouter des fichiers associés (comme des factures).
- **Sécurité des routes** : Authentification des utilisateurs et gestion des accès via des rôles spécifiques.
- **Téléchargement de fichiers** : Fonctionnalité de téléversement et de gestion des fichiers PDF.
- **Navigation moderne** : Utilisation d'Angular Material pour une interface utilisateur interactive et responsive.
- **Documentation API REST** : Swagger est utilisé pour documenter et tester les API backend.

## Prérequis

- **Java 21**
- **Node.js 14+**
- **Angular CLI**
- **MySQL** (ou une autre base de données compatible avec Spring Data JPA)

## Architecture du projet

Le projet est divisé en deux parties :

1. **Backend (Spring Boot)** : API RESTful avec Spring Boot, gérant la persistance des données, la logique métier et l'exposition des services.
2. **Frontend (Angular)** : Interface utilisateur avec Angular Material, permettant l'interaction avec les services backend.

## Installation

### Backend (Spring Boot)

1. Clonez le projet :
   ```bash
   git clone https://github.com/hhachich/fullstack-training-springBoot-angular-01.git
   cd fullstack-training-springBoot-angular-01
   ```

2. Configurez les propriétés de la base de données dans `src/main/resources/application.properties` :
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/votre_db
   spring.datasource.username=votre_username
   spring.datasource.password=votre_password
   ```

3. Compilez et exécutez l'application :
   ```bash
   ./mvnw spring-boot:run
   ```

### Frontend (Angular)

1. Allez dans le dossier `frontend` :
   ```bash
   cd frontend
   ```

2. Installez les dépendances :
   ```bash
   npm install
   ```

3. Lancez l'application Angular :
   ```bash
   ng serve
   ```

4. L'application sera disponible sur `http://localhost:4200`.

## Étapes de développement

### Part 1 - Backend avec Spring Boot

1. **Création des entités** : Définissez les entités `Etudiant` et `Paiement` avec les attributs nécessaires comme ID, prénom, nom, code étudiant, montant, date de paiement, etc.
2. **Gestion des relations** : Utilisez des annotations JPA pour gérer les relations entre les entités. 
3. **Création des services et repositories** : Implémentez la couche de service pour gérer la logique métier et les repositories pour l'accès à la base de données.
4. **API REST** : Développez des endpoints pour récupérer les étudiants et leurs paiements, gérer les ajouts et mises à jour, ainsi que le téléchargement de fichiers.
5. **Documentation Swagger** : Intégrez Swagger pour documenter et tester vos API.
6. **Désactivation temporaire de la sécurité** : Utilisez Spring Security et désactivez-le temporairement pendant la phase de développement pour faciliter les tests.

### Part 2 - Frontend avec Angular

1. **Création du projet Angular** : Initialisez un projet Angular dans le même repository en utilisant Angular CLI.
2. **Intégration d'Angular Material** : Installez Angular Material pour utiliser des composants prêts à l'emploi comme les tables, formulaires et menus.
3. **Composants de navigation** : Créez des composants tels que `Home`, `Dashboard` et `Login` avec Angular Material.
4. **Formulaire d'authentification** : Implémentez un formulaire de connexion simple avec Angular Reactive Forms.
5. **Système de routing** : Configurez le système de routing pour gérer la navigation dans l'application, y compris les routes protégées par un service de garde.
6. **Gestion des erreurs CORS** : Résolvez les problèmes de CORS en configurant correctement les headers sur le backend.
7. **Affichage des données** : Créez un service pour récupérer les listes d'étudiants et affichez-les dans des composants Angular.
8. **Gestion des paiements** : Ajoutez un composant dédié à la gestion des paiements, avec un formulaire pour ajouter de nouveaux paiements et l'option de téléversement de fichiers.
9. **Pagination et tri** : Implémentez la pagination et le tri des données dans les tableaux d'étudiants.
10. **Utilisation des Date Pickers** : Utilisez le module Mat Date Picker pour permettre la sélection de dates dans les formulaires de paiement.

## Conclusion

Ce projet montre comment combiner Spring Boot pour le backend et Angular pour le frontend dans une application complète. Il couvre des concepts tels que la sécurité, la gestion des données, les interactions frontend-backend et l'utilisation de composants modernes pour offrir une expérience utilisateur fluide.
# Project
![Alt text](/images/1.png)
![Alt text](/images/2.png)
![Alt text](/images/3.png)
![Alt text](/images/4.png)
![Alt text](/images/5.png)
![Alt text](/images/6.png)

# Lien
1. https://www.youtube.com/watch?v=oTuAXfD2M1g
2. https://www.youtube.com/watch?v=QqmoMDGr3Ww
3. https://www.youtube.com/watch?v=AARjOq9VzgQ
