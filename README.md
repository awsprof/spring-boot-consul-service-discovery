#Spring Boot Service Mesh with Consul
This repository contains two simple Spring boot microservices that are linked together using the Hashicorp Consul Service Discovery Service.

## Installation
This project depends on my earlier project [Service Discovery using Consul for Prometheus](https://github.com/awsprof/prometheus-service-discovery)

Clone the Consul project first and run: 
```bash
docker-compose up -d
```
Access the Consul UI on [http://localhost:8500/ui/dc1/services](http://localhost:8500/ui/dc1/services)

Once the Consul service comes up, clone this repo and open using an IDE of your choice. I use [JetBrains IntelliJ](https://www.jetbrains.com) by the way.

There are two Spring Microservices as separate maven projects. 

The RestConsumer service exposes an endpoint on
```
http://localhost:20080/consumer/invoke/{user}
```
This service invokes another REST Service aptly named the RestService Service ;-)

The producer service exposes another endpoint which can be invoked directly for testing on
```
http://localhost:20090/producer/sayHello/{name}
```
However, the main point about this repo is that, the consumer Microservice looks up the producer Microservice using Consul dynamically instead of hardcoding the hostname or port.

Once you start both the Microservices, use the following commands to test the endpoints. 

This is the Direct Service Endpoint
```bash
curl http://localhost:20090/service/sayHello/Foo
```
This is the Consumer Endpoint that invokes the Service endpoint by looking up the Service via Consul
```bash
curl http://localhost:20080/consumer/invoke/Bar
```
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)