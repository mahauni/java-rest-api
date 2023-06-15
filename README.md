# Starting the database
start the docker with

docker-compose -f startPostgre.yaml up -d

### To connect with the pgAdmin in the web
localhost:54321
then to connect the connection should be

admin@gmail.com
password

### Connect to the database in the pgAdmin
host.docker.internal
5432
admin
password

# Using the api rest

localhost:8080/data

You can either do a post with the atributes.
nome: ""
idade: ""
exemplo: {
    problema: ""
    descricao: ""
}

these are the json fields and they are not null.

To query the database you can intead of post in the url, do a get.

localhost:8080/data?size=1&page=0&sort=nome

You can add parameter in the query to do more things. And they are for now
size=[number]: the size of the page of elements that are shown.
page=[number]: which page do you want to get
sort=[json field]: what field the sort will be done
sort=[json field],desc: the same ordering but descending, so the inverse of the ascending

localhost:8080/data/{id}

This one is the delete and is a logical delete, and will not delete in the database,
but will not be possible to get from the get all method.

localhost:8080/data

update you can update everything less than the id, name and the active.
but for now is not needed and this is just a exercise for java rest api.
