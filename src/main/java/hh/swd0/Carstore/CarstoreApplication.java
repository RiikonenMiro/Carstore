package hh.swd0.Carstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd0.Carstore.domain.Car;
import hh.swd0.Carstore.domain.CarRepository;
import hh.swd0.Carstore.domain.Type;
import hh.swd0.Carstore.domain.TypeRepository;
import hh.swd0.Carstore.domain.UserRepository;
import hh.swd0.Carstore.domain.User;


@SpringBootApplication
public class CarstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CarRepository crepo, TypeRepository trepo, UserRepository urepo) {
		return (args) -> {
			Type t1 = new Type("Viistoperä");
			Type t2 = new Type("Crossover");
			Type t3 = new Type("Farmari");
			
			trepo.save(t1);
			trepo.save(t2);
			trepo.save(t3);

			
			Car c1 = new Car("Fiat", "Stilo", 2005, 3000, t1);
			Car c2 = new Car("Renault", "Clio", 2000, 1500, t1);
			Car c3 = new Car("BMW", "X5", 2015, 20000, t2);
			
			crepo.save(c1);
			crepo.save(c2);
			crepo.save(c3);
			
			User admin = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@admin.com", "ADMIN");
			urepo.save(admin);
			
		};
	}

}
