package mms.member.action;
//7-1 회원등록 요청 처리하는 Action 클래스 구현
import java.util.Scanner;
import mms.member.svc.MemberAddService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil cu = new ConsoleUtil();
		Member newMember = cu.getNewMember(sc); //회원 등록 입력 자료
		MemberAddService memberAddService = new MemberAddService();
		boolean isAddSucess = memberAddService.addMember(newMember);
		if(isAddSucess)
			cu.printAddSuccessMessage(newMember);
		else
			cu.printAddFailMessage(newMember);
	}


}
