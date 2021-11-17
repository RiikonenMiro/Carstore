package hh.swd0.Carstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd0.Carstore.web.CarController;
import hh.swd0.Carstore.web.TypeController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CarstoreApplicationTests {

	@Autowired
	private CarController carController;
	@Autowired
	private TypeController typeController;
	
	@Test
	public void contextLoads() {
		assertThat(carController).isNotNull();
		assertThat(typeController).isNotNull();
	}

}
