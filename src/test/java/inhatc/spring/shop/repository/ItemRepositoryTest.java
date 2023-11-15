package inhatc.spring.shop.repository;

import com.querydsl.core.BooleanBuilder;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

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
                .build();

        System.out.println("============== item : " + item);

        Item savedItem = itemRepository.save(item);

        System.out.println("============== savedItem : " + savedItem);

    }

    public void createItemList() {

        for (int i = 1; i <= 200; i++) {
            Item item = Item.builder()
                    .itemNm("테스트 상품" + i)
                    .price(10000 + i)
                    .itemDetail("테스트 상품 상세 설명" + i)
                    .itemSellStatus(ItemSellStatus.SELL)
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

    @Test
    @DisplayName("query method Greater Than Equal And Like 테스트")
    public void findByStockNumberGreaterThanEqualAndItemNmLikeTest() {

        createItemList();
        itemRepository
                .findByStockNumberGreaterThanEqualAndItemNmLike(160, "%5%")
                .forEach(item -> System.out.println(item));

    }

    @Test
    @DisplayName("JPQL Greater Than Equal And Like 테스트")
    public void findByStockAndNameTest() {

        createItemList();
        itemRepository
                .findByStockAndName(160, "%5%")
                .forEach(item -> System.out.println(item));

    }

    @Test
    @DisplayName("Native Greater Than Equal And Like 테스트")
    public void findByStockAndNameNativeTest() {

        createItemList();
        itemRepository
                .findByStockAndNameNative(160, "%5%")
                .forEach(item -> System.out.println(item));

    }

    @Test
    @DisplayName("querydsl Greater Than Equal And Like 테스트")
    public void findByStockAndNameQuerydslTest() {

        createItemList();

        JPAQueryFactory query = new JPAQueryFactory(em);

        QItem qItem = QItem.item;
        query.selectFrom(qItem)
                .where(qItem.stockNumber.goe(160))
                .where(qItem.itemNm.like("%" + "5" + "%"))
                .fetch().forEach(item -> System.out.println(item));

    }

    public void createItemList2() {

        for (int i = 1; i <= 5; i++) {
            Item item = Item.builder()
                    .itemNm("테스트 상품" + i)
                    .price(10000 + i)
                    .itemDetail("테스트 상품 상세 설명" + i)
                    .itemSellStatus(ItemSellStatus.SELL)
                    .build();

            itemRepository.save(item);
        }

        for (int i = 6; i <= 10; i++) {
            Item item = Item.builder()
                    .itemNm("테스트 상품" + i)
                    .price(10000 + i)
                    .itemDetail("테스트 상품 상세 설명" + i)
                    .itemSellStatus(ItemSellStatus.SOLD_OUT)
                    .build();

            itemRepository.save(item);
        }

    }

    @Test
    @DisplayName("querydsl 테스트2")
    public void querydslTest2() {

        createItemList2();

        BooleanBuilder builder = new BooleanBuilder();  // 값이 존재하면 사용하고, 존재하지 않으면 사용하지 않는다.
        String itemDetail = "테스트";
        int price = 10002;
        String itemSellStatus = "SELL";

        QItem item = QItem.item;
        builder.and(item.itemDetail.like("%" + itemDetail + "%"));
        builder.and(item.price.gt(price));

        if(StringUtils.equals(itemSellStatus, ItemSellStatus.SELL)) {
            builder.and(item.itemSellStatus.eq(ItemSellStatus.SELL));
        }

        Pageable pageable = PageRequest.of(0, 5);

        Page<Item> page = itemRepository.findAll(builder, pageable);
        List<Item> content = page.getContent();
        content.stream().forEach(e -> System.out.println(e));

    }

}