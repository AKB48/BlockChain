package blockchain.third.communication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class BroadCast{
	private int port;
	private DatagramSocket ds;
	public BroadCast(int p){
		this.port=p;//���ù㲥�˿�
	}
		
	public void Send(String message){ 
		// �㲥��ʵ�� :�ɿͻ��˷����㲥���������˽���
		String host = "255.255.255.255";//�㲥��ַ
		try {
			InetAddress adds = InetAddress.getByName(host);
			ds = new DatagramSocket();
			DatagramPacket dp = new DatagramPacket(message.getBytes(),
					message.length(), adds, port);
			ds.send(dp);
			System.out.println("send "+message);
			ds.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
