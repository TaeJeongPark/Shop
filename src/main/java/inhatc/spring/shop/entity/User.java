package inhatc.spring.shop.entity;

import jakarta.persistence.*;

/**
 * packageName    : inhatc.spring.shop.entity
 * fileName       : User
 * author         : TaeJeongPark
 * date           : 2023-09-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-06        TaeJeongPark       최초 생성
 */
@Entity
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;

    @Column(length = 30)
    private String name;

}
