package com.smvitm.cnlab;
import java.util.Scanner;
public class CRCDemo{
    static String msg;
    static String genpoly="10001000000100001";
    //static String genpoly="1101";
    static char t[]=new char[128];
    static char cs[]=new char[128];
    static char g[]=new char[128];
    static int mlen,glen,x,c,flag=0,test;
    public static void main(String[]args){
        Scanner in =new Scanner(System.in);
        System.out.println("Enter message to be transferred");
        msg=in.nextLine();
        mlen=msg.length();
        for(int i=0;i<mlen;i++)
            t[i]=msg.charAt(i);
        System.out.println("Predefined generator polynomial is:"+genpoly);
        g=genpoly.toCharArray();
        glen=genpoly.length();
        for(x=mlen;x<(mlen+glen-1);x++)
            t[x]='0';
        System.out.println("zero extended message is:"+new String(t));
        crc();
        System.out.println("check sum is:"+new String(cs));
        for(x=mlen;x<mlen+glen-1;x++)
            t[x]=cs[x-mlen];
        System.out.println("Final codeword generated is:"+new String(t));
       System.out.println("\n\n Test error detection 1 (yes)0 (no)");
       test=in.nextInt();
       if(test==1) {
           System.out.println("Enter position where error is to inserted:");
       x=in.nextInt();
       t[x]=(t[x]=='0')?'1':'0';
       System.out.println("errorneous data:"+new String(t));
    }
    crc();
    for(x=0;x<(glen-1);x++){
    if(cs[x]=='1'){
        flag=1;
        break;}}
    if(flag==1)
    System.out.println("error was detected during transfer");
    else
    System.out.println("no error was detected during transfer");
    in.close();
    }
   public static void crc() {
	   for(x=0;x<glen;x++)
		   cs[x]=t[x];
	   do {
		   if(cs[0]=='1')
			   xor();
		   for(c=0;c<glen-1;c++) {
			   cs[c]=cs[c+1];
		   }
		   cs[c]=t[x++];
	   }while(x<=mlen+glen-1);
   }
	   public static void xor() {
		   for(c=1;c<glen;c++)
			   cs[c]=((cs[c]==g[c])?'0':'1');
	   }
	   
    
}
