package geektime.spring.data.druiddemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
@Slf4j
public class DruidDemoApplication implements CommandLineRunner {
	@Autowired
	private DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DruidDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Connection connection = dataSource.getConnection();
		log.info("dataSource:{}" + dataSource.toString());
		log.info("connect:{}", connection.toString());
		connection.close();
		createTable();
		showData();
	}

	private void showData() {
		jdbcTemplate.queryForList("SELECT * FROM FOO")
				.forEach(row -> log.info(row.toString()));
	}


	private void createTable() {
		//jdbcTemplate.execute("CREATE TABLE foo (id INT IDENTITY, bar VARCHAR(64));");
		//jdbcTemplate.execute("CREATE table food (id int identity, name varchar(64));");
		//jdbcTemplate.execute("INSERT INTO foo (id, BAR) VALUES (1, 'aaa');");
	}
}

