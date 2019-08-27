package com.util;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

public class DButil {
    private static DataSource dataSource=null;
    private Connection conn=null;
    private PreparedStatement stat=null;
    private ResultSet res=null;
    private CallableStatement callStat=null;
    static{
        Properties prop=new Properties();
        try{
            prop.load(DButil.class.getClassLoader().getResourceAsStream("dbcp_config.properties"));
            dataSource=BasicDataSourceFactory.createDataSource(prop);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected  Connection getConnection() {
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            System.err.println("数据库连接出错");
            e.printStackTrace();
        }
        return conn;
    }


    protected void closeALL(Connection conn ,PreparedStatement stat,ResultSet res) throws SQLException {
        try{
            if(res!=null)
                res.close();
        }finally {
            try{
                if(stat!=null)
                    stat.close();
            }finally {
                if(conn!=null)
                    conn.close();
            }

        }
    }

    protected  ResultSet queryDB(String sql,Object... objs)throws  SQLException{
        stat=getConnection().prepareStatement(sql);
        if(objs!=null){
            for (int i=0;i<objs.length;i++)
                stat.setObject(i+1,objs[i]);
        }
        res=stat.executeQuery();
        return res;
    }

    protected int updateDB(String sql, Object...objs)throws SQLException{
        int result=0;
        try{
            stat=getConnection().prepareStatement(sql);
            if(objs!=null){
                for (int i=0;i<objs.length;i++)
                    stat.setObject(i+1,objs[i]);
            }
            result=stat.executeUpdate();
        }finally {
            closeALL(conn,stat,res);
        }
        return result;

    }

}
