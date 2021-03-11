# name-service

This application is a name service, which allows to assign a map of unique user IDs 
on different services to each other. An example keymap is as follows:
```
"slack" -> "john.doe"
"jira" -> "johndoe@gmail.com"
```
The microservice allows to:
* Adding new keymap
* Appending existing keymap
* Updating existing keymap
* Deleting (from) existing keymap
* Querying key-bindings 

See explained definitions and more detailed descriptions of use cases [here](USE_CASES.md). 

## Getting Started

1. Start the application: `lein run`
2. Go to [localhost:8080](http://localhost:8080/) to see: `Hello World!`
3. Read your app's source code at src/name_service/service.clj. Explore the docs of functions
   that define routes and responses.
4. Run your app's tests with `lein test`. Read the tests at test/name_service/service_test.clj.
5. Learn more! See the [Links section below](#links).

## Architecture

This project uses Clean Architecture:
https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html

## Configuration

To configure logging see config/logback.xml. By default, the app logs to stdout and logs/.
To learn more about configuring Logback, read its [documentation](http://logback.qos.ch/documentation.html).


## Developing your service

1. Start a new REPL: `lein repl`
2. Start your service in dev-mode: `(def dev-serv (run-dev))`
3. Connect your editor to the running REPL session.
   Re-evaluated code will be seen immediately in the service.

### [Docker](https://www.docker.com/) container support

1. Configure your service to accept incoming connections (edit service.clj and add  ::http/host "0.0.0.0" )
2. Build an uberjar of your service: `lein uberjar`
3. Build a Docker image: `sudo docker build -t name-service .`
4. Run your Docker image: `docker run -p 8080:8080 name-service`

## Documentation

See [docs](docs) directory.
