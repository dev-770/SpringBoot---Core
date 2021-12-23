package hello.core.singletion;

/**
 * 
 * �̱��� ����
 * @author User
 *
 */

public class SingletonService {

	private static final SingletonService instance = new SingletonService();
	
	public static SingletonService getInstance() {
		return instance;
	}
	
	private SingletonService() {
	}
	
	public void login() {
		System.out.println("�̱��� ��ü ���� ȣ��");
	}
}
