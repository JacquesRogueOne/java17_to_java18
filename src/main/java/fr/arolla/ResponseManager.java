package fr.arolla;

import fr.arolla.responses.CorrectResponse;
import fr.arolla.responses.FunctionalError;
import fr.arolla.responses.Response;
import fr.arolla.responses.ServerError;

public class ResponseManager {
    // FIXME It must be possible to use an exhaustive switch here
    public static String evaluate(Response response) {

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
}
