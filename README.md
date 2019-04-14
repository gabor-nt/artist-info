Simple rest service to fetch artists from MusicBrainz with their releases

### How do we build and run it?
Use Maven: `mvn spring-boot:run`
The controller tests are testing e2e
The `load_test.sh` can be used against a locally started instance to see how it breaks on 3pp rate limiting

### What tools did you use?
The project was made with IntelliJ, Maven3, Java11, Spring Boot 2, Jackson, REST Assured, and intellij-annotations-instrumenter-maven-plugin, and bash

### Why did you use them?
I picked these, because I am familiar with them and they get the job done

### Did you intentionally leave stuff out or made any shortcuts?
 * I did not set up a nice useragent for the 3pp requests
 * I did not cache bad request responses
 * I did not set up a rate limiter, so the hypothetical high load would reach MusicBrainz and all these requests would not be served.
I skipped these parts as they would have only made the service nicer towards the 3pps, but would have needed more effort, better test tools


### How and why did you select the source of the profile information (i.e. the source of your choice)?
I went with the recommended one as it had an easy to use API, and was available on most entries
