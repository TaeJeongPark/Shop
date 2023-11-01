package inhatc.spring.shop.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * packageName    : inhatc.spring.shop.entity
 * fileName       : Cart
 * author         : TaeJeongPark
 * date           : 2023-11-01
 * description    : 장바구니 Entity
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-01        TaeJeongPark       최초 생성
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;                        // 장바구니 코드

    @OneToOne(fetch = FetchType.LAZY)       // 실제로 테이블을 참조할 때 메모리에 로드
    @JoinColumn(name = "member_id")
    private Member member;                  // 회원

}
