package ru.prostostudia.collectiontwo.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("ArrayIsFull");
    }
}
