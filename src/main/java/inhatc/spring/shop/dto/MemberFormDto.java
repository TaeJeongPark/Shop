package inhatc.spring.shop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * packageName    : inhatc.spring.shop.dto
 * fileName       : MemberFormDto
 * author         : TaeJeongPark
 * date           : 2023-10-11
 * description    : 회원가입 정보 DTO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-11        TaeJeongPark       최초 생성
 */
@Getter
@Setter
@ToString               // 콘솔에 출력 가능
@AllArgsConstructor     // 모든 생성자 생성(빈 생성자 제외)
@NoArgsConstructor      // 빈 생성자 생성
@Builder                // 선택적으로 생성자 생성
public class MemberFormDto {

    @NotBlank(message = "이름은 필수 항목입니다.")
    private String name;

    @NotEmpty(message = "이메일은 필수 항목입니다.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 항목입니다.")
    @Length(min = 4, max = 16, message = "비밀번호는 4자 이상 16자 이하로 입력해주세요.")
    private String password;

    @NotEmpty(message = "주소는 필수 항목입니다.")
    private String address;

}
