package inhatc.spring.shop.controller;

import inhatc.spring.shop.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;

/**
 * packageName    : inhatc.spring.shop.controller
 * fileName       : ThymeleafController
 * author         : TaeJeongPark
 * date           : 2023-09-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-27        TaeJeongPark       최초 생성
 */
@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf/ex1")
    public String ex1(Model model) {

//        Point p = new Point(10, 20);
        ItemDto itemDto = ItemDto.builder()
                .itemNm("최신 스프링")
                .itemDetail("스프링 부트 3.1.4")
                .itemSellStatus("SELL")
                .price(20000)
                .build();

        model.addAttribute("itemDto", itemDto);
        return "thymeleaf/ex1";

    }

}
