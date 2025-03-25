
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer{
    
    private static final int porta = 1234;
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(porta);
            System.out.println("Servidor rodando na porta: "+ porta);

            while (true) {
                System.out.println("Agurdando uma conexão...");
                Socket cliente = server.accept();
                System.out.println("Cliente "+ cliente.getInetAddress().getHostAddress() + " conectou");

                Thread thread = new Thread(() -> tratarConexao(cliente));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void tratarConexao(Socket cliente) {
        try {
            InputStream entrada = cliente.getInputStream();
            OutputStream saida = cliente.getOutputStream();

            // ...
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                cliente.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
