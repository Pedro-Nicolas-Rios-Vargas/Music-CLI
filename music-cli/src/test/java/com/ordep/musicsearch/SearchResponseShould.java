package com.ordep.musicsearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ordep.musicsearch.SearchResponse;
import com.ordep.musicsearch.util.api.Artist;
import com.ordep.musicsearch.util.api.ExternalUrls;
import com.ordep.musicsearch.util.api.Follower;
import com.ordep.musicsearch.util.api.Image;

public class SearchResponseShould {

    private Gson gson;

    private String href;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private int total;
    private Artist[] items;

	@BeforeEach
    public void init() {
        gson = new Gson();

        href = "Object::APIObject";
        limit = 5;
        next = "siguiente";
        offset = 1;
        previous = "anterior";
        total = 50;
        items = new Artist[]{
            new Artist("Object::Artist", "Artist_id:1", "Central Cee",
                    "artist", "uri", new ExternalUrls("spotify"),
                    new Follower("Object::Follower", 13),
                    new String[]{ "MX" },
                    new Image[]{ new Image("img.png", 500, 100) }, 15),
            new Artist("Object::Artist", "Artist_id:2", "Free Nationals",
                    "artist", "uri", new ExternalUrls("spotify"),
                    new Follower("Object::Follower", 12),
                    new String[]{ "US" },
                    new Image[]{ new Image("img.png", 300, 200) }, 100),
        };
    }

    @Test
    public void searchResponse_object_to_json() {
        SearchResponse<Artist> searchResponse = new SearchResponse<>(href,
                limit, next, offset, previous, total, items);

        assertEquals("{" +
                "\"href\":\"Object::APIObject\"," +
                "\"limit\":5," +
                "\"next\":\"siguiente\"," +
                "\"offset\":1," +
                "\"previous\":\"anterior\"," +
                "\"total\":50," +
                "\"items\":[" +
                    "{" +
                        "\"followers\":{" +
                            "\"href\":\"Object::Follower\"," +
                            "\"total\":13" +
                        "}," +
                        "\"genres\":[\"MX\"]," +
                        "\"images\":[" +
                            "{" +
                                "\"url\":\"img.png\"," +
                                "\"height\":500,\"width\":100" +
                            "}" +
                        "]," +
                        "\"popularity\":15," +
                        "\"href\":\"Object::Artist\"," +
                        "\"id\":\"Artist_id:1\"," +
                        "\"name\":\"Central Cee\"," +
                        "\"type\":\"artist\"," +
                        "\"uri\":\"uri\"," +
                        "\"external_urls\":{\"spotify\":\"spotify\"}" +
                    "}," +
                    "{" +
                        "\"followers\":{" +
                            "\"href\":\"Object::Follower\"," +
                            "\"total\":12" +
                        "}," +
                        "\"genres\":[\"US\"]," +
                        "\"images\":[" +
                            "{" +
                                "\"url\":\"img.png\"," +
                                "\"height\":300,\"width\":200" +
                            "}" +
                        "]," +
                        "\"popularity\":100," +
                        "\"href\":\"Object::Artist\"," +
                        "\"id\":\"Artist_id:2\"," +
                        "\"name\":\"Free Nationals\"," +
                        "\"type\":\"artist\"," +
                        "\"uri\":\"uri\"," +
                        "\"external_urls\":{\"spotify\":\"spotify\"}" +
                    "}" +
                "]" +
                "}", gson.toJson(searchResponse));
    }

    @Test
    public void json_to_searchResponse_object() {
        SearchResponse<Artist> expectedSearchResponse = new SearchResponse<>(href, limit,
                next, offset, previous, total, items);

        TypeToken<SearchResponse<Artist>> typeToken = new TypeToken<SearchResponse<Artist>>() {};
        SearchResponse<Artist> actualSearchResponse = gson.fromJson("{" +
                "\"href\":\"Object::APIObject\"," +
                "\"limit\":5," +
                "\"next\":\"siguiente\"," +
                "\"offset\":1," +
                "\"previous\":\"anterior\"," +
                "\"total\":50," +
                "\"items\":[" +
                    "{" +
                        "\"followers\":{" +
                            "\"href\":\"Object::Follower\"," +
                            "\"total\":13" +
                        "}," +
                        "\"genres\":[\"MX\"]," +
                        "\"images\":[" +
                            "{" +
                                "\"url\":\"img.png\"," +
                                "\"height\":500,\"width\":100" +
                            "}" +
                        "]," +
                        "\"popularity\":15," +
                        "\"href\":\"Object::Artist\"," +
                        "\"id\":\"Artist_id:1\"," +
                        "\"name\":\"Central Cee\"," +
                        "\"type\":\"artist\"," +
                        "\"uri\":\"uri\"," +
                        "\"external_urls\":{\"spotify\":\"spotify\"}" +
                    "}," +
                    "{" +
                        "\"followers\":{" +
                            "\"href\":\"Object::Follower\"," +
                            "\"total\":12" +
                        "}," +
                        "\"genres\":[\"US\"]," +
                        "\"images\":[" +
                            "{" +
                                "\"url\":\"img.png\"," +
                                "\"height\":300,\"width\":200" +
                            "}" +
                        "]," +
                        "\"popularity\":100," +
                        "\"href\":\"Object::Artist\"," +
                        "\"id\":\"Artist_id:2\"," +
                        "\"name\":\"Free Nationals\"," +
                        "\"type\":\"artist\"," +
                        "\"uri\":\"uri\"," +
                        "\"external_urls\":{\"spotify\":\"spotify\"}" +
                    "}" +
                "]" +
                "}", typeToken);

        assertEquals(expectedSearchResponse, actualSearchResponse);
    }

    @Test
    public void json_searchResponse_object_with_Artist_type_to_searchResponse_object_java() {
        SearchResponse<Artist> expectedSearchResponse = new SearchResponse<>(href,
                limit, next, offset, previous, total, items);

        TypeToken<SearchResponse<Artist>> typeToken = new TypeToken<SearchResponse<Artist>>() {};
        assertEquals(expectedSearchResponse, gson.fromJson("{" +
                "\"href\":\"Object::APIObject\"," +
                "\"limit\":5," +
                "\"next\":\"siguiente\"," +
                "\"offset\":1," +
                "\"previous\":\"anterior\"," +
                "\"total\":50," +
                "\"items\":[" +
                    "{" +
                        "\"followers\":{" +
                            "\"href\":\"Object::Follower\"," +
                            "\"total\":13" +
                        "}," +
                        "\"genres\":[\"MX\"]," +
                        "\"images\":[" +
                            "{" +
                                "\"url\":\"img.png\"," +
                                "\"height\":500,\"width\":100" +
                            "}" +
                        "]," +
                        "\"popularity\":15," +
                        "\"href\":\"Object::Artist\"," +
                        "\"id\":\"Artist_id:1\"," +
                        "\"name\":\"Central Cee\"," +
                        "\"type\":\"artist\"," +
                        "\"uri\":\"uri\"," +
                        "\"external_urls\":{\"spotify\":\"spotify\"}" +
                    "}," +
                    "{" +
                        "\"followers\":{" +
                            "\"href\":\"Object::Follower\"," +
                            "\"total\":12" +
                        "}," +
                        "\"genres\":[\"US\"]," +
                        "\"images\":[" +
                            "{" +
                                "\"url\":\"img.png\"," +
                                "\"height\":300,\"width\":200" +
                            "}" +
                        "]," +
                        "\"popularity\":100," +
                        "\"href\":\"Object::Artist\"," +
                        "\"id\":\"Artist_id:2\"," +
                        "\"name\":\"Free Nationals\"," +
                        "\"type\":\"artist\"," +
                        "\"uri\":\"uri\"," +
                        "\"external_urls\":{\"spotify\":\"spotify\"}" +
                    "}" +
                "]" +
                "}", typeToken));
    }
}
