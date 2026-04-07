# BookTown
A RESTful web application built with Spring Boot that allows users to browse, manage and purchase books

## Features
* Browse and search books
* Add books to cart and place orders
* User registration and authentication
* Admin panel for managing books, categories and users
* Filter books by different options
* Rate and review books

## Entity Relationship Diagram
```mermaid
erDiagram

    USER {
        long user_id PK
        string email
        string first_name
        string last_name
        string password
        string role
    }

    BOOK {
        long book_id PK
        string title
        string isbn
        long publisher_id FK
        int publication_year
        string language
        int pages
        float price
        string description
        float average_rating
        int stock
        string image
    }

    AUTHOR {
        long author_id PK
        string first_name
        string last_name
    }

    PUBLISHER {
        long publisher_id PK
        string name
        string phone
    }

    CATEGORY {
        long category_id PK
        string name
    }

    CUSTOMER {
        long customer_id PK
        long user_id FK
        string phone
        string address
    }

    RATING {
        long rating_id PK
        long customer_id FK
        long book_id FK
        float rating
    }

    REVIEW {
        long review_id PK
        long customer_id FK
        long book_id FK
        string review
    }

    ORDER {
        long order_id PK
        long customer_id FK
        date order_date
        float amount
        string status
    }

    ORDER_ITEM {
        long order_item_id PK
        long order_id FK
        long book_id FK
        int quantity
        float price_at_purchase
    }

    PAYMENT {
        long payment_id PK
        long order_id FK
        date payment_date
        float amount
        string payment_method
        string status
    }

    USER ||--o| CUSTOMER : is

    BOOK }o--o{ AUTHOR : written_by
    BOOK }o--o{ CATEGORY : included_in

    RATING }o--|| BOOK : rated_by
    RATING }o--|| CUSTOMER : adds

    REVIEW }o--|| BOOK : reviewed_by
    REVIEW }o--|| CUSTOMER : adds

    PUBLISHER ||--o{ BOOK : publishes

    CUSTOMER ||--o{ ORDER : places
    ORDER ||--o{ ORDER_ITEM : contains
    BOOK ||--o{ ORDER_ITEM : included_in

    ORDER ||--|| PAYMENT : paid_by
```
