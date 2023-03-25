package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static class ClientThread extends Thread {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;
        private static ArrayList<ClientThread> ServerThreads = new ArrayList<>();
        public ClientThread(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                String name = in.readLine();

                out.println("Welcome to the chat room, " + name);

                for (ClientThread thread : ServerThreads) {
                    if (thread != this) {
                        thread.out.println(name + " is here");
                    }
                }

                ServerThreads.add(this);

                while (true) {
                    String message = in.readLine();
                    if (Objects.equals(message, null)) break;
                    System.out.println(name + ": " + message);

                    for (ClientThread thread : ServerThreads) {
                        if (thread != this) {
                            thread.out.println(name + ": " + message);
                        }
                    }
                }

                ServerThreads.remove(this);

                for (ClientThread thread : ServerThreads) {
                    if (thread != this) {
                        thread.out.println(name + " left");
                    }
                }

                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}