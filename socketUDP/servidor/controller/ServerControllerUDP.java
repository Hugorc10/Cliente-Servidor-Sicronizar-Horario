package controller;

import horas.HorarioPC;
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
public class ServerControllerUDP implements Initializable {
    @FXML
    public TextArea horario;
    @FXML
    Button btnLigarServidor;
    @FXML
    Button btnPararServidor;
    @FXML
    ImageView imgViewClock;
//    @FXML
//    ImageView imgViewStoppedClock;
    HorarioPC classeHorario = new HorarioPC();
    
    /* ***************************************************************
     * Metodo: initialize
     * Funcao: vai ser a primeira coisa a ser executada na inicializacao da GUI
     * Parametros: url do tipo URL e rb do tipo ResourceBundle
     * Retorno: void
     *************************************************************** */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnPararServidor.setVisible(false);
//    File file1 = new File("/imagens/clock.png");
        Image imgStoppedClock = new Image(getClass().getResource("/img/clock.png").toExternalForm());
//        imgViewStoppedClock.setImage(imgStoppedClock);

//    File file2 = new File("/imagens/clock-gif.gif");
        Image imgClock = new Image(getClass().getResource("/img/clock_gif.gif").toExternalForm());
        imgViewClock.setImage(imgClock);
        
        classeHorario.setControlador(this);
        classeHorario.start();
    } //fim do initialize
    
    public void iniciarServidor(ActionEvent event) {
        Platform.runLater(() -> {
//            imgViewStoppedClock.setVisible(false);
            imgViewClock.setVisible(true);
            btnPararServidor.setVisible(true);
            btnLigarServidor.setVisible(false);
        });
//        SocketServidor.stop = false;
        SocketServidor server = new SocketServidor();
//        System.out.println(SocketServidor.stop);
        if (!SocketServidor.stop) {
            System.out.println("Thread esta viva");
            server.start();
        } else {
            System.out.println("Servidor ainda esta rodando");
            return;
        }
        SocketServidor.stop = false;
    }//Fim metodo iniciaServidor
    
    public void stopServer(ActionEvent event) {
        Platform.runLater(() -> {
            btnLigarServidor.setVisible(true);
            btnPararServidor.setVisible(false);
            imgViewClock.setVisible(false);
            SocketServidor.stop = true;
        });
    }
    
}//Fim classe Controlador