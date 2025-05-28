# Spring Code First

A quick "Hello World" Spring Boot application, but for generating OpenAPI, using [Springdoc](https://springdoc.org/).

This repository was built as sample code for the Bump.sh guide on [Generating OpenAPI docs for Spring with Springdoc](https://docs.bump.sh/guides/openapi/code-first-spring/).

## Usage

Clone the repository down and load it up in your favorite IDE to install dependencies and run the application.

```
# Start the application
$ mvn spring-boot:run
```

When the application is running it will serve up the OpenAPI description on <http://localhost:8080/openapi>.

To see how that OpenAPI looks in a more readable format, you can use the Bump CLI to preview it:

```
npx bump-cli preview http://localhost:8080/openapi
```

Want to see how it will look without downloading anything? Take a look at this documentation [deployed with Bump.sh](https://bump.sh/bump-examples/hub/code-samples/doc/spring-code-first) already.

## License

The contents of this repository are licensed under [CC BY-NC-SA
4.0](./LICENSE_CC-BY-NC-SA-4.0).
