package hh.swd0.Carstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd0.Carstore.domain.Car;
import hh.swd0.Carstore.domain.CarRepository;
import hh.swd0.Carstore.domain.Type;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CarRepositoryTest {

	@Autowired
	private CarRepository crepo;
	
	@Test
	public void createNewCar() {
		Car car = new Car("Toyota", "Auris", 2005, 3000, new Type("Sedan"));
		crepo.save(car);
		assertThat(car.getId()).isNotNull();
	}
	
	@Test
	public void deleteNewCar() {
		Car car = new Car("Toyota", "Auris", 2005, 300, new Type("Sedan"));
		crepo.save(car);
		crepo.deleteById(car.getId());
		assertThat(crepo.findById(car.getId())).isEmpty();
	}
}
