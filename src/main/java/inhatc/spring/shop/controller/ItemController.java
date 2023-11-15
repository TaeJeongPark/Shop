package inhatc.spring.shop.controller;

import inhatc.spring.shop.dto.ItemFormDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName    : inhatc.spring.shop.controller
 * fileName       : ItemController
 * author         : TaeJeongPark
 * date           : 2023-10-28
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-28        TaeJeongPark       최초 생성
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    @GetMapping("/admin/item/new")
    public String itemForm(Model model) {

        model.addAttribute("itemFormDto", new ItemFormDto());
        return "item/itemForm";

    }

}
