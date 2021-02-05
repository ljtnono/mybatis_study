package cn.ljtnono.study.capter03;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author Ling, Jiatong
 * Date: 2021/2/1 23:08
 */
public class SQLExample {

    public static void main(String[] args) {
        String insertSql = new SQL()
                .INSERT_INTO("PERSON")
                .VALUES("ID", "").toString();
        System.out.println(insertSql);
    }
}
