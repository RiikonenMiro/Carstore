package hh.swd0.Carstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd0.Carstore.domain.Car;
import hh.swd0.Carstore.domain.CarRepository;
import hh.swd0.Carstore.domain.TypeRepository;

@Controller
public class CarController {
	@Autowired
	private CarRepository crepo;
	@Autowired
	private TypeRepository trepo;
	
	@RequestMapping(value = "/carlist", method = RequestMethod.GET)
	public String carList(Model model) {
		model.addAttribute("cars", crepo.findAll());
		
		return "carstore"; // carstore.html
	}
	
	@RequestMapping(value = "/add")
	public String addCar(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("tyypit", trepo.findAll());
		return "addcar"; // addcar.html
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Car car) {
		crepo.save(car);
		return "redirect:carlist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCar(@PathVariable("id") Long carId, Model model) {
    	crepo.deleteById(carId);
        return "redirect:../carlist";
	}

}
