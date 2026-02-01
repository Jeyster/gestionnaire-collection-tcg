package com.jeyster.gestionnaire_collection_tcg.exception;

public class NotExistingObjectException extends RuntimeException {

    private static final String MESSAGE = """
            There is no object of type "%s" with ID "%s" in database.""";

    private static final String MESSAGE_GENERIC = """
            At least one object related to the item you are trying to create is not in database.""";

    public NotExistingObjectException() {
        super(MESSAGE_GENERIC);
    }

    public NotExistingObjectException(String className, Long objectId) {
        super(String.format(MESSAGE, className, objectId));
    }

}
