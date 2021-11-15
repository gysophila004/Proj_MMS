package mms.member.svc;
//8-1. 회원등록 Business Logic이 구현되는 Service 클래스 구현

import static mms.member.db.JdbcUtil.*;
import java.sql.Connection;
import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberAddService {

	public boolean addMember(Member newMember) throws Exception{
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		int insertCount = memberDAO.insertNewMember(newMember);
		if (insertCount > 0){
			JdbcUtil.commit(con);
			boolean isInsertSuccess = true;
		} else {
			JdbcUtil.rollback(con);
			
		}
		
				
		//commit();
		//rollback();
	
		return isInsertSuccess;
	}
}
