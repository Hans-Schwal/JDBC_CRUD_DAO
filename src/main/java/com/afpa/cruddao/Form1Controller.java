/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.cruddao;

import DAL.Client;
import DAL.ClientDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author 80010-04-09
 */
public class Form1Controller implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    private void liste(ActionEvent event) {
        Client c = new Client();

        ClientDAO repo = new ClientDAO ();

        try {
            repo.List();
        } catch (SQLException ex) {
            Logger.getLogger(Form1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void details(ActionEvent event) {
        
    }
    
    private void ajouter(ActionEvent event) {
        Client c = new Client();
        c.Nom = "Lebowski";
        c.Prenom = "Jeffrey";
        c.Adresse = "Los Angeles";
        c.Numero_client = 5;

        ClientDAO repo = new ClientDAO ();

        repo.Insert(c);
    }
    
    private void modifier(ActionEvent event) {
        Client c = new Client();
        c.Nom = "Lebowski";
        c.Prenom = "Jeffrey";
        c.Adresse = "Los Angeles";
        c.Numero_client = 5;

        ClientDAO repo = new ClientDAO ();

        repo.Update(c);
    }
    
    private void supprimer(ActionEvent event) {
        Client c = new Client();
        c.Numero_client = 5;
        ClientDAO repo = new ClientDAO ();
        repo.Delete(c);
    }
    
}
