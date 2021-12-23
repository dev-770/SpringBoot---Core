package hello.core.singletion;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 
 * �̱��� ����� ������
 * @author User
 *
 */

class StatefulServiceTest {

	@Test
	void statefulServiceSingleton() {
		ApplicationContext ac =  new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);
		
		//ThreadA: A����� 10000�� �ֹ�
		int usrAprice = statefulService1.order("userA", 10000);
		//ThreadB: B����� 20000�� �ֹ�
		int usrBprice = statefulService1.order("userB", 20000);
		
		//ThreadA: A����� �ֹ� �ݾ� ��ȸ
//		int price = statefulService1.getPrice();
		System.out.println("price = " + usrAprice);
		
//		assertThat(statefulService1.getPrice()).isEqualTo(20000);
	}
	
	static class TestConfig {
		
		@Bean
		public StatefulService statefulSevice() {
			return new StatefulService();
		}
		
	}
}
