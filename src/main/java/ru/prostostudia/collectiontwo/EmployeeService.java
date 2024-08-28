package ru.prostostudia.collectiontwo;
import org.springframework.stereotype.Service;
import ru.prostostudia.collectiontwo.exceptions.EmployeeAlreadyAddedException;
import ru.prostostudia.collectiontwo.exceptions.EmployeeNotFoundException;
import ru.prostostudia.collectiontwo.exceptions.EmployeeStorageIsFullException;

import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final Map<String, EmployeeCustom> employeesBook = new HashMap<>(Map.of());
    private int maxEmployees = Integer.MAX_VALUE;

    public EmployeeService() {
        demoFill();
    }

    public void demoFill() {
        employeesBook.clear();
        addEmployee("Илья", "Бабушкин");
        addEmployee("Игорь", "Мусинькин");
        addEmployee("Виталий", "Хазбулатов");
        addEmployee("Иван", "Познер");
        addEmployee("Исаакий", "Волондемортов");
        addEmployee("Ирина", "Дудина");
        addEmployee("Иннокентий", "Смактуновский");
        addEmployee("Наталья", "Бузинова");
        addEmployee("Навелий", "Навеяло");
        addEmployee("Прасковья", "Прошкина");
        setMaxEmployees(10);
    }

    public Map<String, EmployeeCustom> getEmployees() {
        return employeesBook;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public void setMaxEmployees(int maxEmployees) {
        if (employeesBook.size() > maxEmployees) throw new EmployeeStorageIsFullException();
        this.maxEmployees = maxEmployees;
    }

    @Override
    public EmployeeCustom addEmployee(String firstName, String lastName) {
        if (employeesBook.size() >= maxEmployees) throw new EmployeeStorageIsFullException();
        try {
            findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            EmployeeCustom employee = new EmployeeCustom(firstName, lastName);
            employeesBook.put(employee.id(),employee);
            return employee;
        }
        throw new EmployeeAlreadyAddedException();
    }

    @Override
    public EmployeeCustom deleteEmployee(String firstName, String lastName) {
        EmployeeCustom employee = findEmployee(firstName,lastName);
        employeesBook.remove(employee.id());
        return employee;
    }

    @Override
    public EmployeeCustom findEmployee(String firstName, String lastName) {
        String id = new EmployeeCustom(firstName, lastName).id();
        if(employeesBook.containsKey(id) )
        {
            return employeesBook.get(id);
        }
        throw new EmployeeNotFoundException();
    }
}

