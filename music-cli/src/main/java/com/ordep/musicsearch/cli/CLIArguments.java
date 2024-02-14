package com.ordep.musicsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {

    public CLIArguments() {

    }

    @Parameter(
        required = true,
        descriptionKey = "Query",
        validateWith = CLIKeywordValidator.class,
        description = "query"
    )
    private String q;

    @Parameter(
        required = true,
        names = { "--type", "-t" },
        descriptionKey = "TYPE",
        validateWith = CLITypeValidator.class,
        description = "Valid types: album, artist, track"
    )
    private String type;

    @Parameter(
        names = { "--market", "-m" },
        validateWith = CLIMarketValidator.class,
        description = "Buscará según las siglas del mercado dado. E.g. mx, us, pe"
    )
    private String market;

    @Parameter(
        names = { "--limit", "-l" },
        validateWith = CLILimitsValidator.class,
        description = "Número que limita la cantidad de elementos a buscar"
    )
    private int limit = 50;

    @Parameter(
        names = { "--offset", "-o" },
        validateWith = CLILimitsValidator.class,
        description = "De los elementos recibidos, a partir de que índice mostrará los elementos encontrados"
    )
    private int offset = 0;

    @Parameter(
        names = { "--help", "-h" },
        help = true,
        validateWith = CLIHelpValidator.class,
        description = "Mostrar información acerca del comando, opciones y argumentos"
    )
    private boolean isHelp;

    public String getQ() {
        return q;
    }

	public String getType() {
		return type;
	}

	public String getMarket() {
		return market;
	}

	public int getLimit() {
		return limit;
	}

	public int getOffset() {
		return offset;
	}

	public boolean isHelp() {
		return isHelp;
	}

    @Override
    public String toString() {
        return String.format("CLIArguments{" +
                "q='%s'" +
                ", type='%s'" +
                ", market='%s'" +
                ", limit=%d" +
                ", offset=%d" +
                ", isHelp=%b" +
                "}", q, type, market, limit, offset, isHelp);
    }

    public static CLIArguments newInstance() {
        return new CLIArguments();
    }
}
