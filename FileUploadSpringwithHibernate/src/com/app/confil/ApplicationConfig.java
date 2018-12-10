package com.app.confil;

import java.util.Properties;

import javax.sql.DataSource;

import org.omg.CORBA.Environment;

import com.entitys.User;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.dao","com.service","com.controllers"}) 
public class ApplicationConfig extends WebMvcConfigurerAdapter{
	@Autowired
    private Environment environment;
  
	
	@Bean(name="multipartResolver")
	    public CommonsMultipartResolver resolver(){
	        return new CommonsMultipartResolver();
	    }
	 
	    /**
	     * Configure ViewResolvers to deliver preferred views.
	     */
	    @Override
	    public void configureViewResolvers(ViewResolverRegistry registry) {
	 
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/jsp/");
	        viewResolver.setSuffix(".jsp");
	        registry.viewResolver(viewResolver);
	    }
	    
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/fileupload");
	        dataSource.setUsername("praveen");
	        dataSource.setPassword("kalluru");
	        return dataSource;
	    }
	    @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        sessionFactory.setAnnotatedClasses(User.class);
	        return sessionFactory;
	     }
	    private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        properties.put("hibernate.show_sql", true);
	        properties.put("hibernate.format_sql", true);
	        return properties;        
	    }
	    @Bean(autowire = Autowire.BY_TYPE)
		public HibernateTemplate hibernateTemplate() {
			return new HibernateTemplate();
		}
	    @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory s) {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	       return txManager;
	    }

}
