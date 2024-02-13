package com.ordep.musicsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLITypeValidator implements IParameterValidator {

	@Override
	public void validate(String name, String value) throws ParameterException {
        if (!value.matches("^(album|artist|track)$")) {
            System.err.println("El criterio de busqueda no es valido");
            throw new ParameterException("Unicamente letras");
        }
	}
    
}
