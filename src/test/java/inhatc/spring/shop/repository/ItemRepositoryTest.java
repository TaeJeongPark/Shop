package inhatc.spring.shop.repository;

import inhatc.spring.shop.constant.ItemSellStatus;
import inhatc.spring.shop.entity.Item;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : inhatc.spring.shop.repository
 * fileName       : ItemRepositoryTest
 * author         : TaeJeongPark
 * date           : 2023-09-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-13        TaeJeongPark       최초 생성
 */
@SpringBootTest
//@Transactional  // 동작이 끝나면 자동 롤백
class ItemRepositoryTest {

    @Autowired  // 자동으로 구현체 생성
    private ItemRepository itemRepository;

    @Test
    @DisplayName("상품 생성 테스트")
    public void createItem() {
        Item item = Item.builder()
                .itemNm("테스트 상품")
                .price(10000)
                .itemDetail("테스트 상품 상세 설명")
                .itemSellStatus(ItemSellStatus.SELL)
                .regTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        System.out.println("============== item : " + item);

        Item savedItem = itemRepository.save(item);

        System.out.println("============== savedItem : " + savedItem);
    }

}