## nginx


### 问题
1. nginx 最重要的原理是什么
2. nginx 性能测试
3. nginx 是如何支撑所测试的性能的

### 好玩
1. 自己用C实现一个基础的nginx
2. 成功在docker部署

### 安装
1. docker pull nginx
2. docker run --name nginx -d -p 9001:80 nginx
3. docker cp nginx:/etc/nginx/nginx.conf /home/nginx/conf/nginx.conf
   docker cp nginx:/etc/nginx/conf.d /home/nginx/conf/conf.d
   docker cp nginx:/usr/share/nginx/html /home/nginx
4. docker stop nginx
5. docker rm nginx
6. docker run \
   -p 9002:80 \
   --name nginx \
   -v /home/nginx/conf/nginx.conf:/etc/nginx/nginx.conf \
   -v /home/nginx/conf/conf.d:/etc/nginx/conf.d \
   -v /home/nginx/log:/var/log/nginx \
   -v /home/nginx/html:/usr/share/nginx/html \
   -d nginx:latest
7. docker exec -it nginx /bin/bash


