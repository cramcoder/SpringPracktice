package spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForAssembler {
	private static Assembler assembler = new Assembler();
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("명령어를 입력하세요");
			String command = reader.readLine();
			
			if(command.equals("exit")){
				System.out.println("종료합니다.");
				break;
			}
			
			if(command.startsWith("new")){
				
				
			}
			else if(command.startsWith("change")){
				
				
			}
			
			printHelp();
		}
	}
	
	
	private static void printHelp(){
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요");
		System.out.println("명령어 사용법: ");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println();
		
	}
	
	private static void processNewCommand(String[] args){
		if(args.length != 5){
			printHelp();
			return;
		}
		
		MemberRegisterService regSvc = assembler.getRegSvc();
		RegisterRequest req = new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);
		
		if(!req.isPasswordEqualToConfirmPassword()){
			System.out.println("암호와 확인이 일치하지않습니다.\n");
		}
		
		try{
			regSvc.regist(req);
			System.out.println("등록되었습니다.");
		}
		catch(AlreadyExistingMemberException err){
			System.out.println("이미 존재하는 이메일 입니다.");
		}
	}
	
	private static void processChangeCommand(String[] args){
		if(args.length != 4){
			printHelp();
			return;
		}
	}
	
	
}
