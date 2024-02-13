package com.ordep.musicsearch;

import com.beust.jcommander.JCommander;
import com.ordep.musicsearch.util.api.APIFunctions;
import com.ordep.musicsearch.util.api.APIObject;
import com.ordep.musicsearch.api.ApiMusic;
import com.ordep.musicsearch.util.auth.AuthTokenTarget;
import com.ordep.musicsearch.util.auth.TokenProvider;
import com.ordep.musicsearch.cli.CLIArguments;
import com.ordep.musicsearch.cli.CLIFunctions;

import static com.ordep.musicsearch.CommanderFunctions.buildCommanderWithName;
import static com.ordep.musicsearch.CommanderFunctions.parseArguments;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class MusicSearch {
    public static void main(String[] args) {
        JCommander jCommander = buildCommanderWithName("music-search",
                CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCLI =
            parseArguments(jCommander, args, JCommander::usage)
            .orElse(Collections.emptyList())
            .stream()
            .map(obj -> (CLIArguments) obj);

        Optional<CLIArguments> cliArgumentsOptional =
            streamOfCLI.filter(cli -> !cli.isHelp())
            .filter(cli -> cli.getQ() != null)
            .filter(cli -> cli.getType() != null)
            .findFirst();

        cliArgumentsOptional.map(CLIFunctions::toMap)
            .map(MusicSearch::executeRequest)
            .orElse(Stream.empty())
            .forEach(System.out::println);
    }

    private static Stream<SearchResponse<? extends APIObject>> executeRequest(Map<String, Object> params) {
        ApiMusic api = APIFunctions
            .buildAPI(new AuthTokenTarget<ApiMusic>(ApiMusic.class,
                        new TokenProvider(),
                        "https://api.spotify.com/v1"));

        return Stream.of(params)
            .map(parameters -> {
                String type = (String) parameters.get("type");
                Function<? super Map<String, Object>, List<? extends SearchResponse<? extends APIObject>>> apiCaller;
                switch (type) {
                case "track":
                    apiCaller = api::songs;
                        break;
                    case "album":
                        apiCaller = api::albums;
                        break;
                    case "artists": default: // default is for artists
                        apiCaller = api::artists;
                        break;
                }
                return apiCaller.apply(parameters);
            })
            .flatMap(Collection::stream);
    }
}
