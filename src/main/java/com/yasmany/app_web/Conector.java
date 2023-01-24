/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yasmany.app_web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author adplascencia
 */
public class Conector {
// connection string

    //Cadena de conexión para base de datos local
     //String url = "jdbc:mysql://localhost:3306/my_bdd?useSSL=false&user=root&password=root1234";
    //String url = "jdbc:mysql://localhost:3306/bd_usuario?useSSL=false&user=root&password=root";

    //Cadena de conexión para base de datos remota (AWS)v yu7
    //String url = "jdbc:mysql://mybasepublica.chmwylaef2bh.us-east-1.rds.amazonaws.com:3306/my_esquema?user=root&password=root1234";
    String url = "jdbc:mysql://awseb-e-jsmyq832cs-stack-awsebrdsdatabase-ifdrhbslzock.creygvvc2fj1.us-east-1.rds.amazonaws.com:3306/bd_usuario?user=juanjo&password=12deMAYOde1997*";
    //jdbc:driver://hostname:port/dbName?user=userName&password=password
    Connection con;

    public void conectar() throws SQLException {
        //Crear una conexión de base de datos con la cadena de conexión
        try {
            con = DriverManager.getConnection(this.url);
        } catch (Exception e) {
        }
        
    }

    public void get_data(String query) throws SQLException {
        // Crear una sentencia
        Statement st = con.createStatement();
        //Almacenar resultado de consulta en un objeto
        ResultSet rs = st.executeQuery(query);

        // Mientras existan resultados
        while (rs.next()) {
            //Mostrar por pantalla utilizando indices de columna 
            System.out.println(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3));
        }
    }

    public void get_usuarios() throws SQLException {
        //Escribir sentencia SQL  a ejecutar
        String query = "Select * from usuario;";
        //Crear una sentencia con el sql
        Statement st = con.createStatement();
        //Ejecutar sentencia y almacenar el resultado en un objeto
        ResultSet rs = st.executeQuery(query);

        System.out.print(rs.getMetaData().getColumnName(1) + "|");
        System.out.print(rs.getMetaData().getColumnName(2) + "|");
        System.out.print(rs.getMetaData().getColumnName(4) + "|");
        System.out.println(rs.getMetaData().getColumnName(5));

        //Mientras existan resultados
        while (rs.next()) {
            //Mostrar por pantalla utilizando nombres de columnas
            System.out.println(rs.getInt("id")+"|"+ rs.getString("usuario") + "|" + rs.getString("estado") + "|" + rs.getString("cedula"));
        }
    }

    public boolean login(String usuario, String pwd) throws SQLException {
        //Escribir sentencia SQL  a ejecutar
        String query = "Select * from usuario where usuario='" + usuario + "' and contrasenia='" + pwd + "' and estado=1;";
        //System.out.println(query);
        //Crear una sentencia con el sql
        Statement st = con.createStatement();
        //Ejecutar sentencia y almacenar el resultado en un objeto
        ResultSet rs = st.executeQuery(query);
        //Existe al menos un resultado
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public void insert_user(String usuario, String pwd, int estado, String cedula) throws SQLException {
        //Escribir sentencia SQL  a ejecutar        
        String query = "insert into usuario(usuario,contrasenia,estado,cedula) values('" + usuario + "','" + pwd + "'," + estado + ",'" + cedula + "');";
        System.out.println(query);
        //Crear una sentencia con el sql
        Statement st = con.createStatement();
        //En el caso de insert o update, no se obtiene un objeto de retorno, por lo que no se utiliza un resulset
        st.executeUpdate(query);
        System.out.println("se ha insertado el usuario "+usuario);
    }

    public void delete_user(int id) throws SQLException {
        //Escribir sentencia SQL  a ejecutar        
        String query = "delete from usuario  where id=" + id + ";";
        System.out.println(query);
        //Crear una sentencia con el sql
        Statement st = con.createStatement();
        //En el caso de insert, update o delete, no se obtiene un objeto de retorno, por lo que no se utiliza un resulset
        st.executeUpdate(query);
        System.out.println("Se ha eliminado el usuario copn id="+id);
    }

    public void close_con() throws SQLException {
        con.close();
    }
}
