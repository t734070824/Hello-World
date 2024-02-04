#使用基础镜像，这里选择的是Java 8环境
FROM openjdk:8-jdk-alpine

#设置工作目录
WORKDIR /app

#复制从Spring Boot生成的jar文件，将其放在工作目录中
COPY target/springboot-helloWorld-0.0.1-SNAPSHOT.jar /app

#暴露端口80
EXPOSE 80

#设置环境变量
ENV APP_NAME springboot-helloWorld-0.0.1-SNAPSHOT

#启动应用程序
ENTRYPOINT ["java","-jar","springboot-helloWorld-0.0.1-SNAPSHOT"]
