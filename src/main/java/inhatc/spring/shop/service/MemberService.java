package inhatc.spring.shop.service;

import inhatc.spring.shop.entity.Member;
import inhatc.spring.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName    : inhatc.spring.shop.service
 * fileName       : MemberService
 * author         : TaeJeongPark
 * date           : 2023-10-11
 * description    : 사용자 Service
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-11        TaeJeongPark       최초 생성
 */
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member) {

        validateDuplicateMember(member);

        return memberRepository.save(member);

    }

    private void validateDuplicateMember(Member member) {

        Optional<Member> member1 = memberRepository.findByEmail(member.getEmail());

        if(member1.isPresent()) {
            System.out.println(member1);
        }

        member1.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });

    }

}
