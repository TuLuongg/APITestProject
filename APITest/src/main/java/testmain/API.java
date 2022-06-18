package testmain;

import java.util.Scanner;

import autotest.LoginTest;
import autotest.SignUpTest;

public class API {
	public void menuAPI() {
		Scanner sc= new Scanner(System.in) ;
		int luachon;
			System.out.println("----------Mời chọn API :----------");
			System.out.println("1: Login ");
			System.out.println("2: Sign Up ");
			System.out.println("3: ");
			System.out.println("4: ");
			System.out.println("5: ");
			System.out.println("6: ");
			System.out.println("7: ");
			System.out.println("8: ");
			System.out.println("9: ");
			System.out.println("0: Thoát.");
			luachon= sc.nextInt();
			sc.nextLine();
			if(luachon==1) {
				System.out.println("Login");
				LoginTest.Login1();
				LoginTest.Login2();
				LoginTest.Login3();
				
			}
			else if(luachon==2) {	
				System.out.println("Sign Up");
				SignUpTest.SignUp1();
			}
			else if(luachon==3) {
				System.out.println("3");
			}
			else if(luachon==4) {
				System.out.println("4");
			}
			else if(luachon==5) {
				System.out.println("5");
				
			}
			else if(luachon==6) {
				System.out.println("6");
				
				 
			}
			else if(luachon==7) {
				System.out.println("7");
				
			}
			else if(luachon==8) {
				System.out.println("8");
				
				
			}
			else if(luachon==9) {
			
			}
			else  {
				System.out.println("Lựa chọn lỗi");
				
			}

	}
}
