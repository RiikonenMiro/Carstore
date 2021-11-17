package hh.swd0.Carstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd0.Carstore.domain.Type;
import hh.swd0.Carstore.domain.TypeRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TypeRepositoryTest {

	@Autowired
	private TypeRepository trepo;
	
	@Test
	public void createNewType() {
		Type type = new Type("Sedan");
		trepo.save(type);
		assertThat(type.getTyyppiid()).isNotNull();
	}
	
	@Test
	public void deleteNewType() {
		Type type = new Type("Sedan");
		trepo.save(type);
		trepo.deleteById(type.getTyyppiid());
		assertThat(trepo.findById(type.getTyyppiid())).isEmpty();
	}
}
