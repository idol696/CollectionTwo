package ru.prostostudia.collectiontwo;

import ru.prostostudia.collectiontwo.parent.Employee;

import java.util.Map;

public interface EmployeeServiceInterface {
    Employee addEmployee(String firstName, String lastName);
    Employee deleteEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Map<String, EmployeeCustom> getEmployees();
}
