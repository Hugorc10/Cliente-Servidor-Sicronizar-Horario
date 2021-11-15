import java.io.IOException;
import java.util.Objects;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import controller.ClientController;

/**
 * Autor: Hugo Teixeira Mafra
 * Matricula: 201611540
 * Inicio: 10/09/2021
 * Funcao: Atualizar a hora de um cliente a partir do horario do servidor
 */
public class PrincipalCliente extends Application {
    
    public static Scene telaCliente;
    
    public static void main(String[] args) {
        launch(args);
    } //fim do main
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent fxmlCliente = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/screen/client.fxml")));
        telaCliente = new Scene(fxmlCliente);
        primaryStage.setScene(telaCliente); // a cena eh passada para o palco
        primaryStage.setTitle("Relogio cliente UDP");
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        primaryStage.show(); // o palco eh exibido
    } // fim metodo start
    
} // fim classe Principal