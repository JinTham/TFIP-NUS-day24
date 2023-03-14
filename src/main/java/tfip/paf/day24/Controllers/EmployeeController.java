package tfip.paf.day24.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tfip.paf.day24.Models.Employee;
import tfip.paf.day24.Services.EmployeeService;

@Controller
@RequestMapping(path="employees")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeSvc;

    //List all employees
    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = employeeSvc.findAll();
        model.addAttribute("employees", employees);
        return "employeeList";
    }

    //Create new employee
    @GetMapping(path="/addnew")
    public String createEmployee(Model model) {
        Employee newEmployee = new Employee();
        model.addAttribute("newEmployee", newEmployee);
        return "createEmployee";
    }
    @PostMapping(path="/save")
    public String addNewEmployee(@ModelAttribute("newEmployee") Employee newEmployee, BindingResult result) {
        if (result.hasErrors()) {
            return "createEmployee";
        }
        employeeSvc.save(newEmployee);
        return "redirect:/employees";
    }

    //Delete employee
    @GetMapping(path="/delete/{employee-id}")
    public String deleteEmployee(@PathVariable("employee-id") Integer id) {
        employeeSvc.delete(id);
        return "redirect:/employees";
    }

    //Edit employee
    @GetMapping(path="/edit/{employee-id}")
    public String updateEmployee(@PathVariable("employee-id") Integer id, Model model) {
        Employee retrievedEmployee = employeeSvc.findById(id);
        model.addAttribute("employee", retrievedEmployee);
        return "updateEmployee";
    }
    @PostMapping(path="/saveUpdate")
    public String updateEmployee(@ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "updateEmployee";
        }
        employeeSvc.update(employee);
        return "redirect:/employees";
    }
}
