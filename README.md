# IMDb Movie Search Application

The **IMDb Movie Search Application** allows users to search movies based on genre, country, year, critics’ rating values, movie tags, etc. It's developed using Java and Oracle Database.

## Install

Clone the repository.
```bash
$ git clone https://github.com/xinjoy/movie_search.git
```

## Populate the database

```bash
$ cd movie_search/populate
$ java populate movies.dat movie_genres.dat movie_countries.dat movie_locations.dat tags.dat movie_tags.dat
```

## Run

```bash
$ cd movie_search
$ javac movie_search/*.java
$ java movie_search.main
```