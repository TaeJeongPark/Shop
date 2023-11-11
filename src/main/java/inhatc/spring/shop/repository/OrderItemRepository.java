package inhatc.spring.shop.repository;

import inhatc.spring.shop.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : inhatc.spring.shop.repository
 * fileName       : OrderItemRepository
 * author         : TaeJeongPark
 * date           : 2023-11-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-11        TaeJeongPark       최초 생성
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {



}
