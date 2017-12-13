FROM java:8
VOLUME /tmp
ADD dbtest.jar dbtest.jar
RUN bash -c 'touch /dbtest.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/dbtest.jar"]