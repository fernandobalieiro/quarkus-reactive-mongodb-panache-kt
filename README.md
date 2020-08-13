# Quarkus Reactive MongoDB in Kotlin

The goal of this project was to study how to create a Web Application using Quarkus, Reactive MongoDB Panache framework in **Kotlin**.

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## An important note:
In order to have some annotations working properly in Kotlin, sometimes it's necessary to add `@field` annotation.  
This was the case for persisting fields using snake case in `MongoDB`, where it was necessary to `@BsonProperty` annotation as follows:
```kotlin 
       @field: BsonProperty("birth_date")
       var birthDate: LocalDateTime? = LocalDateTime.now()
``` 

This is documented [here](https://quarkus.io/guides/kotlin), under `CDI @Inject with Kotlin` section.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `mongodb-panache-quickstart-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/mongodb-panache-quickstart-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/mongodb-panache-quickstart-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.
