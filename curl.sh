curl --location --request POST 'http://localhost:8080/api/v1/authors/' \
--header 'Content-Type: application/json' \
--data-raw '{ "firstName": "Toni", "lastName": "Morrison" }'

curl --location --request POST 'http://localhost:8080/api/v1/authors/' \
--header 'Content-Type: application/json' \
--data-raw '{ "firstName": "Virginia", "lastName": "Woolf" }'

curl --location --request POST 'http://localhost:8080/api/v1/books/' \
--header 'Content-Type: application/json' \
--data-raw '{ "authorId": 1, "title": "Beloved", "price": 10, "publisher": "Harcourt", "isFeatured": 1, "yearPublished": 1989, "coverPrettiness": 5 }'

curl --location --request POST 'http://localhost:8080/api/v1/books/' \
--header 'Content-Type: application/json' \
--data-raw '{ "authorId": 2, "title": "To the Lighthouse", "price": 15, "publisher": "Harcourt", "isFeatured": true, "yearPublished": 1979, "coverPrettiness": 3 }'

curl --location --request POST 'http://localhost:8080/api/v1/books/' \
--header 'Content-Type: application/json' \
--data-raw '{ "authorId": 2, "title": "Mrs Dalloway", "price": 15, "publisher": "Penguin", "isFeatured": false, "yearPublished": 1979, "coverPrettiness": 6 }'

curl --location --request POST 'http://localhost:8080/api/v1/suggestion-searches/' \
--header 'Content-Type: application/json' \
--data-raw '{ "bookId": 3, "isInStore": false }'

curl --location --request POST 'http://localhost:8080/api/v1/suggestion-searches/' \
--header 'Content-Type: application/json' \
--data-raw '{ "bookId": 3, "isInStore": true }'
