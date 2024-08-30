## Tables

1. Users: stock les infos sur les clients

| Nom de la colonne | Type de donnée | Description             |
| ----------------- | -------------- | ----------------------- |
| id                | BIGINT         | Clé primaire            |
| username          | VARCHAR        | Pseudo unique du client |
| email             | VARCHAR        | Email du client         |
| password          | VARCHAR        | MDP du client           |
| created_at        | TIMESTAMP      | Date de création        |
| updated_at        | TIMESTAMP      | Date de modification    |

2. Poducts : stock les infos sur les produits

| Nom de la colonne | Type de donnée | Description            |
| ----------------- | -------------- | ---------------------- |
| id                | BIGINT         | Clé primaire           |
| name              | VARCHAR        | Nom du produit         |
| description       | TEXT           | Desctiption du produit |
| price             | DECIMAL        | Prix du produit        |
| stock_qty         | INT            | Quantité en stock      |
| created_at        | TIMESTAMP      | Date de création       |
| updated_at        | TIMESTAMP      | Date de modification   |

3. Orders: stock les infos sur les commandes faites par les clients

| Nom de la colonne | Type de donnée | Description             |
| ----------------- | -------------- | ----------------------- |
| id                | BIGINT         | Clé primaire            |
| user_id           | BIGINT         | Clé secondaire          |
| total_amount      | DECIMAL        | Montant total           |
| status            | VARCHAR        | Status (ex: en cours..) |
| created_at        | TIMESTAMP      | Date de création        |
| updated_at        | TIMESTAMP      | Date de modification    |

4. Order items: stock les infos sur les produits inclus dans chaque commande:

| Nom de la colonne | Type de donnée | Description                 |
| ----------------- | -------------- | --------------------------- |
| id                | BIGINT         | Clé primaire                |
| order_id          | BIGINT         | Clé secondaire =>`orders`   |
| product_id        | BIGINT         | Clé secondaire =>`products` |
| quantity          | INT            | Qté de produits commandée   |
| price             | DECIMAL        | Prix du produit             |
| created_at        | TIMESTAMP      | Date de création            |
| updated_at        | TIMESTAMP      | Date de modification        |

## Relations

- `users`-> `orders` : un user peut passer plusieurs commandes

- `orders`-> `orders_items` : une commande peut avoir plusieurs items

- `products`-> `orders_items` : un produit peut être commandé plusieurs fois dans la journée

## IMP

`spring.jpa.hibernate.ddl-auto` :
Cette propriété est utilisée pour spécifier la stratégie de génération du shéma de la BDD lors du démarrage de l'application.
Hibernate, l'ORM utilisé par défaut dans Spring Boot, peut automatiquement créer, mettre à jour, valider ou gérer le schéma de la BDD
en fonction de cette propriété.