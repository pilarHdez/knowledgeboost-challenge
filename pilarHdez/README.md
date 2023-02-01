<h1 align="center">Code challenge: open weather microservice</h1> <br>

<p align="center">
The Client wants Gobant to develop a microservice for the retrieval of the current weather data
for a given city by using the OpenWeather API.
</p> <br>
<p align="center">
by Pilar Hernández Bastida <br>
mdp.hernandez@globant.com
</p>

## Table of Contents

- [Requirements](#requirements)
- [Quick Start](#quick-start)
- [Testing](#testing)
- [API](#requirements)
- [Extras](#extras)


## Requirements
The application can be run locally or in a docker container, uou will need the following installed on your computer:
* [Java 8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](https://maven.apache.org/download.cgi)
* [Docker](https://www.docker.com/get-docker)

## Quick Start
Run in bash to start the project:
```
sh exercise/start.sh
```
to finish:
```
sh exercise/finish.sh
```
## Testing 
After compile the project, the unit test report is available in:
```
exercise/target/site/jacoco/index.html
```

## API
### Request

`GET http://localhost:8080/weather/city/Jordan`

    curl -i -H 'Accept: application/json' http://localhost:8080/weather/city/Jordan

### Response

    HTTP/1.1 200 OK
    Status: 200 OK
    Connection: close
    Content-Type: application/json

    {"coord":{"lon":36,"lat":31},"weather":[{"id":801,"main":"Clouds","description":"few clouds","icon":"02n"}],"base":"stations","main":{"temp":279.41,"feels_like":273.96,"temp_min":279.41,"temp_max":279.41,"pressure":1014,"humidity":81,"sea_level":1014,"grnd_level":915},"visibility":10000,"wind":{"speed":11.91,"deg":266,"gust":18.2},"clouds":{"all":19},"dt":1675271985,"sys":{"country":"JO","sunrise":1675225695,"sunset":1675264240},"timezone":7200,"id":248816,"name":"Hashemite Kingdom of Jordan","cod":200}

### Request

`GET http://localhost:8080/weather/latitude/30/longitude/20`

    curl -i -H 'Accept: application/json' http://localhost:8080/weather/latitude/30/longitude/20

### Response

    HTTP/1.1 200 OK
    Status: 200 OK
    Connection: close
    Content-Type: application/json

    {"coord":{"lon":20,"lat":30},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04n"}],"base":"stations","main":{"temp":286.83,"feels_like":285.61,"temp_min":286.83,"temp_max":286.83,"pressure":1024,"humidity":52,"sea_level":1024,"grnd_level":1023},"visibility":10000,"wind":{"speed":3.96,"deg":335,"gust":5.1},"clouds":{"all":64},"dt":1675272010,"sys":{"country":"LY","sunrise":1675229434,"sunset":1675268181},"timezone":7200,"id":2215210,"name":"Al Burayqah","cod":200}


## Extras
List docker containers:
```
docker ps
```

Show docker logs:
```
docker logs <id>
```

Show mysql docker console:
```
docker-compose exec  mysql-development mysql -uroot -phelloworld app
```