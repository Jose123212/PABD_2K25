/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joseproject;

import java.sql.Timestamp;

public class Customer {
    private int customer_id;
    private int store_id;
    private String first_name;
    private String last_name;
    private String email;
    private int address_id;
    private int active;
    private Timestamp create_date;
    private Timestamp last_update;

    public Customer(int store_id, String first_name, String last_name, String email, int address_id, int active) {
        this.store_id = store_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address_id = address_id;
        this.active = active;
    }

 
}

