package springbootex;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
 * Bootstrap Class
 * 
 * 1. wiring : boot-strapping for spring boot application 
 * 2. configuration class
 * 
 */

//@SpringBootConfiguration //alias for @Configuration
@SpringBootApplication //(scanBasePackages = {} )
public class HelloWorldApplication {
	
	@Bean
	public ApplicationRunner applicationRunner() {
		
		// 1. 작성된 구현 class 사용
		// return new HelloWorldRunner();
		
		// 2. Anonymous class 적용
//		return new ApplicationRunner() {
//			
//			public void run(ApplicationArguments args) throws Exception {
//				System.out.println("Hello World - anonymous class 실행");
//			}
//		};
		// 3. functional (lambda 표현식)
		return (ApplicationArguments args) -> {
			System.out.println("Hello World - lambda ");
		};
	}
	
	public static void main(String[] args) {
		/*
		 * 1. application context(container) 생성
		 * 2. application type 결정 (web application 인 경우 - servlet, reactive)
		 * 3. annotaion scanning 통한 bean 생성 및 등록
		 * 4. web application 인 경우
		 * 	  - embedded server (TomcatEmbeddedServletContainer) instance 생성
		 * 	  - server instance web application deployment(배포)
		 * 	  - server instance 실행
		 * 5. interface ApplicationRunner 구현 bean 의 run() 실행
		 * 
		 */
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
