CREATE TABLE movie (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    director TEXT NOT NULL,
    release_year INTEGER NOT NULL,
    available BOOLEAN NOT NULL
);