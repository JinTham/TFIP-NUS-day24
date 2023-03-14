package tfip.paf.day24.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfip.paf.day24.Models.Employee;
import tfip.paf.day24.Repositories.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepo;

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee findById(Integer id) {
        return employeeRepo.findById(id);
    }

    public Boolean save(Employee employee) {
        return employeeRepo.save(employee);
    }

    public int update(Employee employee) {
        return employeeRepo.update(employee);
    }

    public int delete(Integer id) {
        return employeeRepo.delete(id);
    }

}
