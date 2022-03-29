package fr.arolla;

import fr.arolla.responses.CorrectResponse;
import fr.arolla.responses.FunctionalError;
import fr.arolla.responses.Response;
import fr.arolla.responses.ServerError;

public class ResponseManager {
    // FIXME It must be possible to use an exhaustive switch here
    public static String evaluate2(Response response) {

        if (response instanceof CorrectResponse) {
            return "OK";
        }

        if (response instanceof FunctionalError) {
            var responseCode = ((FunctionalError) response).responseCode();
            if (responseCode == 401) {
                return "Unauthorized";
            }
            if (responseCode == 404) {
                return "Not found";
            }

            return "Functional error";
        }

        if (response instanceof ServerError) {
            return "Internal error";
        }

        return "Unknown error";
    }
    public static String evaluate(Response response){
        return switch (response){
            case CorrectResponse correctResponse-> "OK";
            case FunctionalError functionalError -> switch (functionalError.responseCode()) {
                case 401 -> "Unauthorized";
                case 404 -> "Not found";
                default -> "Functional error";
            };
            case ServerError serverError -> "Internal error";
        };
    }

}
