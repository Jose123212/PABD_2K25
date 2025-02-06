/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package joseproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 17740431494
 */
public class JoseProject {


    public static void main(String[] args) throws SQLException {

        Connection con = null;

        try {
            con = new ConnectionFactory().getConnection();
            System.out.println("Connection OK!");


            insertCustomer(con, 1, "Alcemy", "Severino", "alcemy@gmail.com", 10, 1);         
            updateCustomer(con, "Alcemy", "Severino", 2, 5);
            deleteCustomer(con, "Alcemy", "Severino");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
                System.out.println("Connection closed!");
            }
        }
    }

    public static void insertCustomer(Connection con, int store_id, String first_name, String last_name, String email, int address_id, int active) throws SQLException {
        String sql = "INSERT INTO customer (store_id, first_name, last_name, email, address_id, active, create_date, last_update) VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, store_id);
            stmt.setString(2, first_name);
            stmt.setString(3, last_name);
            stmt.setString(4, email);
            stmt.setInt(5, address_id);
            stmt.setInt(6, active);
            stmt.executeUpdate();
            System.out.println("Cliente Inserido: " + first_name + " " + last_name);
        }
    }

    public static void updateCustomer(Connection con, String first_name, String last_name, int new_store_id, int new_address_id) throws SQLException {
        String sql = "UPDATE customer SET store_id = ?, address_id = ?, last_update = CURRENT_TIMESTAMP WHERE first_name = ? AND last_name = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, new_store_id);
            stmt.setInt(2, new_address_id);
            stmt.setString(3, first_name);
            stmt.setString(4, last_name);
            stmt.executeUpdate();
            System.out.println("Cliente Atualizado: " + first_name + " " + last_name);
        }
    }

    public static void deleteCustomer(Connection con, String first_name, String last_name) throws SQLException {
        String sql = "DELETE FROM customer WHERE first_name = ? AND last_name = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.executeUpdate();
            System.out.println("Cliente Deletado: " + first_name + " " + last_name);
        }
    }
   }



