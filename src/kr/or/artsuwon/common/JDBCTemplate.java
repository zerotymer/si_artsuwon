package kr.or.artsuwon.common;

import java.sql.*;

public class JDBCTemplate {
    /// FIELDs
    final private static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
    final private static String DB_URL = "jdbc:oracle:thin:@khds-b1.iptime.org:21521:xe";
    final private static String DB_USER = "artsuwon";
    final private static String DB_PASSWORD = "gucci951124";

    /// METHODs
    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName(DRIVER_NAME);

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // disable AutoCommit
            conn.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void commit(Connection conn) {
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback(Connection conn) {
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rset) {
        try {
            rset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
