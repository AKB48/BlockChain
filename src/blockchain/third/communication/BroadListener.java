package blockchain.third.communication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class BroadListener implements Runnable {
	public int port; // 端口号
	private DatagramSocket ds;
	private DatagramPacket dp;

	public BroadListener(int p) {
		this.port = p;// 设置端口号
	}

	public void closeListener() {
		if (ds != null) {
			ds.close();
		}
	}

	public void doIT(String info) {
		//用来重写的方法
		System.out.println("DoSomething" + info);
	}

	public void run() {
		
		byte[] buf = new byte[1024];// 暂存
		StringBuffer sbuf = new StringBuffer();
		try {
			InetAddress addr = InetAddress.getLocalHost();
			String localip=addr.getHostAddress().toString();//获得本机IP
			ds = new DatagramSocket(port);
			dp = new DatagramPacket(buf, buf.length);
			System.out.println("My port:" + port + " opened");
			while (!ds.isClosed()) {
				ds.receive(dp);
				InetAddress getIP=dp.getAddress();
				if(!localip.equals(getIP.toString().substring(1))){
					for (int i = 0; i < 1024; i++) {
						if (buf[i] == 0) {
							break;
						}
						sbuf.append((char) buf[i]);
					}
					doIT(sbuf.toString());   //进行操作
				}
				buf = new byte[1024];
				dp = new DatagramPacket(buf, buf.length);
				sbuf = new StringBuffer();
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ds.close();
		}
	}
}
