package fr.arolla.responses;

public sealed interface Response permits CorrectResponse, FunctionalError,
        ServerError {

}
