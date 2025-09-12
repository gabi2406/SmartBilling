package org.smartbilling;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

//@SpringBootTest
@DataJpaTest
@ActiveProfiles("test")
class SmartbillingApplicationTests {

	@Test
	void contextLoads() {
	}

}
