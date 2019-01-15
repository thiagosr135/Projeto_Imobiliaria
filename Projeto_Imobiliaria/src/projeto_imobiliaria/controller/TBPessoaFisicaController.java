/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_imobiliaria.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import projeto_imobiliaria.model.Locatario_Fisico;

/**
 * FXML Controller class
 *
 * @author thiag
 */
public class TBPessoaFisicaController implements Initializable {

    @FXML
    private AnchorPane ancPessoaFisicaTB;
    @FXML
    private TableView<?> tbPessoaFisica;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imobisoft");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT a FROM Locatario_Fisico a");
        
        List<Locatario_Fisico> locatario_fisico = query.getResultList();
        
        ObservableList oLocatario_Fisico = FXCollections.observableList(locatario_fisico);
        
        tbPessoaFisica.setItems(oLocatario_Fisico);
    }    
    
}
