package com.UI;

import java.sql.DriverManager;

import static java.sql.DriverManager.println;

public class Dbconnection {
    Dbconnection(){

    }

    public java.sql.Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/project?autoReconnect=true&useSSL=false","root","");
            return con;
        }catch(Exception e){ System.out.println(e);}
        //System.out.println("ygfygfuty");


        return null;
    }

}

