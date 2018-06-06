package phanmemquanlythuvien.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tainguyen
 */
public class KetNoi {
    public static Connection conn;
    public static String database="ThuVien";
    public static String account="sa";
    public static String password="P@ssw0rd";
    public static Connection getDBConnection(String db, String acc, String pass)
    {
        try {
            String url = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            //String url = "com.mysql.jdbc.Driver";
            Class.forName(url);
            String dbUrl = "jdbc:sqlserver://172.16.65.129:1433;databaseName="+db;
            //String dbUrl = "jdbc:mysql://localhost:3306"+db
            conn = DriverManager.getConnection(dbUrl,acc,pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}