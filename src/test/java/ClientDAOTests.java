/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAL.Client;
import DAL.ClientDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 80010-04-09
 */
public class ClientDAOTests {
    
    public ClientDAOTests() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void insert_cas1(){
        
        Client client1 = new Client();
        client1.Nom = "Schwal";
        client1.Prenom = "Hans";
        client1.Adresse = "Amiens";
        client1.Numero_client = 15;

        ClientDAO repo = new ClientDAO ();

        repo.Insert(client1);
        
        //assertTrue(client1.equals(c));
        
    }
}
