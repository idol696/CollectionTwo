package ru.prostostudia.collectiontwo.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("EmployeeAlreadyAdded");
    }
}
