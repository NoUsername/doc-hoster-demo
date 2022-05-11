# Documentation Hosting Demo



This demo shows hosting various different versions of a documentation project (versions managed via maven) via a simple spring-boot-app.



Steps to try out:

1. go into doc-demo-content
2. run `mvn clean install`
3. change the version in `pom.xml` to `0.0.1` (and change the content of `src/main/resources/index.html` if you want to sth like `hello from 0.0.1`)
4. run `mvn clean install` again (to create the "old" version)
5. go back to the root folder and into `doc-hoster`
6. run `mvn spring-boot:run`
7. navigate to http://localhost:8080/

We'll see the 2 versions of the documentation that we've built in steps 2-4 listed and we can click each one to go into the documentation from that version.



Which versions are included is defined in `doc-hoster/pom.xml` in the `<artifactItems>` section.