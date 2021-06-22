# spring boot example

* jar project

* pom.xml
	* use [spring initializr](https://start.spring.io/)
	* parent 지정
		* version info
	* properties : maven compiler 사용
	* dependency
		* spring boot starter
		* spring boot starter tester
		
		
## HelloWorld

### 1. HelloWorldApplication

* Bootstrap Class ( 설정 파일 )
	* wiring :  spring boot application boot-strapping
	* configuration class
		* @SpringBootConfigurtation
			* meta tag (annotation)
				* 다른 annotation 포함
			* spring boot 전용 configuration
				* alias for @Configuration
				* @Configuration은 singleton 보장
					* 내용이 같은 bean이 두 개 생성되지 않게 해줌
				* @Configuration 사용 X
					* Spring Test ( JUnit )시에 class 경로 주지 않을 경우 @Configuration이 아닌 @SpringBootConfiguration이 붙은 클래스 위주로 탐색하게 됨. 따라서 spring boot에서는 @SpringBootConfiguration이나 그것을 포함한 것을 사용한다.
		* @SpringBootApplication
			* meta annotaion 
				* @SprignBootApplication + @ComponentScan + @AutoConfiguration
			* 여러 annotation 사용하기 보다 이거 하나 사용 

* SpringApplication.run
	1. application context(container) 생성
	2. application type 결정 (web application 인 경우 - servlet, reactive)
	3. annotaion scanning 통한 bean 생성 및 등록
	4. web application 인 경우
		- embedded server (TomcatEmbeddedServletContainer) instance 생성
		- server instance web application deployment(배포)
		- server instance 실행
	5. interface ApplicationRunner 구현 bean 의 run() 실행
		- 작성된 구현 class 사용 ( HelloWorldRunner)
		```java
		@Bean
		public ApplicationRunner applicationRunner() {
			// 1. 작성된 구현 class 사용
			return new HelloWorldRunner();
		}
		```
		- anonymous class 적용
		```java
		@Bean
		public ApplicationRunner applicationRunner() {
		// 2. Anonymous class 적용
		return new ApplicationRunner() {

			public void run(ApplicationArguments args) throws Exception {
				System.out.println("Hello World - anonymous class 실행");
				}
			};
		}
		```
		- 함수형 (람다 표현식)
		```java
		@Bean
		public ApplicationRunner applicationRunner() {
			
			// 3. functional (lambda 표현식)
			return (ApplicationArguments args) -> {
				System.out.println("Hello World");
			};
		}
		```

### 2. HelloWorldRunner

* ApplicationRunner 구현 class
	
		