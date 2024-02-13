# Music cli
Music CLI is a simple CLI App which consumes the API of Spotify with the idea
of consult music.

## Commands
```bash
music-search expression

music-search expression [[-t --type] [album|artist|track]]

music-search expression [[-m --market] country_code]

music-search expression [[-l --limit] result_limit]

music-search expression [[-o --offset] idx_fst_return] # use with --limit to next page of results
```
