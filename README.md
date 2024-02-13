# Music-CLI
Simple CLI app which consumes Spotify API.


## Requirements
- Java SE 19+

## Setup
This app works kinda like raw access to Spotify API (so no AWT auth or Oauth,
just dev credentials) so you have to provide your own Spotify dev credentials
in way to make it work so for that just put your credentials inside of
["api_credentials"](./music-cli/src/main/resources/api_credentials.json).

If you don't have a Spotify API credentials just figure it out.


## Usage
This CLI app has the next options:
```
Usage: music-search [options] query
  Options:
    --help, -h
      Mostrar información acerca del comando, opciones y argumentos
    --limit, -l
      Número que limita la cantidad de elementos a buscar
      Default: 0
    --market, -m
      Buscará según las siglas del mercado dado. E.g. mx, us, pe
    --offset, -o
      De los elementos recibidos, a partir de que índice mostrará los 
      elementos encontrados
      Default: 0
  * --type, -t
      Valid types: album, artist, track
```
Option *type* and *query* are mandatory. You only can search by album, artist
or track, also can search one of these options to see if it is accesible in
a especific market (-m) just provide a [ISO 316-1_alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2)
code.

Also, can limit the expected result set from Spotify using te option *--limit*
or define from which element start to list the results with *--offset*.
