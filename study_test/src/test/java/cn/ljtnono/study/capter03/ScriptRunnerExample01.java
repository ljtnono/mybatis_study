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
        DataSource dataSource = new UnpooledDataSource("jdbc:hsqldb:mem:mybatis", "jdbc:mysql://192.168.172.107:8013/xmirror_oss?useUnicode=true&allowPublicKeyRetrieval=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=Asia/Shanghai", "root", "xxx");
        // 获取连接
        Connection connection = dataSource.getConnection();
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        // 执行SQL脚本
        scriptRunner.runScript(Resources.getResourceAsReader("create_table.sql"));
    }

}
