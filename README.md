# Movies List RestApi

## Get Started

1. First, clone the repository to your local computer.
2. Run the following command to build the Docker image and container:  `docker-compose up -d`
3. Finally, run the Spring Boot application with the command below: `mvn spring-boot:run`
4. **Note:** Ensure Docker is installed on your computer.

# API End Point

**Insert data to database**

**Method:** POST

**Path:** http://localhost:8086/api/v1/movie

```json
{
 "title": "Assasin Creed II",
 "description": "Anime Series from Japan",
 "rating": "6.9",
 "image": "Image.jpg"
}
