```
$ git clone https://github.com/tadivenkat/spring-boot-app-with-postgresqldb.git
$ cd to project root directory
$ mvn clean install
$ docker compose up      
This will run the postgresql db in a docker container. 
You can edit docker-compose.yml file as per your desired configuration.
$ cd target
$ java -jar runners-0.0.1-SNAPSHOT.jar
```
