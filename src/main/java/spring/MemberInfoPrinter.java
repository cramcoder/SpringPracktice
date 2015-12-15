package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class MemberInfoPrinter {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter printer;
	
	

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	

	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	@Autowired
	public void printMemberInfo(String email){
		Member member = memberDao.selectByEmail(email);
		if(member == null){
			System.out.println("데이터없음");
			return;
		}
		
		printer.print(member);
		System.out.println();
	}
	
}
