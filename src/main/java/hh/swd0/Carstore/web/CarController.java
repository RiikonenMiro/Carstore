package hh.swd0.Carstore.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "/carlist", method = RequestMethod.POST)
	public String carSubmit(@Valid Car car, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "carstore";
		} else {
			model.addAttribute("cars", car);
			return "result";
		}
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
		return "redirect:/carlist";
	}
	
	@PreAuthorize(value = "hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCar(@PathVariable("id") Long carId, Model model) {
    	crepo.deleteById(carId);
        return "redirect:../carlist";
	}
	
	@PreAuthorize(value = "hasAuthority('ADMIN')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCar(@PathVariable("id") Long carId, Model model) {
		model.addAttribute("car", crepo.findById(carId));
		model.addAttribute("tyypit", trepo.findAll());
		return "editcar"; // editcar.html
	}
	
	//
	// REST SERVICES
	//
	
	@RequestMapping(value="/cars", method = RequestMethod.GET)
    public @ResponseBody List<Car> carListRest() {	
        return (List<Car>) crepo.findAll();
    }   
	
    @RequestMapping(value="/cars/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Car> findCarRest(@PathVariable("id") Long carId) {	
    	return crepo.findById(carId);
    }      
    
    @RequestMapping(value="/cars", method = RequestMethod.POST)
    public @ResponseBody Car saveCarRest(@RequestBody Car car) {	
    	return crepo.save(car);
    }

}
