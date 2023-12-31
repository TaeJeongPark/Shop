package inhatc.spring.shop.entity;

import inhatc.spring.shop.common.entity.BaseEntity;
import inhatc.spring.shop.constant.ItemSellStatus;
import inhatc.spring.shop.dto.ItemFormDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * packageName    : inhatc.spring.shop.entity
 * fileName       : Item
 * author         : TaeJeongPark
 * date           : 2023-09-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-13        TaeJeongPark       최초 생성
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;                        // 상품 코드

    @Column(nullable = false, length = 50)
    private String itemNm;                  // 상품명

    private int price;                      // 가격

    private int stockNumber;                // 재고수량

    @Lob    // CLOB이나 BLOB으로 자동 컨버팅
    @Column(nullable = false)
    private String itemDetail;              // 상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;  // 상품 판매 상태

    public void updateItem(ItemFormDto itemFormDto) {
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }

}
