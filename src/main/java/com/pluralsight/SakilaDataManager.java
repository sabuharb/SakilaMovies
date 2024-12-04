package com.pluralsight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SakilaDataManager {

    private DataSource dataSource;

    // Constructor to initialize the data source
    public SakilaDataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Example method to retrieve all actors
    public List<Actor> getAllActors() throws SQLException {
        List<Actor> actors = new ArrayList<>();

        String sql = "SELECT actor_id, first_name, last_name FROM actor";
        Connection conn = dataSource.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet results = statement.executeQuery();

        while (results.next()) {
            int actorId = results.getInt("actor_id");
            String firstName = results.getString("first_name");
            String lastName = results.getString("last_name");

            Actor actor = new Actor(actorId, firstName, lastName);
            actors.add(actor);
        }

        conn.close();
        return actors;
    }

    // Example method to get films by actor ID
    public List<Film> getFilmsByActorId(int actorId) throws SQLException {
        List<Film> films = new ArrayList<>();

        String sql = "SELECT f.film_id, f.title, f.description, f.release_year, f.length " +
                "FROM film f " +
                "JOIN film_actor fa ON f.film_id = fa.film_id " +
                "WHERE fa.actor_id = ?";
        Connection conn = dataSource.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, actorId);
        ResultSet results = statement.executeQuery();

        while (results.next()) {
            int filmId = results.getInt("film_id");
            String title = results.getString("title");
            String description = results.getString("description");
            int releaseYear = results.getInt("release_year");
            int length = results.getInt("length");

            Film film = new Film(filmId, title, description, releaseYear, length);
            films.add(film);
        }

        conn.close();
        return films;
    }
}

