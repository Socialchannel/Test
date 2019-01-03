/**
 *
 * @author gurpreet.s
 */

package com.javainuse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.javainuse.model.Employee;
import com.javainuse.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

    //the welcome page
	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		return new ModelAndView("welcome");
	}
	
    //show the add employee form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addEmployee", "emp", new Employee());
	}

    //Get the form field vaues which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("emp") Employee emp) {
		employeeService.insertEmployee(emp);
		List<Employee> employees = employeeService.getAllEmployees();
		for(Employee emp1:employees) {
			System.out.println("EMPDI" +emp1.getEmpId());
		}
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}
	
	//show all employees saved in db
		@RequestMapping("/getEmployees")
		public ModelAndView getEmployees() {
			List<Employee> employees = employeeService.getAllEmployees();
			ModelAndView model = new ModelAndView("getEmployees");
			model.addObject("employees", employees);
			return model;
		}
		
		@RequestMapping(value = "/login", method = RequestMethod.GET)
	    public ModelAndView login(Model model, String error, String logout) {
	        if (error != null)
	            model.addAttribute("errorMsg", "Your username and password are invalid.");

	        if (logout != null)
	            model.addAttribute("msg", "You have been logged out successfully.");

	        return new ModelAndView("login");
	    }
}
