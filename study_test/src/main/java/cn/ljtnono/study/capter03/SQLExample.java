package cn.ljtnono.study.capter03;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;

/**
 * @author Ling, Jiatong
 * Date: 2021/2/1 23:08
 */
public class SQLExample {


    @Test
    public void testInsertSql() {
        String insertSql = new SQL()
                .INSERT_INTO("PERSON")
                .VALUES("ID", "").toString();
        System.out.println(insertSql);
    }

}
