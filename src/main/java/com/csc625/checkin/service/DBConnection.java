package com.csc625.checkin.service;

import java.sql.Connection;
import java.sql.DriverManager;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.csc625.checkin.utils.DBConfig;



public class DBConnection 
{
    private static final String USERNAME = DBConfig.USERNAME;
    private static final String PASSWORD = DBConfig.PASSWORD;
    private static final String URL = DBConfig.URL;
    
    static Connection conn = null;
    static DSLContext dslContext = null;
    public static DSLContext getConnection()
    {
        if(conn != null) 
            return dslContext;
        else
            return getConnection(URL,USERNAME,PASSWORD);
    }
    
    private static DSLContext getConnection(String url, String pwd, String usrName)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            dslContext = DSL.using(conn, SQLDialect.MYSQL);
        }catch(Exception e)
        {
            e.printStackTrace();
        }        
        return dslContext;
    }
        
}