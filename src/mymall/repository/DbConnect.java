package mymall.repository;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 4
 * Time: 오후 6:12
 * To change this template use File | Settings | File Templates.
 */
public class DbConnect {
    public Connection dbConnect() {
        String url = "jdbc:postgresql://localhost:5432/MYMALL";
        String usr = "mymall";
        String pwd = "1004";
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usr, pwd);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public void dbClose(PreparedStatement pstmt){
        try{
            if(pstmt!=null) { pstmt.close(); }
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void dbClose(Connection conn){
        try{
            if(conn!=null) { conn.close(); }
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void dbClose(PreparedStatement pstmt, Connection conn){
        try{
            if(pstmt!=null) { pstmt.close(); }
            if(conn!=null) { conn.close(); }
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn){
        try{
            if(rs!=null) { rs.close(); } // connect()한 순서 역순으로
            if(pstmt!=null) { pstmt.close(); }
            if(conn!=null) { conn.close(); }
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
