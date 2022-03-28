package fr.arolla;

import fr.arolla.responses.CorrectResponse;
import fr.arolla.responses.FunctionalError;
import fr.arolla.responses.ServerError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseManagerTest {

    @Test
    void should_return_OK_for_code_200() {
        String result = ResponseManager.evaluate(new CorrectResponse());

        assertThat(result).isEqualTo("OK");
    }

    @Test
    void should_return_Unauthorized_for_code_401() {
        var result = ResponseManager.evaluate(new FunctionalError(401));

        assertThat(result).isEqualTo("Unauthorized");
    }

    @Test
    void should_return_Not_found_for_code_404() {
        var result = ResponseManager.evaluate(new FunctionalError(404));

        assertThat(result).isEqualTo("Not found");
    }

    @Test
    void should_return_Functional_error_for_code_4xx() {
        var result = ResponseManager.evaluate(new FunctionalError(406));

        assertThat(result).isEqualTo("Functional error");
    }

    @Test
    void should_return_Internal_error_for_code_500() {
        var result = ResponseManager.evaluate(new ServerError());

        assertThat(result).isEqualTo("Internal error");
    }
}
