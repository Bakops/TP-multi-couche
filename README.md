﻿# TP-multi-couche
## Nom: 
Toure Bakoutoubo
## Promo
DEVIAC1

## Description

Ce projet est une application de gestion d'animalerie. Il permet de gérer les informations sur les animaux, les produits, et les magasins d'animaux (PetStore). L'application utilise Spring Boot avec JPA pour la persistance des données et une base de données relationnelle pour stocker les informations.

## Consignes

- **Projet** : Création d’un projet « multi-couches » avec une bonne isolation (package, …).
- **Base de données** : Création d’une base de données appelée `petstore-bdd`.
    - Créer une nouvelle persistence-unit dans `persistence.xml` pour y accéder (Pour un projet Spring, juste paramétrer le fichier application.properties)
    - Mettre en place le paramétrage nécessaire pour que l’application prenne la main sur la création du schéma/de la structure de la base de données.
- **Mapping** : Mettre en place le mapping des entités JPA à l’aide des annotations vues en sessions.
    - Créer les entités JPA du diagramme de classes fourni (mapper tous les champs de toutes les classes avec les tables correspondantes en base de données sans oublier les types énumérés).
    - Mettre en place les annotations relationnelles (`@OneToMany`, `@ManyToMany`, `@ManyToOne`) sur les entités concernées.
    - Mettre en place les annotations d’héritage en choisissant la stratégie « 1 table par classe / Joined ».
- **Manipulation** : Mettre en place une série d’instructions pour créer et requêter les éléments en base de données.
    - Insérer au moins trois enregistrements dans chacune des tables via `EntityManager`.
    - Réaliser une requête qui permet d’extraire tous les animaux d’une animalerie donnée.

## Installation

### Prérequis

- Java 11 ou supérieur
- Maven ou Gradle
- Une base de données relationnelle (par exemple, MariaDB)

### Étapes d'Installation et test
Le script peut s'éxécuter automatiquement au démarrage de l'application, ou sinon vous pouvez directement créer la base de données:

1. Créer sa base de données relationnelle via HeidiSQL
    Nom de la base de données: `petstore-bdd`
``` DROP TABLE IF EXISTS Product;
    DROP TABLE IF EXISTS Cat;
    DROP TABLE IF EXISTS Fish;
    DROP TABLE IF EXISTS Animal;
    DROP TABLE IF EXISTS PetStore;
    DROP TABLE IF EXISTS Address;
    
    CREATE TABLE Address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(255),
    street VARCHAR(255),
    zipCode VARCHAR(255),
    city VARCHAR(255)
    );
    
    CREATE TABLE PetStore (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    managerName VARCHAR(255),
    address_id BIGINT,
    livingEnv ENUM('FRESH_WATER', 'SEA_WATER'),
    FOREIGN KEY (address_id) REFERENCES Address(id)
    );
    
    CREATE TABLE Animal (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    birth DATE,
    couleur VARCHAR(255),
    petstore_id BIGINT,
    FOREIGN KEY (petstore_id) REFERENCES PetStore(id)
    );
    
    CREATE TABLE Fish (
    id BIGINT PRIMARY KEY,
    livingEnv ENUM('FRESH_WATER', 'SEA_WATER'),
    FOREIGN KEY (id) REFERENCES Animal(id)
    );
    
    CREATE TABLE Cat (
    id BIGINT PRIMARY KEY,
    chipId VARCHAR(255),
    FOREIGN KEY (id) REFERENCES Animal(id)
    );
    
    CREATE TABLE Product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(255),
    label VARCHAR(255),
    type ENUM('FOOD', 'ACCESSORY', 'CLEANING'),
    price DOUBLE,
    petstore_id BIGINT,
    FOREIGN KEY (petstore_id) REFERENCES PetStore(id)
    );
```
2. Paramétrer le fichier applications.properties pour connecter sa base de données
``` spring.application.name=multi-couches
    server.port=8081
    # Database configuration
    spring.datasource.url=jdbc:mariadb://localhost:3306/petstore-bdd
    spring.datasource.username=root
    spring.datasource.password=bkt
    spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
    
    # Hibernate configuration
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
``` 
3. ET PAF SA FAIS DES CHOKAPIC 

## Structure du projet Spring

Architecture projet :
- `model` : Ce package contient les entités JPA (Animal, Cat, Fish, PetStore, Product, Address, FishLivEnv)
- `repository` : Ce package contient les interfaces Spring Data JPA 
- `PetstoreApplication` : C'est la classe principale du projet (inutiliser si ce n'est juste pour run le projet)
- `initialiser`: Ce package contient la classe `DataInitializer` qui initialise l'application et contient toutes les données de test

## Infos & avis
Pas d'info particulière si ce n'est juste mendier 2 points en plus pour la qualité de ce fichier README.
Et je voulais quand même vous partager mon avis par rapport à vos cours : franchement des cours ultra qualitatif, j'avais beaucoup d'appréhensions et je m'attendais à ne rien comprendre au cours et vous avez réussi à nous proposer des cours intéressants et dynamique. Merci encore
PS: (un petit point pour le message mignon ?)
