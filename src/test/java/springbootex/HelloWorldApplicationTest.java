package springbootex;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes= {HelloWorldApplication.class})
@SpringBootTest(classes= {HelloWorldApplication.class}) 
public class HelloWorldApplicationTest {

	@Test
	public void contextLoads() {
		//불러오는 것 자체가 에러가 나게 되면 여거 자체가 에러가 남
	}
}
