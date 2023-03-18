package org.spring.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;import javax.sql.DataSource;

/**
 * res数据源配置
 *
 * @Author : zhoubin
 * @Date : 2023-01-16 21:51
 */
@Configuration
@MapperScan(basePackages = "org.spring.springboot.dao.res", sqlSessionFactoryRef = "testSqlSessionFactory")
public class MybatisResConfig {

    @Bean(name = "testDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.res")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("testSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean ();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/res/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("org.spring.springboot.domain.res");
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();

    }

}
