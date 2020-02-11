/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.cruddao;

/**
 *
 * @author 80010-04-09
 */
public class Client {
    public String Adresse;
    public String Nom;
    public String Prenom;
    public int Numero_client;
    
    public Client(){
        
    }

    public Client(String Adresse, String Nom, String Prenom, int Numero_client) {
        this.Adresse = Adresse;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Numero_client = Numero_client;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public int getNumero_client() {
        return Numero_client;
    }

    public void setNumero_client(int Numero_client) {
        this.Numero_client = Numero_client;
    }  
}
