package inhatc.spring.shop.controller;

import inhatc.spring.shop.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * packageName    : inhatc.spring.shop.controller
 * fileName       : HelloController
 * author         : TaeJeongPark
 * date           : 2023-09-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-06        TaeJeongPark       최초 생성
 */
@RestController
public class HelloController {

    @GetMapping("/")
    public UserDto hello() {
        UserDto userDto = new UserDto().builder().age(10).build();
        userDto.setAge(20);
        userDto.setName("홍길동");
        System.out.println("userDto : " + userDto);
        return userDto;
    }

}
