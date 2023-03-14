package tfip.paf.day24.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class EmployeeRepository {
    
    @Autowired
    RestTemplate restTemplate;

    private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://localhost:8080/api/employees";
    private static final String GET_EMPLOYEEBYID_ENDPOINT_URL = "http://localhost:8080/api/employees";
    private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/employees";
    private static final String UPDATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/employees";
    private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/employees";

    

}
