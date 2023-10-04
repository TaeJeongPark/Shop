package inhatc.spring.shop.dto;

import lombok.*;

/**
 * packageName    : inhatc.spring.shop.dto
 * fileName       : paramDto
 * author         : TaeJeongPark
 * date           : 2023-10-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-04        TaeJeongPark       최초 생성
 */
@Getter
@Setter
@ToString               // 콘솔에 출력 가능
@AllArgsConstructor     // 모든 생성자 생성(빈 생성자 제외)
@NoArgsConstructor      // 빈 생성자 생성
@Builder                // 선택적으로 생성자 생성
public class ParamDto {

    private String param1;
    private String param2;

}
