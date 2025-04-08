package Tela;

import estoque.Produto;
import java.io.*;
import java.net.*;
import java.util.List;

public class Client {
    private Socket socket;
    List<Produto> lista = Produto.listarProdutos();

    public Client() {
        try {
            socket = new Socket("192.168.22.22", 12345);
            System.out.println("Conectado ao servidor...");
            // Iniciar a thread ProdutoReceiver
            Thread thread = new Thread(new ProdutoReceiver(socket));
            thread.start();
        } catch (UnknownHostException e) {
            System.err.println("Erro ao conectar ao servidor: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro ao conectar ao servidor: " + e.getMessage());
        }
    }

    public void sendProduto(String mensagem, Produto produto) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(mensagem);
            out.writeObject(produto);
            System.out.println("Objeto Produto enviado para o servidor...");
        } catch (IOException e) {
            System.err.println("Erro ao enviar objeto Produto: " + e.getMessage());
        }
    }

    public void excluirProduto(int id) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject("excluir");
            out.writeObject(id);
            System.out.println("Id do produto enviado para o servidor...");
        } catch (IOException e) {
            System.err.println("Erro ao enviar id do produto: " + e.getMessage());
        }
    }

    private class ProdutoReceiver implements Runnable {
        private Socket socket;

        public ProdutoReceiver(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                while (true) {
                    String mensagem = (String) in.readObject();
                    if (mensagem.equals("adicionar")) {
                        Produto produto = (Produto) in.readObject();
                        lista.add(produto);
                        // Atualize a interface gráfica
                        System.out.println("Produto adicionado: " + produto);
                    } else if (mensagem.equals("editar")) {
                        Produto produto = (Produto) in.readObject();
                        for (int i = 0; i < lista.size(); i++) {
                            if (lista.get(i).getId() == produto.getId()) {
                                lista.set(i, produto);
                                break;
                            }
                        }
                        // Atualize a interface gráfica
                        System.out.println("Produto editado: " + produto);
                    } else if (mensagem.equals("excluir")) {
                        int id = (int) in.readObject();
                        lista.removeIf(p -> p.getId() == id);
                        // Atualize a interface gráfica
                        System.out.println("Produto excluído: " + id);
                    }
                }
            } catch (IOException e) {
                System.err.println("Erro ao receber mensagem do servidor: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.err.println("Erro ao carregar classe Produto: " + e.getMessage());
            }
        }
    }
}