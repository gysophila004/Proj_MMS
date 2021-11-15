package mms.member.db;


//1. DB관련 공통 기능 클래스
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	
// 메모리에 실행된 상태로 존재
	static{
		//클래스가 로딩될 때 단 한번 호출되는 영역
		//Class.forName : 특정 클래스를 메모리로 로딩하는 메소드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다.");
		}		
	}
//	메모리에 있는 메소드 호출이 일어나야 실행
	public static Connection getConnection(){
		//디비 작업에 필요한 Connection 객체를 생성해 주는 메소드
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			con = DriverManager.getConnection(url, "javalink", "javalink");
			con.setAutoCommit(false);//true: 커밋 실행
									//false: 커밋할 수 있는 시작점(Transaction 시작)
			System.out.println("Connection Success!");
		} catch (SQLException e) {
			System.out.println("Connection Failed");
		}
		return con;
		
	}
	
	public static void close(Connection con){
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt){
		try{
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstmt){
		try{
			pstmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs){
		try{
			rs.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}













	
	
	//transaction 처리 메소드

	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}


}



