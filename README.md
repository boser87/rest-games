# OSGi REST Games Application with Apache Karaf and Apache CXF

## Application stack and description:

- Apache Karaf 4 – OSGi container
- Apache CXF – web service framework to implement RESTful Webservice API
- Uses Blueprint instead of Spring DM
- Unit tests with JUnit
- Java 8
- Clean code: separation of concerns with 3 application layers
- Model: Game and Provider class and their interfaces GameService and ProviderService
- Server: services implementation and logic to publish the services using REST
- Webui: servlet based web ui used by JAX-RS to access the REST services


## To run the application: 
- checkout code from Git repository: https://github.com/boser87/rest-games.git
- mvn clean install from parent pom folder
- install Apache Karaf 4 
- run Apache Karaf from bin folder: ${KARAF_HOME}/bin/karaf.bat
- install below feature dependencies
- karaf@root()> feature:repo-add cxf 3.1.5
- karaf@root()> feature:install cxf-jaxrs http-whiteboard
- karaf@root()> install -s mvn:org.apache.commons/commons-csv/1.4
- karaf@root()> install -s mvn:org.apache.cxf/cxf-rt-rs-extension-providers/3.1.11
- karaf@root()> install -s mvn:com.google.code.gson/gson/2.8.2
- karaf@root()> install -s mvn:com.stefano.learning.restgames/rest-games-model/1.0-SNAPSHOT
- karaf@root()> install -s mvn:com.stefano.learning.restgames/rest-games-server/1.0-SNAPSHOT
- karaf@root()> install -s mvn:com.stefano.learning.restgames/rest-games-webui/1.0-SNAPSHOT


## Access the two REST recources through:

- http://localhost:8181/cxf/game
- http://localhost:8181/cxf/provider

## Logs

Logs are under ${KARAF_HOME}/data/log