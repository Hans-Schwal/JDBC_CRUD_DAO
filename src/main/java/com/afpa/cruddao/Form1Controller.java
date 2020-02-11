/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.cruddao;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author 80010-04-09
 */
public class Form1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Client c = new Client();
        c.Nom = "Lebowski";
        c.Prenom = "Jeffrey";
        c.Adresse = "Los Angeles";
        c.Numero_client = 5;

        ClientDAO repo = new ClientDAO ();

        repo.Insert(c);

    }    
    
}
