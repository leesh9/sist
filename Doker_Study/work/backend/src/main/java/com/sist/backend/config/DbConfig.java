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
    
    @Value("${mapper-location}")
    private String mapper_uri;

    @Bean
    public SqlSessionFactory sqlSessionFactory(
    DataSource ds)throws Exception{
        SqlSessionFactoryBean sb = 
            new SqlSessionFactoryBean();
        
        sb.setDataSource(ds);

        PathMatchingResourcePatternResolver resolver =
            new PathMatchingResourcePatternResolver();

        sb.setMapperLocations(resolver.getResources(mapper_uri));

        return sb.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(
        SqlSessionFactory factory){
            return new SqlSessionTemplate(factory);
    }

}
