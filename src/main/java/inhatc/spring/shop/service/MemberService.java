package inhatc.spring.shop.service;

import inhatc.spring.shop.dto.MemberFormDto;
import inhatc.spring.shop.entity.Member;
import inhatc.spring.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
@Slf4j
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    private final ModelMapper modelMapper;

    public Member saveMember(Member member) {

//        MemberFormDto formDto = modelMapper.map(member, MemberFormDto.class);   // Member -> MemberFormDto
//        Member newMember = modelMapper.map(formDto, Member.class);              // MemberFormDto -> Member

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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member member = memberRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(email + " 사용자를 찾을 수 없습니다."));

        log.info("[로그인 된 사용자] : " + member);

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();

    }

}
