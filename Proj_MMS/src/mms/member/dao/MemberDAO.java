package mms.member.dao;
//9. Oracle DB로 필요한 SQL구문을 전송하는 클래스 구현
import static mms.member.db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberDAO {
	
	Connection con;
	public MemberDAO(Connection con) {
		this.con = con;
	}
	// 1. 회원 등록
	public int insertNewMember(Member newMember) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "INSERT INTO mms_member VALUES(mms_member_id_seq.nextval,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,newMember.getName());
			pstmt.setString(2,newMember.getAddr());
			pstmt.setString(3,newMember.getNation());
			pstmt.setString(4,newMember.getEmail());
			pstmt.setInt(5,newMember.getAge());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return insertCount;
	}
	// 2. 회원 목록 보기
	public ArrayList<Member> selectMemberList() {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<Member> memberList = new ArrayList<> ();
		String sql = "SELECT * FROM mms_member";
		Member member = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String nation = rs.getString("nation");
				String email = rs.getString("email");
				int age = rs.getInt("age");
				
				member = new Member(name,addr,nation,email,age);
				memberList.add(member);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		
		return null;

		
	}
	// 3. 특정 회원 정보 보기
	public Member selectOldMember(String name) {
		return null;


		
		
	}
	
	// 4. 회원정보 수정
	public int updateMember(Member updateMember) {
		PreparedStatement pstmt = null;
		int updateCount =  0;
		String sql = "UPDATE mms_member set addr=?, nation =?, email=?, age=? where name =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateMember.getAddr());
			pstmt.setString(2, updateMember.getNation());
			pstmt.setString(3, updateMember.getEmail());
			pstmt.setInt(4, updateMember.getAge());
			pstmt.setString(5, updateMember.getName());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { JdbcUtil.close(pstmt); }
		
		return 0;



		
		
	}
	
	// 5. 회원정보 삭제 	
	public int deleteMember(String name) {
		return 0;


		
		
	}
}
