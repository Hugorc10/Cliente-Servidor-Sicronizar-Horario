import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Objects;

/* ***************************************************************
 * Autor: Hugo Teixeira Mafra
 * Matricula: 201611540
 * Inicio: 10/09/2021
 * Funcao: Atualizar a hora de um cliente a partir do horario do servidor
 *************************************************************** */
public class PrincipalServidor extends Application {
    public static Scene telaServer;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent fxmlServer = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/screen/server.fxml")));
        telaServer = new Scene(fxmlServer);
        primaryStage.setScene(telaServer); // a cena eh passada para o palco
        primaryStage.setTitle("Relogio Servidor Udp");
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        primaryStage.show(); // faco o palco ser exibido
    }//Fim start
}//Fim classe