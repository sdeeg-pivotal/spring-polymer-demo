This application uses Google's [Polymer](https://www.polymer-project.org) web framwork and [elements](https://www.polymer-project.org/0.5/docs/elements/) (core and paper) to build a single page application (SPA) that utilizes ReSTful back end services.  The services are created in Spring, and use [Spring Security](http://projects.spring.io/spring-security), [Spring Session](https://github.com/spring-projects/spring-session/), and [Spring Cloud](https://github.com/spring-projects/spring-cloud).

It is based on a set of concepts laid out by Dave Syer in a series of articles (and samples) that specifically explore the security side of SPA apps.  The first post in the series is [here](https://github.com/dsyer/spring-security-angular).

##Contents

* `polymer-ui`: Application to host the Polymer app, and act as a Service Proxy
* `resource`: Simple ReSTful app to return JSON data
* `auth-server`: Simple OAuth2 server to use for testing

##Build / Run

The projects should build with maven, eg:

	mvn package

and are run as standard java applications:

	java -jar polymer-demo-ui-0.0.1-SNAPSHOT.jar

The default is for the session profile to be active.  Change to oauth by changing the profile

	java -jar polymer-demo-ui-0.0.1-SNAPSHOT.jar --spring.profiles.active=oauth

##Notes

OAuth has worked in the past, but is likely currently broken.  Consider it "experimental".  :-)

##Future direction

Provide a combined Session and OAuth solution so users can choose which to use to access an app.
