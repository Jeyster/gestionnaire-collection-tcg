package com.jeyster.gestionnaire_collection_tcg.exception;

public class AlreadyExistingObjectException extends RuntimeException {

    private static final String MESSAGE = """
            The object you are trying to create with the name "%s" already exists in database.
            Please find another name.""";

    public AlreadyExistingObjectException(String objectName) {
        super(String.format(MESSAGE, objectName));
    }

}
