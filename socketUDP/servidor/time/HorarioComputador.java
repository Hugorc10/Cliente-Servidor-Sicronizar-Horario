package time;

import java.text.SimpleDateFormat;
import java.util.Date;

import controller.ServerController;

public class HorarioComputador extends Thread {
    ServerController serverController;
    
    public void run() {
        // formata a hora para um padrao descrito entre as aspas duplas
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        while (true) {
            //Altera a informacao do TextArea da interface do Servidor
            serverController.txtAreaHorario.setText(dateFormat.format(new Date()));
            //Espera 1 segundo pra atualizar novamente
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }//fim metodo catch
        } // fim do while
    } //fim metodo run
    
    public void setControlador(ServerController control) {
        serverController = control;
    } // fim metodo setControlador
    
} // fim classe HorarioComputador