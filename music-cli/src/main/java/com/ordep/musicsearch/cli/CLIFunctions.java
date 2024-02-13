package com.ordep.musicsearch.cli;

import java.util.HashMap;
import java.util.Map;

public class CLIFunctions {
    public static Map<String, Object> toMap(CLIArguments cliArguments) {
        Map<String, Object> params = new HashMap<>();

        params.put("q", cliArguments.getQ());
        params.put("type", cliArguments.getType());
        params.put("market", cliArguments.getMarket());
        params.put("limit", cliArguments.getLimit());
        params.put("offset", cliArguments.getOffset());

        return params;
    }
}
