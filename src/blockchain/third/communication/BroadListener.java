package blockchain.third.communication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class BroadListener implements Runnable {
	private int port; // �˿�
	private DatagramSocket ds;
	private DatagramPacket dp;
	public BroadListener(int p) {
		this.port = p;// ���ù㲥�˿�
	}

	public void closeListener() {
		if (ds != null) {
			ds.close();
		}
	}
	
	public void run() {
		byte[] buf = new byte[1024];// �洢��������Ϣ
		StringBuffer sbuf = new StringBuffer();
		try {
			ds = new DatagramSocket(port);
			dp = new DatagramPacket(buf, buf.length);
			System.out.println("�����㲥�˿�" + port + "�򿪣�");
			while (!ds.isClosed()) {
				ds.receive(dp);
				for (int i = 0; i < 1024; i++) {
					if (buf[i] == 0) {
						break;
					}
					sbuf.append((char) buf[i]);
				}
				System.out.println("�յ��㲥��Ϣ��" + sbuf.toString());
				buf = new byte[1024];
				dp = new DatagramPacket(buf, buf.length);
				sbuf = new StringBuffer();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			ds.close();
		}
	}
}
