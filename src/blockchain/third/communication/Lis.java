package blockchain.third.communication;

public class Lis {

	public static void main(String[] args) {
		UniListener RecordListener = new UniListener(3000); // ��Ե��¼�ļ���
		Thread t1 = new Thread(RecordListener);
		UniListener BlockListener = new UniListener(3001); // ˽�п����
		Thread t2 = new Thread(BlockListener);

		BroadListener IPListener = new BroadListener(4000); // IP����
		Thread t3 = new Thread(IPListener);
		BroadListener RecordListener2 = new BroadListener(4001); // �㲥��¼����
		Thread t4 = new Thread(RecordListener2);
		BroadListener RealeaseListener = new BroadListener(4002); // �ͷ�˽�п����
		Thread t5 = new Thread(RealeaseListener);
		BroadListener StoreListener = new BroadListener(4003); // �洢����������
		Thread t6 = new Thread(StoreListener);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();

	}
}
