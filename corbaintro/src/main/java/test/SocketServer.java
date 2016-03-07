package test;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("server started");
			Socket socket = serverSocket.accept();
			System.out.println(socket.getPort());
			Thread.sleep(Integer.MAX_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
