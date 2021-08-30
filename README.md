# Spring Boot - profiles and properties

This is a [Spring Boot](https://spring.io/projects/spring-boot) project that shows how to use different configuration for different profiles in an application. In this example, as profiles I mean environments (development, staging, production), but it could be different configurations for different cloud providers (AWS, Microsoft Azure, Google Cloud, etc.).

These are the steps to take:

1. Create a Spring Boot project:

   For this step you can go to the [spring initializr](https://start.spring.io/) site, or , if you have a specific plug-in on your IDE, use it.
   
   Just create a project, there are no prerequisites, but for this example I have added *Sping WEB*.
   
2. Create different properties files for each profile:

   In the *src/main/resources* folder there is the *application.properties* file. This file is for global properties, that are used regardless of profiles.

   Create a different *.properties* file for each profile needed. In the format *application-PROFILE_NAME.properties* In this example I have created two:
    - *application-dev.properties* - a development profile.
    - *application-prod.properties* - a production profile.

3. In each profile put the configurations needed:

   It is important that the configurations take the same name in each different profile (*.properties* file). In this example I have the configurations for the database. H2 for development and Oracle for production, with these properties:
    - *spring.datasource.driver-class-name*
    - *spring.datasource.url*
    - *spring.datasource.username*
    - *spring.datasource.password*

4. Create a configuration class that reads the different profiles configurations (mapping the configuration):

   For this I have created a new package inside the *src/main/java* under the existing application package. Then the class file, which I called *DBConfiguration*. This class must be annotated with:
    - *@Configuration* from *org.springframework.context.annotation.Configuration* package - this tells Spring that it is a configuration class.
    - *@ConfigurationProperties(configuration.prefix)* from *org.springframework.boot.context.properties.ConfigurationProperties* package - reads all configuration with a specific prefix, in the present example I will use: *@ConfigurationProperties(spring.datasource)*, because of the name of the properties that I set in previous step.

   It is important to create a field in the class for each configuration. In the present example:
    - *private String driverClassName* - the framework converts from *driver-class-name* (kebab-case) to *driverClassName* (camel case).
    - *private String url*
    - *private String username*
    - *private String password*

   Finally create a method for each different profile. Such methods must be annotated with *@Profile* from *org.springframework.context.annotation.Profile*, and use the *PROFILE_NAME* used in the *application-PROFILE_NAME.properties*, like this: *@Profile("PROFILE_NAME")*. The name of the method does not matter. In the present example:
    - @Profile("dev")
    - @Profile("prod")

5. Choose which profile will be used. For this we have to set the *spring.profiles.active* property. In our case one of two: *spring.profiles.active=dev*, or *spring.profiles.active=prod*.

   We can also set a default value with the *spring.profiles.default* property.

## References

This example is based on the course "Introdução ao Framework Spring Boot", from Digital Innovation, taught by Rodrigo Peleias.