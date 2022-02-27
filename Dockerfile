FROM maven:3.8-openjdk-8
COPY . /jbbs
RUN cd /jbbs && mvn clean install

FROM openjdk:8
COPY --from=0 /jbbs/target/jbbs.jar /jbbs.jar
CMD ["java", "-jar", "/jbbs.jar"]
