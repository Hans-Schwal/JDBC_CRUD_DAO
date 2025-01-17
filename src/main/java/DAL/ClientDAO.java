/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 80010-04-09
 */
public class ClientDAO {

    public ClientDAO() {
    }
    
    public void Insert(Client c) {
        try {
            String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");
            //System.out.println("connexion");

            PreparedStatement stm = con.prepareStatement("INSERT INTO Client (adresse_client, nom_client, prenom_client, num_client) VALUES (?, ?, ?, ?)");
            
            stm.setString(1, c.getAdresse());
            stm.setString(2, c.getNom());
            stm.setString(3, c.getPrenom());
            stm.setInt(4, c.getNumero_client());

            stm.execute();
            System.out.println("The new client has been added with success");
            stm.close();
            con.close();
       } 
        catch (Exception e) {
            System.out.println("Error while inserting entity 'client'");
            System.out.println(e.getMessage());
        }
    }

    public void Update(Client c) {
        try {
            String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");
            System.out.println("connexion");

            PreparedStatement stm = con.prepareStatement("UPDATE Client SET adresse_client = ?, nom_client = ?, prenom_client = ? WHERE num_client =?");
            
            stm.setString(1, c.getAdresse());
            stm.setString(2, c.getNom());
            stm.setString(3, c.getPrenom());
            stm.setInt(4, c.getNumero_client());

            stm.execute();
            System.out.println("The update has been saved");
            stm.close();
            con.close();
       } 
        catch (Exception e) {
            System.out.println("Error while updating entity 'client'");
            System.out.println(e.getMessage());
        }
    }

    public void Delete(Client c) {
         try {
            String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");
            System.out.println("connexion");

            PreparedStatement stm = con.prepareStatement("DELETE FROM Client WHERE num_client =?");
            
            stm.setInt(1, c.getNumero_client());

            stm.execute();
            System.out.println("Client n° " + c.getNumero_client() + "has been erased.");
            stm.close();
            con.close();
       } 
        catch (Exception e) {
            System.out.println("Error while deleting entity 'client'");
            System.out.println(e.getMessage());
        }
    }

    public void Find(Client c){
         try {
            String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");
            System.out.println("connexion");

            PreparedStatement stm = con.prepareStatement("SELECT * FROM Client WHERE num_client =?");
            
            stm.setInt(1, c.getNumero_client());

            stm.execute();
            System.out.println("Les infos client");
            stm.close();
            con.close();
       } 
        catch (Exception e) {
            System.out.println("Error while searching entity 'client'");
            System.out.println(e.getMessage());
        }
    }

    public List<Client> List() throws SQLException {
        List<Client> resultat = new ArrayList<Client>();
        
        try {

            String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");

            Statement stm = con.createStatement();

            ResultSet result = stm.executeQuery("SELECT * FROM client");

            while (result.next()) {
                Client c = new Client();
                
                c.setAdresse(result.getString("adresse_client"));
                c.setNom(result.getString("nom_client"));
                c.setPrenom(result.getString("prenom_client"));
                c.setNumero_client(result.getInt("num_client"));
                resultat.add(c);
            }

            stm.close();
            result.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error while reading 'client'");
            System.out.println(e.getMessage());
        }
        
        return resultat;
    }
        
}
