# Simple Quarkus Application which use Metrics for Prometheus

Launch prometheus and MongoDb using docker by:
```shell script
docker-compose -f src/main/docker/docker-compose.yaml up -d
```

Run the application using:
```shell script
./mvnw compile quarkus:dev
```