package inhatc.spring.shop.dto;

import inhatc.spring.shop.constant.ItemSellStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import lombok.*;

import java.time.LocalDateTime;

/**
 * packageName    : inhatc.spring.shop.dto
 * fileName       : ItemDto
 * author         : TaeJeongPark
 * date           : 2023-09-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-27        TaeJeongPark       최초 생성
 */
@Getter
@Setter
@ToString               // 콘솔에 출력 가능
@AllArgsConstructor     // 모든 생성자 생성(빈 생성자 제외)
@NoArgsConstructor      // 빈 생성자 생성
@Builder                // 선택적으로 생성자 생성
public class ItemDto {

    private Long id;                        // 상품 코드

    private String itemNm;                  // 상품명

    private int price;                      // 가격

    private int stockNumber;                // 재고수량

    private String itemDetail;              // 상품 상세 설명

    private String itemSellStatus;          // 상품 판매 상태

    private LocalDateTime regTime;          // 등록 시간

    private LocalDateTime updateTime;       // 수정 시간

}
