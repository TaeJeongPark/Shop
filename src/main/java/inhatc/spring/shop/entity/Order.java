package inhatc.spring.shop.entity;

import inhatc.spring.shop.common.entity.BaseEntity;
import inhatc.spring.shop.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : inhatc.spring.shop.entity
 * fileName       : Order
 * author         : TaeJeongPark
 * date           : 2023-11-01
 * description    :
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
@Table(name = "orders")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Member member;                          // 회원

    private LocalDateTime orderDate;        // 주문 일시

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;        // 주문 상태

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();     // 주문 상품

}
