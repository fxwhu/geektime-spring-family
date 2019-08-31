package geektime.spring.data.druiddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

/**
 * @author: fengxuan
 * @create 2019-08-30 14:49
 **/
@RestController
@RequestMapping("/food")
public class DruidDemoController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/insert")
    @ResponseBody
    public String insertData() {
        for (int i = 0; i < 100; i++) {
            jdbcTemplate.update("insert into food (`id`,`name`) values (?,?)", i, "apple" + i);
        };
        return "ok";
    }

    @RequestMapping("/getNameById")
    @ResponseBody
    public String getNameById(@RequestParam(required = true) int id) {
        return jdbcTemplate.query("select `name` from food where id = ?", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, id);
            }
        }, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                return resultSet.getString(1);
            }
        });
    }
}
