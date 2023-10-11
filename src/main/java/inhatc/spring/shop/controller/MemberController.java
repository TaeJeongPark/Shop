package inhatc.spring.shop.controller;

import inhatc.spring.shop.dto.MemberFormDto;
import inhatc.spring.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName    : inhatc.spring.shop.controller
 * fileName       : MemberController
 * author         : TaeJeongPark
 * date           : 2023-10-11
 * description    : 사용자 Controller
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-11        TaeJeongPark       최초 생성
 */
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/new")
    public String memberForm(Model model) {

//        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/memberForm";

    }

}
