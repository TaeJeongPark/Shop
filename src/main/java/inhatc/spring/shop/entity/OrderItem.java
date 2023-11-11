package inhatc.spring.shop.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * packageName    : inhatc.spring.shop.entity
 * fileName       : OrderItem
 * author         : TaeJeongPark
 * date           : 2023-11-01
 * description    : 주문 아이템 Entity
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
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;                        // 상품 코드

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;                      // 상품

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;                    // 주문

    private int orderPrice;                 // 주문 가격

    private int count;                      // 주문 수량

}
