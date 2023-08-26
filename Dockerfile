FROM openjdk:17

ADD /target/OutfitsCompletedOfLog-0.0.1-SNAPSHOT.jar start.jar

ENTRYPOINT ["java","-jar","start.jar"]
