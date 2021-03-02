package cn.ljtnono.study.capter03;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 使用ScriptRunner工具类执行SQL脚本
 *
 * @author Ling, Jiatong
 * Date: 2021/2/6 9:32
 */
public class ScriptRunnerExample01 {

    @Test
    public void example01() throws SQLException, IOException {
        DataSource dataSource = new UnpooledDataSource("org.h2.Driver", "jdbc:h2:mem:default;MODE=MSSQLServer;", "", "");
        // 获取连接
        Connection connection = dataSource.getConnection();
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        // 一次性插入
        scriptRunner.setSendFullScript(true);
        // 执行SQL脚本
        scriptRunner.runScript(Resources.getResourceAsReader("capter03/create_table.sql"));
        scriptRunner.runScript(Resources.getResourceAsReader("capter03/insert_data.sql"));
    }

}
