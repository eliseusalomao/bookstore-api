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

## API *Endpoints*
**POST BOOK**

```bash
   POST /bookstore/books
```
```bash
   {
   	"title": "Java: Como programar",
   	"publisherId": "79e1f32b-f6ab-43bc-b894-3d657d4e2491",
   	"authorIds": ["59fe8dd4-eab3-41f2-9d21-46682c84503b", "9f9e5d8f-0333-4598-8fcd-9b1160f05c2a"],
   	"reviewComment": "Adorei ler este livro, pois é um grande compilado de ensinamentos!"
   }
```

**GET BOOK**

```bash
    GET /bookstore/books
```

**DELETE BOOK**

```bash
   DELETE /bookstore/books/5c6769be-dbd7-4f08-aa4b-707d47534fd7
```
