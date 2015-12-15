package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListPrinter {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter printer;
	
	//
	
	public MemberListPrinter(MemberDao memberDao,  MemberPrinter printer){
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	@Autowired
	public void selectAll(){
		Collection<Member> members = memberDao.selectAll();
		for(Member m : members){
			printer.print(m);
		}
	}
}
