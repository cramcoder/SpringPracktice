package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Assembler {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberRegisterService regSvc;
	@Autowired
	private ChangePasswordService pwdSvc;
	
	public Assembler(){
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService(memberDao);
	}

	public MemberDao getMemberDao() {return memberDao;}
	public MemberRegisterService getRegSvc() {return regSvc;}
	public ChangePasswordService getPwdSvc() {return pwdSvc;}
	
}
