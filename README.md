# Zup-Beagle
Test using beagle

## Pre-Requisites
- Java 8
- Kotlin

##  Run Application
```shell
java -jar bff-0.0.1-SNAPSHOT.jar --mock.basePath=$pathResponseFiles
```
**OBS:** Exist json samples at: 
```shell
zup-beagle/src/main/resources/static/response/example
```

## Consume
Use [postman](https://www.postman.com/) to consume the json
```shell
#GET
http://localhost:8080/beagle/screen
```

## Swagger
```shell
http://localhost:8080/swagger-ui.html#/
```

## Link of defaults components
https://beagle-playground.netlify.app/#/demo/default-components/
