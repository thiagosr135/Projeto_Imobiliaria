/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_imobiliaria.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author thiag
 */
public class MenuPrincipalController implements Initializable {

    @FXML
    private JFXDrawer drwMenu;
    @FXML
    private JFXHamburger hbgMenu;
    @FXML
    private AnchorPane MainPanel;
    @FXML
    private AnchorPane anpMenuPrincipal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /** BARRA DE MENU */
        /** ABRIR BARRA DE MENU */
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projeto_imobiliaria/view/MenuBar.fxml"));
            VBox box = loader.load();
            drwMenu.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hbgMenu);
        transition.setRate(-1);
        hbgMenu.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();
            
            if (drwMenu.isOpened()) {
                drwMenu.close();
            } else {
                drwMenu.open();
            }
        });
        
    }    
    
}
