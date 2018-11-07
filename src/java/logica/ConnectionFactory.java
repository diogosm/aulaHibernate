/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.sql.*;

/**
 *
 * @author diogo
 */
public class ConnectionFactory {

    public Connection getConnection() {
        /*try {

            DriverManager.registerDriver(new org.postgresql.Driver());
            return DriverManager.getConnection(""
                    + "jdbc:postgresql://localhost:5432/"
                    + "postgres",
                    "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        return null;
    }
}
