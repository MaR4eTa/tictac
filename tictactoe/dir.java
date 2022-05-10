import java.io.*;
import java.util.*;

public class dir{
	static String path = null;

	static void list(File[] arr,int level){

		for(File f : arr){

			for(int i =0 ;i<level;i++){
				System.out.print("-");
			}

			if(f.isFile()){
				System.out.println(f.getName());
			}
			else if(f.isDirectory()){
				System.out.println("/"+f.getName());

				list(f.listFiles(),level+1);
			}
		}
	}

	static void unix(){
		System.out.println("Enter user name :");
		Scanner uname = new Scanner(System.in);
		String username = uname.next();
		uname.nextLine();
		System.out.println("Enter directory name you want to list :");
		String dirname = uname.nextLine();
		path = "/home/"+username+"/"+dirname;
	}

	static void windows(){
		System.out.println("Enter the drive name :");
		Scanner dname = new Scanner(System.in);
		String driname = dname.next();
		dname.nextLine();
		System.out.println("Enter directory name :");
		String dirname = dname.nextLine();
		path = driname+":"+"\\"+dirname;
	}



	public static void main(String[] args){

		System.out.println("1.unix");
		System.out.println("2.windows");
		System.out.println("Choose an operating system :");
		Scanner op = new Scanner(System.in);
		int opsys = op.nextInt();
		if(opsys == 1){
			unix();
		}
		else if(opsys == 2){
			windows();
		}
		else{
			System.out.println("Select os correctly!!");
			
		}
		File filepath = new File(path);
		if(filepath.exists() && filepath.isDirectory()){
		System.out.println("Full path :" + path);
		File[] filearr = filepath.listFiles();
		list(filearr,1);
		}
		else
		{
			System.out.println("Invalid Directory or Path");

		}



    }


}

