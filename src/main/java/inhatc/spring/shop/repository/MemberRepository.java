package inhatc.spring.shop.repository;

import inhatc.spring.shop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * packageName    : inhatc.spring.shop.repository
 * fileName       : MemberRepository
 * author         : TaeJeongPark
 * date           : 2023-10-11
 * description    : 사용자 Repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-11        TaeJeongPark       최초 생성
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

}
