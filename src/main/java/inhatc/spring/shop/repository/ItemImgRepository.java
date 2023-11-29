package inhatc.spring.shop.repository;

import inhatc.spring.shop.entity.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * packageName    : inhatc.spring.shop.repository
 * fileName       : ItemImgRepository
 * author         : TaeJeongPark
 * date           : 2023-11-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-29        TaeJeongPark       최초 생성
 */
public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {

    List<ItemImg> findByItemIdOrderByIdAsc(Long itemId);

}
