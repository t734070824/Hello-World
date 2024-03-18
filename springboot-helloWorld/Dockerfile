#使用基础镜像，这里选择的是Java 8环境
FROM openjdk:8-jdk-alpine

#复制从Spring Boot生成的jar文件，将其放在工作目录中
COPY ./target/springboot-helloWorld-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
#启动应用程序
ENTRYPOINT ["java","-jar"]
CMD ["app.jar"]
