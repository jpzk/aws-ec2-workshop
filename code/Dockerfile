FROM anapsix/alpine-java
MAINTAINER Jendrik Poloczek <jendrik.poloczek@madewithtea.com>

ADD logback.xml /logback.xml
ADD ec2app.jar /ec2app.jar

CMD ["java","-Dlogback.configurationFile=logback.xml",\
     "-cp","/ec2app.jar","mwt.ec2app.EC2App"]
