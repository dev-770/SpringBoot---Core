package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 
 * 컴포넌트 스캔, 탐색 위치, 기본 스캔대상
 * @author User
 *
 */

@Configuration
@ComponentScan(
		basePackages = "hello.core.member", // 탐색할 패키지 경로 선택
		basePackageClasses = AutoAppConfig.class,
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) 
)
public class AutoAppConfig {

}
