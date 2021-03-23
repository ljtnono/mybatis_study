package cn.ljtnono.study.capter03;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.jdbc.SqlRunner;
import org.apache.ibatis.session.Configuration;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * 使用SqlRunner工具类执行sql语句
 *
 * @author Ling, Jiatong
 * Date: 2021/3/3 12:45 上午
 */
public class SqlRunnerExample01 {


    private static DataSource dataSource;

    @Before
    public void pre() throws SQLException, IOException {
        dataSource = new UnpooledDataSource("org.h2.Driver", "jdbc:h2:mem:default;MODE=MSSQLServer;", "", "");
        Connection connection = dataSource.getConnection();
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        // 一次性插入
        scriptRunner.setSendFullScript(true);
        scriptRunner.runScript(Resources.getResourceAsReader("capter03/create_table.sql"));
        scriptRunner.runScript(Resources.getResourceAsReader("capter03/insert_data.sql"));
    }

    @Test
    public void testSelectOne() throws SQLException {
        Connection connection = dataSource.getConnection();
        SqlRunner sqlRunner = new SqlRunner(connection);
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("user");
                WHERE("id = ?");
            }
        }.toString();
        Map<String, Object> resultMap = sqlRunner.selectOne(sql, "1");
        System.out.println(resultMap);
    }

    @Test
    public void testDelete() {

    }

}
