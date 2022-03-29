package fr.arolla;

import fr.arolla.responses.CorrectResponse;
import fr.arolla.responses.FunctionalError;
import fr.arolla.responses.Response;
import fr.arolla.responses.ServerError;

public class ResponseManager {
    public static String evaluate(Response response) {

        return switch (response) {
            case CorrectResponse correctResponse -> "OK";
            case FunctionalError fe && fe.responseCode() == 401 -> "Unauthorized";
            case FunctionalError fe && fe.responseCode() == 404 -> "Not found";
            case FunctionalError functionalError -> "Functional error";
            case ServerError serverError -> "Internal error";
        };
    }
}
