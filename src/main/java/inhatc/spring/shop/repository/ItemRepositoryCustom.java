package inhatc.spring.shop.repository;

import inhatc.spring.shop.dto.ItemSearchDto;
import inhatc.spring.shop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * packageName    : inhatc.spring.shop.repository
 * fileName       : ItemRepositoryCustom
 * author         : TaeJeongPark
 * date           : 2023-11-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-29        TaeJeongPark       최초 생성
 */

public interface ItemRepositoryCustom {

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

}