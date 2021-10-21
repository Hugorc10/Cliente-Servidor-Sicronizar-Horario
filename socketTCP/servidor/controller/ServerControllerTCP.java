package controller;

import time.HorarioPC;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import socket.SocketServidor;

import java.net.URL;
import java.util.ResourceBundle;

/*********************************************************************
 * Classe: Controlador
 * Funcao: controla todas as funcoes da tela
 ******************************************************************* */
public class ServerControllerTCP implements Initializable {
    public int porta = 5554;
    @FXML
    public Button btnLigarServidor;
    @FXML
    public Button btnPararServidor;
    @FXML
    public TextArea horario;
    @FXML
    ImageView viewClock;
    @FXML
    ImageView viewStoppedClock;
    
    HorarioPC classeHorario = new HorarioPC();
    
    /* ***************************************************************
     * Metodo: initialize
     * Funcao: vai ser a primeira coisa a ser executada na inicializacao da GUI
     * Parametros: url do tipo URL e rb do tipo ResourceBundle
     * Retorno: void
     *************************************************************** */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image imgClock = new Image(getClass().getResource("/img/clock_gif.gif").toExternalForm());
        viewClock.setImage(imgClock);
        
//        Image imgStoppedClock = new Image(getClass().getResource("/img/clock.png").toExternalForm());
//        viewStoppedClock.setImage(imgStoppedClock);
        
        classeHorario.setControlador(this);
        classeHorario.start();
    } //fim do initialize
    
    public void iniciarServidor(ActionEvent event) {
        porta += 1;
        Platform.runLater(() -> {
//            viewStoppedClock.setVisible(false);
            viewClock.setVisible(true);
        });
//        btnLigarServidor.setText("Nova conexao");
        SocketServidor server = new SocketServidor();
        btnLigarServidor.setVisible(false);
        server.setControlador(this);
        server.start();
        //System.out.println("depois de iniciar");
    }//Fim metodo iniciaServidor
    
}//Fim classe Controlador