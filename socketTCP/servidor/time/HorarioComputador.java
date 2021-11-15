package time;

import controller.ServerController;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HorarioComputador extends Thread {
    ServerController serverController;
    
    public void run() {
        // formata a hora para um padrao descrito entre as aspas duplas
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        while (true) {
            // altera a informacao da Label da interface do Servidor
            serverController.txtAreaHorario.setText(dateFormat.format(new Date()));
            // espera 1 segundo para atualizar novamente
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } // fim do catch
        } // fim do while
    }//fim metodo run
    
    public void setControlador(ServerController control) {
        serverController = control;
    }//fim metodo setControlador
}//Fim class