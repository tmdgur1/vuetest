package com.example.demo.settings;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(
		value = "com.example.demo.mapper.Mappers", 
		sqlSessionFactoryRef = "mssqlSqlSessionFactory", 
		sqlSessionTemplateRef = "mssqlSqlSessionTemplate")
public class MybatisSettings {
	
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "datasource")
	public DataSource getMssqlDataSource() {
		
//		DB 정보 직접 입력
//		DataSource dataSource = 
//				DataSourceBuilder.create()
//				.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
//				.url("jdbc:sqlserver://112.162.225.130")
//				.username("MMS")
//				.password("BP0620MMS")
//				.build();
		
		DataSource dataSource = DataSourceBuilder.create().build();
		
		return dataSource;
	}
	
	@Bean(name = "sqlSessionFactory")
	@Autowired
	public SqlSessionFactory getSqlSessionFactory(
			DataSource mssqlDataSource, 
			ApplicationContext applicationContext) throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(mssqlDataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/**/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name = "transactionFactory")
	@Autowired
	public DataSourceTransactionManager getTransactionFactory(DataSource mssqlDataSource) {
		
		DataSourceTransactionManager manager = new DataSourceTransactionManager(mssqlDataSource); 
		
		return manager;
	}
	
	@Bean(name = "sqlSessionTemplate")
	@Autowired
	public SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory mssqlSqlSessionFactory) {
		
		return new SqlSessionTemplate(mssqlSqlSessionFactory);
	}
}
