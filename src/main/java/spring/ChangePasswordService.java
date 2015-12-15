package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {
	@Autowired
	private MemberDao memberDao;
	
	public ChangePasswordService(){}
	public ChangePasswordService(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	
	
	public void changePassword(String email, String oldPw, String newPw){
		Member member = memberDao.selectByEmail(email);
		if(member != null){
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPw, newPw);
		memberDao.update(member);
	}
}
