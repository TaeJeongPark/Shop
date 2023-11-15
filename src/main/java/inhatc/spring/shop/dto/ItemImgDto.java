package inhatc.spring.shop.dto;

import inhatc.spring.shop.entity.ItemImg;
import org.modelmapper.ModelMapper;

/**
 * packageName    : inhatc.spring.shop.dto
 * fileName       : ItemImgDto
 * author         : TaeJeongPark
 * date           : 2023-11-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-15        TaeJeongPark       최초 생성
 */
public class ItemImgDto {

    private Long id;                        // 아이템 이미지 코드

    private String imgName;                 // 이미지 파일명

    private String oriImgName;              // 원본 이미지 파일명

    private String imgUrl;                  // 이미지 URL

    private String repImgYn;                // 대표 이미지 여부

    public static ModelMapper modelMapper = new ModelMapper();

    public static ItemImgDto of(ItemImg itemImg) {
        return modelMapper.map(itemImg, ItemImgDto.class);
    }

}
