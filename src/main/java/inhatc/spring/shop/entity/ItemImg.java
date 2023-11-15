package inhatc.spring.shop.entity;

import inhatc.spring.shop.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * packageName    : inhatc.spring.shop.entity
 * fileName       : ItemImage
 * author         : TaeJeongPark
 * date           : 2023-11-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-15        TaeJeongPark       최초 생성
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemImg extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_img_id")
    private Long id;                        // 아이템 이미지 코드

    private String imgName;                 // 이미지 파일명

    private String oriImgName;              // 원본 이미지 파일명

    private String imgUrl;                  // 이미지 URL

    private String repImgYn;                // 대표 이미지 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;                      // 상품

    public void updateItemImg(String oriImgName, String imgName, String imgUrl) {
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }

}
