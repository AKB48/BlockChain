package blockchain.third.communication;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class UniCast {
	
	private String IP;
	private int port;
	
	UniCast(String ip,int p){
		this.IP=ip;
		this.port=p;
	}
	
	
    public void Send(String message) {
        try {
            //1.�����ͻ���socket���ӣ�ָ��������λ�ü��˿�
            Socket socket =new Socket(IP,port);
            //2.�õ�socket��д��
            OutputStream os=socket.getOutputStream();
            PrintWriter pw=new PrintWriter(os);
            //������
            InputStream is=socket.getInputStream();
            pw.write(message);
            System.out.println("send "+message);
            pw.flush();
            socket.shutdownOutput();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}