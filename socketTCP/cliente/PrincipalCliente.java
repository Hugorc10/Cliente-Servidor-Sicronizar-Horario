import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/* ***************************************************************
* Autor: Hugo Teixeira Mafra
* Matricula: 20161150
* Inicio: 08/02/2020
* Funcao: Atualizar a hora de um cliente a partir do horario do servidor
*************************************************************** */
public class PrincipalCliente extends Application{
	
  public static Scene telaCliente;

  @Override
  public void start(Stage primaryStage)throws IOException {
    Parent fxmlCliente = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/screen/ClienteScreen.fxml")));
    telaCliente = new Scene(fxmlCliente);
    primaryStage.setScene(telaCliente); // a cena eh passada para o palco
    primaryStage.setTitle("Relogio Cliente TCP");
    primaryStage.show(); // faco o palco ser exibido
  }//Fim start
  
  public static void main(String[] args){
    launch(args);
	}//Fim main

}//Fim classe