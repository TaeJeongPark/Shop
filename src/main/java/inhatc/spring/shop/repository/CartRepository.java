package inhatc.spring.shop.repository;

import inhatc.spring.shop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : inhatc.spring.shop.repository
 * fileName       : CartRepository
 * author         : TaeJeongPark
 * date           : 2023-11-01
 * description    : 장바구니 Repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-01        TaeJeongPark       최초 생성
 */
public interface CartRepository extends JpaRepository<Cart, Long> {



}
