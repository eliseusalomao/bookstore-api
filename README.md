# Bookstore 📚

An API that allows adding books along with one or more authors and publisher information. 
It also enables creating reviews for books.

## Purpose
To reinforce my knowledge about Java Spring Boot and Spring Data JPA.

My focus was to reinforce:
- How LAZY and EAGER Fetch work;
- What the @Transactional does;
- How the relationships are established;

## How to run this project

1. Setup database</br>
   Run `docker compose up -d`
3. Run the Spring Boot Application
4. Populate database</br>
   To have a better experience you also may need to insert some elements into the database:
   You may use the database client of your preference and run the following script:
   ```
   insert into publishers values(gen_random_uuid(), 'Alta Books');
   insert into publishers values(gen_random_uuid(), 'Pearson');

   insert into authors values(gen_random_uuid(), 'Eric Evans');
   insert into authors values(gen_random_uuid(), 'Paul Deitel');
   insert into authors values(gen_random_uuid(), 'Harvey Deitel');
   ```

The ***endpoint*** for managing books is: http://localhost:8080/bookstore/books 
