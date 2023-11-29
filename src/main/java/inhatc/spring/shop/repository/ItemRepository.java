package inhatc.spring.shop.repository;

import inhatc.spring.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * packageName    : inhatc.spring.shop.repository
 * fileName       : ItemRepository
 * author         : TaeJeongPark
 * date           : 2023-09-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-13        TaeJeongPark       최초 생성
 */
public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item>, ItemRepositoryCustom {       // ItemRepositoryCustom - 검색기능 추가 {

    List<Item> findByItemNm(String itemNm);

    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    List<Item> findByPriceLessThanOrderByPriceDesc(int price);

    @Query("SELECT i FROM Item i WHERE i.itemDetail LIKE %:itemDetail% ORDER BY i.price DESC")
    List<Item> findByDetail(@Param("itemDetail") String itemDetail);

    @Query(value = "SELECT * FROM item i WHERE i.item_detail LIKE %:itemDetail% ORDER BY i.price DESC", nativeQuery = true)
    List<Item> findByDetailNative(@Param("itemDetail") String itemDetail);

    List<Item> findByStockNumberGreaterThanEqualAndItemNmLike(int stockNumber, String itemNm);

    @Query("SELECT i FROM Item i WHERE i.stockNumber >= :stockNumber AND i.itemNm LIKE %:itemNm%")
    List<Item> findByStockAndName(@Param("stockNumber") int stockNumber, @Param("itemNm") String itemNm);

    @Query(value = "SELECT * FROM Item i WHERE i.stock_number >= :stockNumber AND i.item_nm LIKE %:itemNm%", nativeQuery = true)
    List<Item> findByStockAndNameNative(@Param("stockNumber") int stockNumber, @Param("itemNm") String itemNm);

}
