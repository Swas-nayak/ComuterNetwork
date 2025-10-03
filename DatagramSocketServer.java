package datagram;
import java.util.*;
import java.net.*;
public class DatagramSocketServer {

	public static void main(String[] args)throws Exception {
		Scanner in = new Scanner(System.in);
		DatagramSocket serverSocket= new DatagramSocket(9000);
		byte[] recieveData = new byte[1024];
		byte[] sendData = new byte[1024];
		System.out.println("***Server side***");
		DatagramPacket receivePacket = new DatagramPacket(recieveData, recieveData.length);
		serverSocket.receive(receivePacket);
		System.out.println(new String(receivePacket.getData()));
		InetAddress IPAddress =receivePacket.getAddress();
		int port= receivePacket.getPort();
		while (true) {
			System.out.println("Type some messages to display at client end");
			String message= in.nextLine();
			System.out.println("message sent fro, server:"+new String(sendData));
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
			serverSocket.send(sendPacket);
		}
	}

}
