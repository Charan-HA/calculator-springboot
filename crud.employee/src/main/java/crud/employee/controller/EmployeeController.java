package crud.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import crud.employee.entities.Employee;
import crud.employee.services.EmployeeService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@GetMapping("/add")
	public String add() {
		return "addEmployee";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute Employee emp) {
		service.addEmployee(emp);
		return "index";
	}
	
	@GetMapping("/openUpdate")
	public String openUpdate() {
		return "updateEmployee";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Employee emp) {
		service.updateEmployee(emp);
		return "index";
	}
	
	@GetMapping("/openSearch")
	public String openSearch() {
		return "searchEmployee";
	}
	
	@PostMapping("/search")
	public String searchEmployee(@RequestParam int id, Model m) {
		Employee emp = service.searchEmployee(id);
		m.addAttribute("employee", emp);
		return "showEmployee";
	}
	
	@GetMapping("/openDelete")
	public String openDelete() {
		return "deleteEmployee";
	}
	
	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam int id) {
		service.deleteEmployee(id);
		return "index";
	}
	
	@GetMapping("/allEmployees")
	public String fetchAllEmployee(Model m) {
		List<Employee> empList = service.fetchAllEmployee();
		m.addAttribute("empList", empList);
		return "showAllEmployee";	
	}
	
}
