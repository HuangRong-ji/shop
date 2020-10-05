package com.shop.dao;

import com.shop.utils.JdbcUilts;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    //使用DBUtils操作数据库
    //等价于一阶段PrepareStatement语句执行平台
    private QueryRunner queryRunner=new QueryRunner();

    /**
     * update方法 用来执行Insert/Update/Delete语句
     *
     * @param sql
     * @param args
     * @return 返回-1证明执行失败，数据库没有改变。
     */
    public int update(String sql,Object... args){
        Connection connection=JdbcUilts.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUilts.close(connection);
        }
        return -1;
    }

    /**
     * 查询返回单个JavaBean对象的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  sql语句
     * @param args sql对象的参数值（就是？对应的值。有多少个？就有多少个值）
     * @param <T>  返回类型的泛型
     * @return 返回null证明没有东西，证明查询失败
     */
    public <T> T queryForOne(Class<T> type,String sql,Object... args){
        Connection connection= JdbcUilts.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUilts.close(connection);
        }
        return null;
    }

    /**
     *  查询返回多个JavaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql sql语句
     * @param args sql对象的参数值（就是？对应的值。有多少个？就有多少个值）
     * @param <T> 返回类型的泛型
     * @return 返回null证明没有东西，证明查询失败
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args){
        Connection connection=JdbcUilts.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUilts.close(connection);
        }
        return null;
    }

    /**
     * 查询一行一列的sql语句
     *
     * @param sql sql语句
     * @param args 可变的参数个数
     * @return 返回null证明没有查询到东西
     */
    public Object queryForSingeValue(String sql,Object... args){
        Connection connection=JdbcUilts.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUilts.close(connection);
        }
        return null;
    }
}
