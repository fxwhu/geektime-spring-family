package geektime.spring.data.datasourcedemo;

import geektime.spring.data.datasourcedemo.event.SadEvent;
import geektime.spring.data.datasourcedemo.event.SadEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//单个数据源
@SpringBootApplication
@RestController
@Slf4j
public class DataSourceDemoApplication implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
	private SadEventPublisher sadEventPublisher;

    public static void main(String[] args) {
        SpringApplication.run(DataSourceDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //showConnection();
        //showData();
		testEvent();
    }

    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info(conn.toString());
        conn.close();
    }

    @RequestMapping("/getFoodName")
    @ResponseBody
    public ResponseEntity<List<String>> getName() {
        return ResponseEntity.ok(getFoodName());
    }


    private List<String> getFoodName() {
        return jdbcTemplate.queryForList("select name from food", String.class);
    }

    private void showData() {
        jdbcTemplate.queryForList("SELECT * FROM FOO")
                .forEach(row -> log.info(row.toString()));
    }

    public void testEvent() {
        sadEventPublisher.sendSadMessage();
        sadEventPublisher.sendContextStartEvent();
    }
}

