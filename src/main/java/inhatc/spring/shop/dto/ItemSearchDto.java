package inhatc.spring.shop.dto;

/**
 * packageName    : inhatc.spring.shop.dto
 * fileName       : ItemSearchDto
 * author         : TaeJeongPark
 * date           : 2023-11-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-29        TaeJeongPark       최초 생성
 */
import inhatc.spring.shop.constant.ItemSellStatus;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemSearchDto {

    private String searchDateType;              // 검색 기준일

    private ItemSellStatus searchSellStatus;    // 판매 상태

    private String searchBy;                    // 검색 조건

    private String searchQuery;                 // 검색어
}