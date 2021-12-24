package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 
 * ������Ʈ ��ĵ, Ž�� ��ġ, �⺻ ��ĵ���
 * @author User
 *
 */

@Configuration
@ComponentScan(
		basePackages = "hello.core.member", // Ž���� ��Ű�� ��� ����
		basePackageClasses = AutoAppConfig.class,
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) 
)
public class AutoAppConfig {

}
