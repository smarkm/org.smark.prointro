package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class SocketClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket socket = new Socket();
				socket.connect(new InetSocketAddress("192.168.3.5", 8888));
			System.out.println(socket + " --"+socket.isClosed());
			while(true){
				System.out.println(socket + " --"+socket.isClosed());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
