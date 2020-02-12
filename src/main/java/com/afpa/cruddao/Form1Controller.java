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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 80010-04-09
 */
public class Form1Controller implements Initializable {

    @FXML
    private TableView<Client> tableView;
    
    ObservableList<Client> model = FXCollections.observableArrayList();
    ClientDAO repo = new ClientDAO();
    
    @FXML
    private TableColumn<Client, String> col_nom;
    @FXML
    private TableColumn<Client, String> col_prenom;
    @FXML
    private TableColumn<Client, String> col_adresse;
    @FXML
    private Label lbl_details;
    @FXML
    private Button btn_ajouter;
    @FXML
    private Button btn_modifier;
    @FXML
    private Button btn_supprimer;
    @FXML
    private Button btn_ok;
    @FXML
    private Button btn_annuler;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_prenom;
    @FXML
    private TextField txt_adresse;
    @FXML
    private TextField txt_numcli;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //On rend le tableau non-éditable
        tableView.setEditable(false);
        // Jonction du tableau avec les données
        col_nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));	
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        // On indique au TableView quel modèle observer pour trouver les données
        try{
            model = FXCollections.observableArrayList(repo.List());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        tableView.setItems(model);
    }    
    
    private void liste(ActionEvent event) {
        try {
            repo.List();
        } catch (SQLException ex) {
            Logger.getLogger(Form1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void details(ActionEvent event) {
        Client c = new Client();
        c.Numero_client = 5;
        
        repo.Find(c);
    }
    
    @FXML
    private void ajouter(ActionEvent event) {
        Client c = new Client();
        c.Nom = txt_nom.getText();
        c.Prenom = txt_prenom.getText();
        c.Adresse = txt_adresse.getText();
        // Utilisation de la casse pour recup le num client depuis un textfield (string) vers un entier
        c.Numero_client = Integer.parseInt(txt_numcli.getText());
        repo.Insert(c);
    }
    
    @FXML
    private void modifier(ActionEvent event) {
        Client c = new Client();
        c.Nom = txt_nom.getText();
        c.Prenom = txt_prenom.getText();
        c.Adresse = txt_adresse.getText();
        c.Numero_client = Integer.parseInt(txt_numcli.getText());
        repo.Update(c);
    }
    
    @FXML
    private void supprimer(ActionEvent event) {
        Client c = new Client();
        c.Numero_client = Integer.parseInt(txt_numcli.getText());
        repo.Delete(c);
    }

    @FXML
    private void annulerSaisie(ActionEvent event) {
        txt_nom.clear();
        txt_prenom.clear();
        txt_adresse.clear();
        txt_numcli.clear();
    }
    
}
