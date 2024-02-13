package com.ordep.musicsearch.util.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.ordep.musicsearch.util.api.Artist;
import com.ordep.musicsearch.util.api.ExternalUrls;
import com.ordep.musicsearch.util.api.Follower;
import com.ordep.musicsearch.util.api.Image;

public class ArtistShould {

    private Gson gson;

    private String href;
    private String id;
    private String name;
    private String type;
    private String uri;
    private ExternalUrls externalUrls;
    private Follower followers;
    private String[] genres;
    private Image[] images;
    private int popularity;

    @BeforeEach
    public void init() {
        gson = new Gson();
        href = "ref::apiobject:1";
        id = "id::72";
        name = "Bogueto";
        type = "artist";
        uri = "el_boo";
        externalUrls = new ExternalUrls("instagram.com/bogueto_official");
        followers = new Follower("ref::artist", 4331999);
        genres = new String[]{ "Urbano", "rock", "pop", "new-era", "darketo", "reggae" };
        images = new Image[]{ new Image("img1.png", 500, 100), new Image("img4.png", 100, 200) };
        popularity = 13;
    }

    @Test
    public void artist_object_to_json() {
        assertEquals("{" +
                "\"followers\":{\"href\":\"ref::artist\",\"total\":4331999}," + 
                "\"genres\":[\"Urbano\",\"rock\",\"pop\",\"new-era\",\"darketo\",\"reggae\"]," +
                "\"images\":[{\"url\":\"img1.png\",\"height\":500,\"width\":100},{\"url\":\"img4.png\",\"height\":100,\"width\":200}]," +
                "\"popularity\":13," +
                "\"href\":\"ref::apiobject:1\"," + 
                "\"id\":\"id::72\"," + 
                "\"name\":\"Bogueto\"," + 
                "\"type\":\"artist\"," + 
                "\"uri\":\"el_boo\"," + 
                "\"external_urls\":{\"spotify\":\"instagram.com/bogueto_official\"}" + 
                "}", gson.toJson(new Artist(href, id, name, type, uri, externalUrls,
                    followers, genres, images, popularity)));
    }

    @Test
    public void json_to_artist_object() {
        assertEquals(new Artist(href, id, name, type, uri, externalUrls,
                    followers, genres, images, popularity),
                gson.fromJson("{" +
                "\"followers\":{\"href\":\"ref::artist\",\"total\":4331999}," + 
                "\"genres\":[\"Urbano\",\"rock\",\"pop\",\"new-era\",\"darketo\",\"reggae\"]," +
                "\"images\":[{\"url\":\"img1.png\",\"height\":500,\"width\":100},{\"url\":\"img4.png\",\"height\":100,\"width\":200}]," +
                "\"popularity\":13," +
                "\"href\":\"ref::apiobject:1\"," + 
                "\"id\":\"id::72\"," + 
                "\"name\":\"Bogueto\"," + 
                "\"type\":\"artist\"," + 
                "\"uri\":\"el_boo\"," + 
                "\"external_urls\":{\"spotify\":\"instagram.com/bogueto_official\"}" + 
                "}", Artist.class));
    }
}
