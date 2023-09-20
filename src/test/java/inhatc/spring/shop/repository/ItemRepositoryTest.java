package inhatc.spring.shop.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import inhatc.spring.shop.constant.ItemSellStatus;
import inhatc.spring.shop.entity.Item;
import inhatc.spring.shop.entity.QItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

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

    @PersistenceContext
    private EntityManager em;

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

    public void createItemList() {

        for (int i = 1; i <= 10; i++) {
            Item item = Item.builder()
                    .itemNm("테스트 상품" + i)
                    .price(10000 + i)
                    .itemDetail("테스트 상품 상세 설명" + i)
                    .itemSellStatus(ItemSellStatus.SELL)
                    .regTime(LocalDateTime.now())
                    .updateTime(LocalDateTime.now())
                    .build();

            itemRepository.save(item);
        }

    }

    @Test
    @DisplayName("상품 이름 검색 테스트")
    public void findByItemNmTest() {

        createItemList();

        // 람다 표기법
        itemRepository
                .findByItemNm("테스트 상품1")
                .forEach((item) -> {
            System.out.println(item);
        });

//        itemRepository.findByItemNm("테스트 상품1").forEach(System.out::println);
//        itemList.forEach((item) -> System.out.println(item));
//        itemList.forEach(System.out::println);

    }

    @Test
    @DisplayName("OR 테스트")
    public void findByItemNmOrItemDetailTest() {

        createItemList();
        itemRepository
                .findByItemNmOrItemDetail("테스트 상품2", "테스트 상품 상세 설명8")
                .forEach((item) -> {
                    System.out.println(item);
                });

    }

    @Test
    @DisplayName("OrderBy 테스트")
    public void findByPriceLessThanOrderByPriceDescTest() {

        createItemList();
        itemRepository
                .findByPriceLessThanOrderByPriceDesc(10005)
                .forEach(item -> System.out.println(item));

    }

    @Test
    @DisplayName("JPQL 테스트")
    public void findByDetailTest() {

        createItemList();
        itemRepository
                .findByDetail("1")
                .forEach(item -> System.out.println(item));

    }

    @Test
    @DisplayName("Native 테스트")
    public void findByDetailNativeTest() {

        createItemList();
        itemRepository
                .findByDetailNative("1")
                .forEach(item -> System.out.println(item));

    }

    @Test
    @DisplayName("querydsl 테스트")
    public void querydslTest() {

        createItemList();
        JPAQueryFactory query = new JPAQueryFactory(em);

        QItem qItem = QItem.item;
        List<Item> itemList = query.selectFrom(QItem.item)
                .where(QItem.item.itemSellStatus.eq(ItemSellStatus.SELL))
                .where(QItem.item.itemDetail.like("%" + "1" + "%"))
                .orderBy(QItem.item.price.desc())
                .fetch();

        itemList.forEach(item -> System.out.println(item));

    }

}