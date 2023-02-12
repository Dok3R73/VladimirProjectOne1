package com.example.vladimirprojectone.person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
//
public class Users {
    private static final String URL = "jdbc:postgresql://localhost:5432/TestBases";
    private static final String ROOT_NAME = "postgres";
    private static final String PASSWORD = "180868";

    private static Connection connection;

    private String firstName;
    private String middleName;
    private String lastName;
    private int id;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, ROOT_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Users(String firstName, String middleName, String lastName) throws SQLException {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        createUserBD();
    }

    private void createUserBD() throws SQLException {
        String SQL = "insert into person (first_name, middle_name, last_name) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, middleName);
        preparedStatement.setString(3, lastName);
        preparedStatement.executeUpdate();

        String sqlId = "select * from person order by id desc";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlId);
        ArrayList<Integer> result = new ArrayList<>();

        while (resultSet.next()) {
            result.add((int) resultSet.getInt("id"));
        }

        this.id = Collections.max(result);

    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Users{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

}
