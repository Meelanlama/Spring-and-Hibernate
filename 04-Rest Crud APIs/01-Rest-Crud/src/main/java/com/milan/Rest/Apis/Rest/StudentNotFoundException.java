package com.milan.Rest.Apis.Rest;

public class StudentNotFoundException extends RuntimeException {

    //generating constructor
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
