package com.shop.test;

import com.shop.utils.JdbcUilts;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUlitsTest {
    @Test
    public void getConnection(){
        System.out.println(JdbcUilts.getConnection());
    }

    @Test
    public void close(){
        Connection connection=JdbcUilts.getConnection();
        JdbcUilts.close(connection);
    }
}
