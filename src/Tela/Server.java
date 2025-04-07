package Tela;

import estoque.Produto;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket;
    private List<Socket> clientes;
    private List<Produto> produtos;

    public Server() {
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Servidor iniciado...");
            clientes = new ArrayList<>();
            produtos = new ArrayList<>();
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Conexão estabelecida com o cliente...");
                clientes.add(socket);
                Thread thread = new Thread(new ClienteHandler(socket, clientes, produtos));
                thread.start();
            }
        } catch (IOException e) {
            System.err.println("Erro ao receber objeto Produto: " + e.getMessage());
        }
    }

    private class ClienteHandler implements Runnable {
        private Socket socket;
        private List<Socket> clientes;
        private List<Produto> produtos;

        public ClienteHandler(Socket socket, List<Socket> clientes, List<Produto> produtos) {
            this.socket = socket;
            this.clientes = clientes;
            this.produtos = produtos;
        }

        @Override
        public void run() {
            try {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                String mensagem = (String) in.readObject();
                if (mensagem.equals("adicionar")) {
                    Produto produto = (Produto) in.readObject();
                    adicionarProduto(produto);
                } else if (mensagem.equals("editar")) {
                    Produto produto = (Produto) in.readObject();
                    editarProduto(produto);
                } else if (mensagem.equals("excluir")) {
                    int id = (int) in.readObject();
                    excluirProduto(id);
                }
            } catch (IOException e) {
                System.err.println("Erro ao receber objeto Produto: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.err.println("Erro ao carregar classe Produto: " + e.getMessage());
            }
        }

        public void adicionarProduto(Produto produto) {
            produtos.add(produto);
            // Enviar o objeto para todos os clientes
            for (Socket cliente : clientes) {
                if (cliente != socket) {
                    try {
                        ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                        out.writeObject("adicionar");
                        out.writeObject(produto);
                        System.out.println("Objeto Produto enviado para o cliente...");
                    } catch (IOException e) {
                        System.err.println("Erro ao enviar objeto Produto: " + e.getMessage());
                    }
                }
            }
        }

        public void editarProduto(Produto produto) {
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getId() == produto.getId()) {
                    produtos.set(i, produto);
                    break;
                }
            }
            // Enviar o objeto para todos os clientes
            for (Socket cliente : clientes) {
                if (cliente != socket) {
                    try {
                        ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                        out.writeObject("editar");
                        out.writeObject(produto);
                        System.out.println("Objeto Produto enviado para o cliente...");
                    } catch (IOException e) {
                        System.err.println("Erro ao enviar objeto Produto: " + e.getMessage());
                    }
                }
            }
        }

        public void excluirProduto(int id) {
            produtos.removeIf(p -> p.getId() == id);
            // Enviar o objeto para todos os clientes
            for (Socket cliente : clientes) {
                if (cliente != socket) {
                    try {
                        ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                        out.writeObject("excluir");
                        out.writeObject(id);
                        System.out.println("Id do produto enviado para o cliente...");
                    } catch (IOException e) {
                        System.err.println("Erro ao enviar id do produto: " + e.getMessage());
                    }
                }
            }
        }
    }
}