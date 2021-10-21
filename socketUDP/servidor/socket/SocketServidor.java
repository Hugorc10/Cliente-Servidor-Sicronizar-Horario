package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketServidor extends Thread {
    public static boolean stop = false;
    
    public void run() {
        try {
            int porta = 9876;
            int numConn = 1;
            
            DatagramSocket serverSocket = new DatagramSocket(porta);
            
            byte[] receiveData = new byte[1024];
            byte[] sendData;
            
            while (!stop) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                System.out.println("Esperando por datagrama UDP na porta " + porta);
                serverSocket.receive(receivePacket);
                System.out.print("Datagrama UDP [" + numConn + "] recebido...");
                
                InetAddress IPAddress = receivePacket.getAddress();
                
                int port = receivePacket.getPort();
                
                //String capitalizedSentence = sentence.toUpperCase();
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                
                String horas = sdf.format(new Date());
                
                sendData = horas.getBytes();
                
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                
                System.out.print("Enviando " + horas + "...");
                
                serverSocket.send(sendPacket);
                if (stop) {
                    serverSocket.close();
                    System.out.println("Parei o servidor");
                }
                System.out.println("OK\n");
                
            }//fim while
        } catch (IOException e) {
            e.printStackTrace();
        }//fim metodo catch
    }//fim metodo iniciarServer
}//fim classe Socket