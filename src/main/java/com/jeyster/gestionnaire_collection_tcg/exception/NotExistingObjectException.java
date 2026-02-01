package com.jeyster.gestionnaire_collection_tcg.exception;

public class NotExistingObjectException extends RuntimeException {

    private static final String MESSAGE = """
            There is no object of type "%s" with ID "%s" in database.""";

    public NotExistingObjectException(String className, Long objectId) {
        super(String.format(MESSAGE, className, objectId));
    }

}
