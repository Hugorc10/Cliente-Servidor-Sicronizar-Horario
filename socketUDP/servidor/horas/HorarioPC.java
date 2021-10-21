package horas;

import java.text.SimpleDateFormat;
import java.util.Date;

import controller.ServerControllerUDP;

public class HorarioPC extends Thread {
    ServerControllerUDP c;
    
    public void run() {
        
        //formata a hora para um padrao descrito entre as aspas duplas
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        while (true) {
            //Altera a informacao da Label da interface do Servidor
            c.horario.setText(dateFormat.format(new Date()));
            //Espera 1 segundo pra atualizar novamente
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }//fim metodo catch
        }//fim while
    }//fim metodo run
    
    public void setControlador(ServerControllerUDP control) {
        c = control;
    }//fim metodo setControlador
    
}//Fim class