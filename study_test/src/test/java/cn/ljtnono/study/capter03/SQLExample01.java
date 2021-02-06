package cn.ljtnono.study.capter03;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;

/**
 * 使用SQL类拼接动态SQL语句
 *
 * @author Ling, Jiatong
 * Date: 2021/2/6 8:52
 */
public class SQLExample01 {

    @Test
    public void example01() {
        String dic_vul = new SQL() {
            {
                SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME");
                SELECT("P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON");
                FROM("PERSON P");
                FROM("ACCOUNT A");
                INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID");
                INNER_JOIN("COMPANY C on D.COMPANY_ID = C.ID");
                WHERE("P.ID = A.ID");
                WHERE("P.FIRST_NAME like ?");
                OR();
                WHERE("P.LAST_NAME like ?");
                GROUP_BY("P.ID");
                HAVING("P.LAST_NAME like ?");
                ORDER_BY("P.ID");
                ORDER_BY("P.FULL_NAME");
            }
        }.toString();
        System.out.println(dic_vul);
    }

    @Test
    public void testInsertSql() {
        String insertSql = new SQL() {
            {
                INSERT_INTO("PERSON");
                VALUES("ID, FIRST_NAME", "#{id}, #{firstName}").VALUES("LAST_NAME", "#{lastName}");
            }
        }.toString();
        System.out.println(insertSql);
    }

    @Test
    public void testDeleteSql() {
        String deleteSql = new SQL() {
            {
                DELETE_FROM("PERSON");
                WHERE("ID = #{id}");
            }
        }.toString();
        System.out.println(deleteSql);
    }

    @Test
    public void testUpdateSql() {
        String updateSql = new SQL() {
            {
                UPDATE("PERSON");
                SET("FIRST_NAME = #{firstName}");
                WHERE("ID = #{id}");
            }
        }.toString();
        System.out.println(updateSql);
    }
}
