package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;

/**
 * 
 * ������ �� ��ȸ - ��� ����
 * @author User
 *
 */

public class ApplicationContextExtendsFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
	
	@Test
	@DisplayName("�θ� Ÿ������ ��ȸ��, �ڽ��� �� �̻� ������, �ߺ� ������ �߻��Ѵ�")
	void findBeanByParentTypeDuplicate() {
		assertThrows(NoUniqueBeanDefinitionException.class, 
				() -> ac.getBean(DiscountPolicy.class));
	}
	
	@Test
	@DisplayName("�θ� Ÿ������ ��ȸ��, �ڽ��� �� �̻� ������, �� �̸��� �����ϸ� �ȴ�")
	void findBeanByParentTypeBeanName() {
		DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
		assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
	}
	
	@Test
	@DisplayName("Ư�� ���� Ÿ������ ��ȸ")
	void findBeanBySubType() {
		RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
		assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
	}
	
	@Test
	@DisplayName("�θ� Ÿ������ ��� ��ȸ�ϱ�")
	void findAllBeanByParentType() {
		Map<String, DiscountPolicy> beanOfType = ac.getBeansOfType(DiscountPolicy.class);
		assertThat(beanOfType.size()).isEqualTo(2);
		for (String key : beanOfType.keySet()) {
			System.out.println("key = " + key + " value = " + beanOfType.get(key));
		}
	}
	
	@Test
	@DisplayName("�θ� Ÿ������ ��� ��ȸ�ϱ� - Object")
	void findAllBeanByObjectType() {
		Map<String, Object> beanOfType = ac.getBeansOfType(Object.class);
		for (String key : beanOfType.keySet()) {
			System.out.println("key = " + key + " value = " + beanOfType.get(key));
		}
	}
	
	@Configuration
	static class TestConfig {
		@Bean
		public DiscountPolicy rateDiscountPolicy() {
			return new RateDiscountPolicy();
		}
		
		@Bean
		public DiscountPolicy fixDiscountPolicy() {
			return new FixDiscountPolicy();
		}
	}
}
