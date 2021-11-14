package hh.swd0.Carstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd0.Carstore.domain.Type;
import hh.swd0.Carstore.domain.TypeRepository;

@Controller
public class TypeController {
	@Autowired
	private TypeRepository trepo;
	
	
	@RequestMapping(value = "/typelist", method = RequestMethod.GET)
	public String typeList(Model model) {
		model.addAttribute("tyypit", trepo.findAll());
		
		return "typelist"; // typelist.html
	}
	
	@RequestMapping(value = "/addtype")
	public String addType(Model model) {
		model.addAttribute("type", new Type());
		return "addtype"; // addtype.html
	}
	
	@RequestMapping(value = "/savetype", method = RequestMethod.POST)
	public String save(Type type) {
		trepo.save(type);
		return "redirect:/typelist"; // typelist.html
	}

}
