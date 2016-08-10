package blockchain.third.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class UniListener implements Runnable {
	private int port;

	public UniListener(int p) {
		this.port = p;
	}
	public void doIT(String info){
		System.out.println("�յ���Ϣ��" + info);
	}
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(port);// 2.ʹ��accept()������ֹ�ȴ����������������
			String IP=InetAddress.getLocalHost().toString();
			System.out.println(IP+"���������˿�" + port + "�򿪣�");
			while (true) {
				Socket socket = serverSocket.accept(); // 3.���������
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(
						new InputStreamReader(is)); // ��������
//				OutputStream os = socket.getOutputStream();
//				PrintWriter pw = new PrintWriter(os); // 4.��ȡ�û�������Ϣ
				String info = null;
				while (!((info = br.readLine()) == null)) {
					doIT(info);
				}
			}

			// pw.close();
			// os.close();
			// br.close();
			// is.close();
			// socket.close();
			// serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}