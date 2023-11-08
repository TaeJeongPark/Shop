package inhatc.spring.shop.repository;

import inhatc.spring.shop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : inhatc.spring.shop.repository
 * fileName       : OrderRepository
 * author         : TaeJeongPark
 * date           : 2023-11-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-08        TaeJeongPark       최초 생성
 */
public interface OrderRepository extends JpaRepository<Order, Long> {



}
