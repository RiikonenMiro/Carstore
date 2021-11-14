package hh.swd0.Carstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Type, Long> {
	
	List<Type> findByKuvaus(String kuvaus);

}
