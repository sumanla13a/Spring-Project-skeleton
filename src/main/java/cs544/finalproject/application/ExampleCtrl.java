package cs544.finalproject.application;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ExampleCtrl {
	@Autowired
	private IExampleService exampleService;
	private static final Logger logger = LoggerFactory.getLogger(ExampleCtrl.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getAllExamples(Model model) {
		Collection<ExampleDomain> e = exampleService.getExamples();
//		e.forEach(System.out::println);
		return "home2";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addExample(@RequestBody ExampleDomain e) {
		exampleService.saveExample(e);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/{exampleNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateCustomer(@RequestBody ExampleDomain e) {
		exampleService.updateExample(e);
	}
	
	/*@RequestMapping(value = "/customer/{customerNumber}", method =	 RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public RedirectView deleteCustomer(@PathVariable("exampleNumber") String exampleNumber) {
		exampleService.deleteExample(exampleNumber);
		return new RedirectView("/customer", true);
	}*/
	
	
}
