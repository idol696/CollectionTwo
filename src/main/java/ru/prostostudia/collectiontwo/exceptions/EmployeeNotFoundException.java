package ru.prostostudia.collectiontwo.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("EmployeeNotFound");
    }
}
