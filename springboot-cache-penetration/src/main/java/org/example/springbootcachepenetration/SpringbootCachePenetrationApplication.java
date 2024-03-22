package org.example.springbootcachepenetration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
@MapperScan("org.example.springbootcachepenetration") // mapper 接口所在的包
public class SpringbootCachePenetrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCachePenetrationApplication.class, args);
    }

        @RequestMapping("/test")
        public String testControler(){
            System.out.println("测试成功");
            return "测试成功";
        }


    @Autowired
    private RedisTemplate redisTemplate;

    //添加数据
    // @PathVariable 将URL中的key和Value参数映射到方法的参数中
    @PostMapping("/addData/key={key}/value={value}")//动态地址
    public Object addData(@PathVariable("key") String key,
                          @PathVariable("value") String value){
        redisTemplate.opsForValue().set(key,value);
        System.out.println("数据添加成功"+redisTemplate);
        return "addData Success"; // 将字符串"addData Success"作为HTTP响应的主体返回给客户端
    }

    @GetMapping("/getData/key={key}")//动态地址
    public Object addData(@PathVariable("key") String key){
        return redisTemplate.opsForValue().get(key);
    }



    @Autowired
    UserService userService;
    @PostMapping("/addUser/name={name}/age={age}")//动态地址
    public Object addUser(@PathVariable("name") String name,
                          @PathVariable("age") String age){
        User user = new User();
        user.setName(name);
        user.setAge(Integer.valueOf(age));
        userService.save(user);
        System.out.println("数据添加成功"+redisTemplate);
        return "addUser Success"; // 将字符串"addData Success"作为HTTP响应的主体返回给客户端
    }


    @GetMapping("/getUser/id={id}")//动态地址
    public Object getUser(@PathVariable("id") Long id){
        // Attempt to get the object from Redis and cast it to User
        User user = (User) redisTemplate.opsForValue().get(id);
        if (user != null){
            return user;
        }else{
            // Fetch the user from the service
            user = userService.getById(id);
            if (user != null) {
                // Serialize the user object as JSON and store it in Redis with a TTL of 1 hour
                redisTemplate.opsForValue().set(id, user, 1, TimeUnit.HOURS);
            }
            return user;
        }
    }

    @GetMapping("/getUserV2/id={id}")//动态地址
    public User getUserById(@PathVariable("id") String id) {
        // Attempt to retrieve the user (or null marker) from Redis
        Object result = redisTemplate.opsForValue().get(id);

        // Check if the result is the null marker
        if (result instanceof NullObjectMarker) {
            return null; // No user associated with this ID
        } else if (result instanceof User) {
            return (User) result; // User found in cache
        } else {
            // User not in cache, attempt to fetch from the userService
            User user = userService.getById(id);
            if (user != null) {
                // User found, cache and return the user
                redisTemplate.opsForValue().set(id, user, 1, TimeUnit.HOURS);
                return user;
            } else {
                // No user found, cache the null marker to avoid repeated lookups
                redisTemplate.opsForValue().set(id, new NullObjectMarker(), 10, TimeUnit.MINUTES);
                return null;
            }
        }
    }








}
