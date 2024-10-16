package cn.voidtech.cruddemo;

import cn.voidtech.cruddemo.mapper.UserMapper;
import cn.voidtech.cruddemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrudDemoApplicationTests {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
//        userService.save(UserEntity.builder()
//                .nickname("RK")
//                .email("2017091600@qq.com")
//                .password(DigestUtils.md5DigestAsHex("123456".getBytes(StandardCharsets.UTF_8)) )
//                .build());
        userMapper.clear();
        userService.list().forEach(System.out::println);


    }

}
