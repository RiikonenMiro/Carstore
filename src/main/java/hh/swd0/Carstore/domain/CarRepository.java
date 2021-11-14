package hh.swd0.Carstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface CarRepository extends CrudRepository<Car, Long>{

	List<Car> findByMerkki(String merkki);
	
}
