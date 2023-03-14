package tfip.paf.day24.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tfip.paf.day24.Models.Employee;
import tfip.paf.day24.Services.EmployeeService;

@Controller
@RequestMapping(path="employees")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeSvc;

    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = employeeSvc.findAll();
        model.addAttribute("employees", employees);
        return "employeeList";
    } 
}
