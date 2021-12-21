package kr.or.artsuwon.common;

import java.sql.*;

/**
 * JDBC 사용을 위한 공통 클래스.
 * sigleton 패턴으로 사용한다.
 * @author 신현진
 */
public class JDBCTemplate {
    /// FIELDs
    final private static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
    final private static String DB_URL = "jdbc:oracle:thin:@khds-b1.iptime.org:21521:xe";
    final private static String DB_USER = "artsuwon";
    final private static String DB_PASSWORD = "gucci951124";

    /// METHODs

    /**
     * Connection을 생성하는 메소드
     * @return Connection
     * @author 신현진
     */
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

    /**
     * Commit을 수행하는 메소드
     * @param conn Connection
     * @author 신현진
     */
    public static void commit(Connection conn) {
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Rollback을 수행하는 메소드
     * @param conn Connection
     * @author 신현진
     */
    public static void rollback(Connection conn) {
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 사용한 Connection을 닫는 메소드
     * @param conn Connection
     * @author 신현진
     */
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 사용한 ResultSet을 닫는 메소드
     * @param rset ResultSet
     * @author 신현진
     */
    public static void close(ResultSet rset) {
        try {
            rset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 사용한 Statement를 닫는 메소드
     * @param stmt Statement
     * @author 신현진
     */
    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
