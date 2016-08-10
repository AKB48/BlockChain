package blockchain.third.communication;

public class Cast {

	public static void main(String[] args) {
		UniCast RecordCast = new UniCast("127.0.0.1", 3000);
		RecordCast.Send("�㲥��¼");
		UniCast BlockCast = new UniCast("127.0.0.1", 3001);
		BlockCast.Send("һ��˽�п�");

		BroadCast IPCast = new BroadCast(4000);
		IPCast.Send("127.0.0.1");
		BroadCast RecordCast2 = new BroadCast(4001);
		RecordCast2.Send("��Ե��¼");
		BroadCast RealeaseCast = new BroadCast(4002);
		RealeaseCast.Send("����Ҫ�ͷ�˽�п�");
		BroadCast StoreCast = new BroadCast(4003);
		StoreCast.Send("�ҵĹ�����");

	}

}
