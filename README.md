# Simple Quarkus Application which use Metrics for Prometheus
Here there is a simple Java Web Application developed in Quarkus which store 
data in a mongo db and collect metrics used by Prometheus.

Launch prometheus and MongoDb using docker by:
```shell script
docker-compose -f src/main/docker/docker-compose.yaml up -d
```

Run the application using:
```shell script
./mvnw compile quarkus:dev
```