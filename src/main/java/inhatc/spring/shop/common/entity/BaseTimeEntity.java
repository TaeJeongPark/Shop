package inhatc.spring.shop.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * packageName    : inhatc.spring.shop.common.entity
 * fileName       : BaseTimeEntity
 * author         : TaeJeongPark
 * date           : 2023-11-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-15        TaeJeongPark       최초 생성
 */
@EntityListeners(value = {AuditingEntityListener.class})    // JPA에게 해당 Entity는 Auditing 기능을 사용한다는 것을 알리는 어노테이션
@MappedSuperclass   // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들도 칼럼으로 인식하도록 함
@Getter
@Setter
public abstract class BaseTimeEntity {

    @CreatedDate    // Entity가 생성되어 저장될 때 시간이 자동 저장됨
    @Column(updatable = false)  // 생성일은 수정이 불가능하도록 함
    private LocalDateTime regTime;

    @LastModifiedDate   // 조회한 Entity의 값을 변경할 때 시간이 자동 저장됨
    private LocalDateTime updateTime;

}
