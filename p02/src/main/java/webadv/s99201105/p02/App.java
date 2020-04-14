package webadv.s99201105.p02;

/**
 * Hello world!
 *
 */
import java.io.*;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
public class App {
    public static void main(String[] args) throws IOException{
    	
    	
    	String username="";
		String password="";
		Scanner input = new Scanner(System.in);
		System.out.println("请输入账号");
		username=input.nextLine();
		System.out.println("请输入密码");
		password=input.nextLine();
        FileWriter fw = new FileWriter("password.txt");
        BufferedWriter osw = new BufferedWriter(fw);
		osw.write("17205120\n");
		osw.write(sha256hex("123456"));
		osw.close();
		fw.close();
             
		FileReader fr = new FileReader("password.txt");
		BufferedReader bf =new BufferedReader(fr);
		String txtName=bf.readLine();
		System.out.println(txtName);
		String txtPassword=bf.readLine();
		System.out.println(txtPassword);
		bf.close();
		fr.close();
		
		if(username.equals(txtName)&&sha256hex(password).equals(txtPassword)){
			System.out.println("登陆成功");
			
		}else{
			System.out.println("登陆失败");
			
		}
		
        if (args.length < 1) {
            System.err.println("Please provide an input!");
            System.exit(0);
        }
        System.out.println(sha256hex(args[0]));
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }

}
