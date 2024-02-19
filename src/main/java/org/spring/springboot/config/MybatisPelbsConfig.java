package org.spring.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @projectName: admin-system
 * @package: org.spring.springboot.config.MybatisPelbsConfig
 * @className: MybatisPelbsConfig
 * @author: Chen Dehong
 * @description: pelbs_data数据源配置
 * @date: 2/3/2024 6:29 PM
 * @version: 1.0
 */
@Configuration
@MapperScan(basePackages = "org.spring.springboot.dao.pelbsData", sqlSessionFactoryRef = "pelbsDataSqlSessionFactory")
public class MybatisPelbsConfig {
    @Bean(name = "pelbsDataDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.pelbs-data")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "pelbsDataSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("pelbsDataDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/pelbsData/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("org.spring.springboot.domain.pelbsData");
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }

}
