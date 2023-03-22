

import java.io.File;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPFile;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FTPClient client = new FTPClient();

		while(true) {


			int input=0;
			//[1] : ���� ����
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
						System.out.println("���񽺿� ������ �� �����ϴ�.");
						e.printStackTrace();
					}
				}
			}else if(input== 2) {
				System.out.println("������");
				System.exit(0);
			}


			//[2] : ���� �α���
			while(true) {
				System.out.print("���̵� : ");
				String id =sc.nextLine();
				System.out.print("��й�ȣ : ");
				String ps = sc.nextLine();

				try {
					client.login(id, ps);
					break;
				}catch(Exception e) {
					System.out.println("�α��ο� �����߽��ϴ�.");
					e.printStackTrace();
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
						System.out.println("���ε��� ������ �����ּ���");
						String msg2 = sc.nextLine();

						try {
							client.upload(new File(msg2));
							break;
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}else if(menu == 2) {
					//[3] : ���� ��� ���
					System.out.println("=====File list ======");
					try {
						FTPFile[]files = client.list();
						
						for(int i = 0; i < files.length; i ++) {
							System.out.println(files[i].getName() + "\t"+files[0].getSize());
						}

//						String[] names = client.listNames();
//						for(int i = 0; i<names.length; i++) {
//							System.out.println(i+". "+names[i]);
//						}
						System.out.print(">>>");

					}catch(Exception e) {
						e.printStackTrace();
					}

					//[4] : ���� �ٿ�ε�
					//[!] : ������� \(��������) �ϳ��� �ϰų� �ΰ�¥���Ѵ� �ȴ� �ߴµ� ���� �ΰ�¥���� ������
					while(true) {

						System.out.print("����� �����ּ��� : ");
						String msg = sc.nextLine();
						System.out.print("�ٿ� ���� ��θ� �����ּ��� : ");
						String msg1 = sc.nextLine();
						try{
							client.download(msg, new File(msg1));
							break;

						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}else if(menu == 3) {
					System.out.println("�޴� ȭ������ ���ư��ϴ�.");
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