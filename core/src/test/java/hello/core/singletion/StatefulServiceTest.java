package hello.core.singletion;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 
 * 싱글톤 방식의 주의점
 * @author User
 *
 */

class StatefulServiceTest {

	@Test
	void statefulServiceSingleton() {
		ApplicationContext ac =  new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);
		
		//ThreadA: A사용자 10000원 주문
		int usrAprice = statefulService1.order("userA", 10000);
		//ThreadB: B사용자 20000원 주문
		int usrBprice = statefulService1.order("userB", 20000);
		
		//ThreadA: A사용자 주문 금액 조회
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
