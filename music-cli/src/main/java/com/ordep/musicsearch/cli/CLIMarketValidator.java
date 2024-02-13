package com.ordep.musicsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLIMarketValidator implements IParameterValidator {

	@Override
	public void validate(String name, String value) throws ParameterException {
        if (!value.matches("^([a-z]{2}|[A-Z]{2})$")) {
            System.err.println("El criterio de busqeuda no es valido");
            throw new ParameterException("Unicamente dos letras, ambas deben" +
                    " estar en mayusculas o minusculas");
        }
	}
    
}
