package principal;

import java.io.*;
import java.net.*;
public class ServidorSocket {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket servidor = new ServerSocket(1245, 100);
        while(true){
            Socket socket = servidor.accept();
            InputStream DadosDeEntrada = socket.getInputStream();
            ObjectInputStream Entrada = new ObjectInputStream(DadosDeEntrada);
            System.out.println("Server Iniciado");
            
            Cliente cliente = null;
            cliente = (Cliente) Entrada.readObject();
            while (cliente.getCodigo() != -1){
                System.out.println("Objeto cliente Chegou");
                cliente.imprimir();
                cliente = (Cliente) Entrada.readObject();   
            }
        
        System.out.println("Servidor parou");
        Entrada.close();
        socket.close();
        servidor.close();
        }
    }

}
