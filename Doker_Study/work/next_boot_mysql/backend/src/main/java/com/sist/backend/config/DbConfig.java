package com.sist.backend.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.sist.backend.mapper")
public class DbConfig {
    //현재 클래스는 스프링 환경이 알아서 호출하며, 아래의
    // @Bean이라는 어노테이션 때문에
    // 강제로 함수들을 한번 호출하여 스프링 환경(Context)에
    // 반환되는 객체들을 등록한다.
    @Value("${mapper-locations}")
    private String mapperLocations;

    @Bean
    public SqlSessionFactory sqlSessionFactory(
        DataSource dataSource) throws Exception{
            SqlSessionFactoryBean factoryBean = 
                new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource);

            PathMatchingResourcePatternResolver resolver =
                new PathMatchingResourcePatternResolver();
            
            factoryBean.setMapperLocations(
                resolver.getResources(
                    mapperLocations));

            return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(
        SqlSessionFactory factory){
            return new SqlSessionTemplate(factory);
    }
}





