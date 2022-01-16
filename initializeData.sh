#!/bin/sh
curl -d '{"field1":"field1a","field2":"field2a","field3":"field3a","field4":"field4a"}' \
-H 'Content-Type: application/json' \
-X POST 'http://localhost:8080/dataEntities'

curl -d '{"field1":"field1b","field2":"field2b","field3":"field3b","field4":"field4b"}' \
-H 'Content-Type: application/json' \
-X POST 'http://localhost:8080/dataEntities'

curl -d '{"field1":"field1c","field2":"field2c","field3":"field3c","field4":"field4c"}' \
-H 'Content-Type: application/json' \
-X POST 'http://localhost:8080/dataEntities'