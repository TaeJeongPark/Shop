package inhatc.spring.shop.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : inhatc.spring.shop.config
 * fileName       : MappingConfig
 * author         : TaeJeongPark
 * date           : 2023-11-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-15        TaeJeongPark       최초 생성
 */
@Configuration
public class MappingConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
