package com.pluralsight;

import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;

public class Main {
    private static DataSource dataSource;

    public static void main(String[] args) {
        // Create a DataSource
        String url = "jdbc:mysql://127.0.0.1:3306/sakila"; // Database URL
        String user = args[0]; // Username passed as a command-line argument
        String password = args[1]; // Password passed as a command-line argument
        Scanner scanner = new Scanner(System.in);

        try {
            // Initialize DataSource
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL(url);
            mysqlDataSource.setUser(user);
            mysqlDataSource.setPassword(password);
            dataSource = mysqlDataSource;

            // Initialize DataManager (Assuming a DataManager class exists)
            SakilaDataManager dataManager = new SakilaDataManager(dataSource);

            // Fetch all actors
            System.out.println("All Actors:");
            dataManager.getAllActors().forEach(System.out::println);

            // Fetch films by actor ID
            System.out.println("\nFilms by Actor ID (Enter an ID):");
            int actorId = scanner.nextInt(); // Dynamic input
            dataManager.getFilmsByActorId(actorId).forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
