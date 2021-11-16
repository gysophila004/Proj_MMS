package mms.member.svc;
//8-3. 회원정보 수정 요청을 처리하는 Business Logic이 구현되는 Service 클래스 구현
import java.sql.Connection;
import static mms.member.db.JdbcUtil.*;
import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberModifyService {

//	public Member getOldMember(String name) {
//
//
//
//
//
//
//		
//		
//	}

	public boolean modifyMember(Member updateMember) {
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		boolean isModifySuccess = false;
		int updateCount = memberDAO.updateMember(updateMember);
		if(updateCount >0) {
			isModifySuccess = true;
			JdbcUtil.commit(con);
		} else {
			JdbcUtil.rollback(con);
		}
		JdbcUtil.close(con);
		return isModifySuccess;
	}

}
