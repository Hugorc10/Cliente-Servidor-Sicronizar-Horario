package controller;

import time.HorarioComputador;
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
 * Classe: ServerController
 * Funcao: controla todas as funcoes da tela
 ******************************************************************* */
public class ServerController implements Initializable {
    @FXML
    public TextArea txtAreaHorario;
    @FXML
    Button btnLigarServidor;
//    @FXML
//    Button btnPararServidor;
    @FXML
    ImageView imgViewClock;
    HorarioComputador classeHorario = new HorarioComputador();
    
    /* ***************************************************************
     * Metodo: initialize
     * Funcao: vai ser a primeira coisa a ser executada na inicializacao da GUI
     * Parametros: url do tipo URL e rb do tipo ResourceBundle
     * Retorno: void
     *************************************************************** */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLigarServidor.setDefaultButton(true);
        
//    File file2 = new File("/imagens/clock-gif.gif");
        Image imgClock = new Image(getClass().getResource("/img/clock_gif.gif").toExternalForm());
        imgViewClock.setImage(imgClock);
        
        classeHorario.setControlador(this);
        classeHorario.start();
    } //fim do metodo initialize
    
    public void iniciarServidor(ActionEvent event) {
        Platform.runLater(() -> {
            imgViewClock.setVisible(true);
//            btnPararServidor.setVisible(true);
            btnLigarServidor.setVisible(false);
        });
        SocketServidor server = new SocketServidor();
        server.start();
    } // fim metodo iniciaServidor
} // fim classe ServerController