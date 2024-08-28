package ru.prostostudia.collectiontwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.prostostudia.collectiontwo.exceptions.EmployeeAlreadyAddedException;
import ru.prostostudia.collectiontwo.exceptions.EmployeeNotFoundException;
import ru.prostostudia.collectiontwo.exceptions.EmployeeStorageIsFullException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServiceInterface employeeService;


    public EmployeeController(EmployeeServiceInterface employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Object employeeList() {
        return employeeService.getEmployees();
    }

    @GetMapping(path = "/del")
    public Object employeeDelete(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName ) {
        try {
            return employeeService.deleteEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/add")
    public Object employeeAdd(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName ) {
        try {
            return employeeService.addEmployee(firstName, lastName);
        } catch (EmployeeAlreadyAddedException | EmployeeStorageIsFullException e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/find")
    public Object employeeFind(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName ) {
        try {
            return employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
    }


}

