package geektime.spring.data.declarativetransactiondemo;

import geektime.spring.data.declarativetransactiondemo.aspectj.AdvicedService;
import geektime.spring.data.declarativetransactiondemo.aspectj.domain.*;
import geektime.spring.data.declarativetransactiondemo.aspectj.person.Man;
import geektime.spring.data.declarativetransactiondemo.aspectj.person.Person;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@EnableAspectJAutoProxy
@EnableTransactionManagement(proxyTargetClass = true)
@Slf4j
public class DeclarativeTransactionDemoApplication implements CommandLineRunner {
	@Autowired
	private FooServiceImpl fooService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	AdvicedService advicedService;
	@Autowired
	Person person;
	@Autowired
	SecondSimpleBean secondSimpleBean;
	@Autowired
	FirstSimpleBean firstSimpleBean;
	@Autowired
	FirstSimpleBeanConsumer firstSimpleBeanConsumer;
	@Autowired
	SecondSimpleBeanConsumer secondSimpleBeanConsumer;

	public static void main(String[] args) {
		SpringApplication.run(DeclarativeTransactionDemoApplication.class, args);
	}


	public void testTransaction() {
		fooService.insertRecord();
		log.info("AAA {}",
				jdbcTemplate
						.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='AAA'", Long.class));
		try {
			fooService.insertThenRollback();
		} catch (Exception e) {
			log.info("BBB {}",
					jdbcTemplate
							.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
		}

		try {
			fooService.invokeInsertThenRollback();
		} catch (Exception e) {
			log.info("BBB {}",
					jdbcTemplate
							.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
		}
	}


	@Override
	public void run(String... args) throws Exception {
		//person.eat();
		//((AdvicedService)person).insert("test1", 11);

		//advicedService.doCountBySomeCondition("name", List.of("age", "school"));
		//advicedService.insert("name", 12);
		testComponentVsConfiguration();
	}


	public void testComponentVsConfiguration() {
		log.info("firstSimpleBeanConsumer:{},firstSimpleBean:{}", firstSimpleBeanConsumer, firstSimpleBean);
		log.info("secondSimpleBeanConsumer:{},secondSimpleBean:{}", secondSimpleBeanConsumer, secondSimpleBean);
	}
}

