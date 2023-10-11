package inhatc.spring.shop.service;

import inhatc.spring.shop.dto.MemberFormDto;
import inhatc.spring.shop.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : inhatc.spring.shop.service
 * fileName       : MemberServiceTest
 * author         : TaeJeongPark
 * date           : 2023-10-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-11        TaeJeongPark       최초 생성
 */
@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member createMember() {

        MemberFormDto memberFormDto = MemberFormDto.builder()
                .address("인천 미추홀구")
                .email("test@test.com")
                .name("홍길동")
                .password("1111")
                .build();

        System.out.println("==========>>" + memberFormDto);

        Member member = Member.createMember(memberFormDto, passwordEncoder);

        System.out.println("==========>>" + member);

        return member;

    }

    @Test
    @Transactional
    @DisplayName("가입 테스트")
    void saveMemberTest() {

        Member member = createMember();

        Member savedMember = memberService.saveMember(member);

        System.out.println(savedMember);

        assertEquals(member.getAddress(), savedMember.getAddress());

    }

    @Test
    @Transactional
    @DisplayName("중복 가입 테스트")
    void saveMemberTest2() {

        Member member1 = createMember();

        Member savedMember1 = memberService.saveMember(member1);

        Member member2 = createMember();

        Throwable e = assertThrows(IllegalStateException.class, () -> {
            memberService.saveMember(member2);
        });

        assertEquals("이미 존재하는 회원입니다", e.getMessage());

    }

}