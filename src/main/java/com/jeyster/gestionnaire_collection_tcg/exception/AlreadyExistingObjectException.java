package com.jeyster.gestionnaire_collection_tcg.exception;

public class AlreadyExistingObjectException extends RuntimeException {

    private static final String MESSAGE_NAME = """
            The object you are trying to create with the name "%s" already exists in database.
            Please find another name.""";

    private static final String MESSAGE_URL = """
            The url you filled is already used by another item in database.
            Please check this.""";

    public AlreadyExistingObjectException(String objectNameOrUrl, boolean isSearchedByName) {
        super(String.format(isSearchedByName ? MESSAGE_NAME : MESSAGE_URL, objectNameOrUrl));
    }

}
