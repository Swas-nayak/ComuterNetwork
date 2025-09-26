package com.smvitm.cnlab.tcp.ip;
import java.io.*;
import java.net.*;
import java.util.*;
public class SocketClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Socket clientSocket = new Socket("127.0.0.1",4000);
		System.out.println("**** Client Side ****");
		System.out.println("Enter the filename to transfer");
		String fname = in.nextLine();
		OutputStream ostream =clientSocket.getOutputStream();
		PrintWriter pwrite= new PrintWriter(ostream,true);
		pwrite.println(fname);
		InputStream istream = clientSocket.getInputStream();
		BufferedReader socketRead= new BufferedReader( new InputStreamReader(istream));
		System.out.println("Contents of the file"+ fname+"are");
		String str;
		while((str= socketRead.readLine())!= null) {
			System.out.println(str);
		}
		pwrite.close();
		socketRead.close();
	}

}
