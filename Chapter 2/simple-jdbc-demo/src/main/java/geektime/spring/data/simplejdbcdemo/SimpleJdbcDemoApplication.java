package geektime.spring.data.simplejdbcdemo;

import geektime.spring.data.simplejdbcdemo.configuratabletest.Account;
import geektime.spring.data.simplejdbcdemo.event.SadEvent;
import geektime.spring.data.simplejdbcdemo.event.SadEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;


@SpringBootApplication
@EnableLoadTimeWeaving
@EnableAspectJAutoProxy
@EnableSpringConfigured
@Slf4j
public class SimpleJdbcDemoApplication implements CommandLineRunner {
    @Autowired
    private FooDao fooDao;
    @Autowired
    private BatchFooDao batchFooDao;
    @Autowired
    SadEventPublisher sadEventPublisher;

    public static void main(String[] args) {
        SpringApplication.run(SimpleJdbcDemoApplication.class, args);
    }

    @Bean
    @Autowired
    public SimpleJdbcInsert simpleJdbcInsert(JdbcTemplate jdbcTemplate) {
        return new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("FOO").usingGeneratedKeyColumns("ID");
    }

    @Bean
    @Autowired
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void run(String... args) throws Exception {
        //testDB();
        //testConfigurable();
        testEvent();
    }


    public void testDB() {
        fooDao.insertData();
        batchFooDao.batchInsert();
        fooDao.listData();
    }

    public void testConfigurable() {
        Account account = new Account();
        account.outPrint();
    }

    public void testEvent() {
        SadEvent sadEvent = new SadEvent(this, "patient", "advisor");
        sadEventPublisher.sendSadMessage(); }

}
