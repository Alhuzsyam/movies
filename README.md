# Movies List RestApi

<h1> Get started </h1>

1. first clone the repo in your local computer
2. runing this command for build the docker image and container `docker-compose up -d`
3. the last step just run the spring boot with the command below `mvn spring-boot:run`
4. **note :** make sure your computer is installed docker

# API End Point
<b> Insert data to database </b>
**Methode** | **Post** 
--- | ---
Path | [http://localhost:8080/api/product](http://localhost:8086/api/v1/movie)

`{
    "title":"Assasin Creed II",
    "description":"Anime Series from Japan",
    "rating":"6.9",
    "image":"Image.jpg"
}`
