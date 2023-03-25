package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class Client {
    public static void main(String[] args) {
        try (BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
             Socket socket = new Socket("localhost", 8080);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to the server");

            System.out.print("Enter your name: ");
            String name = consoleIn.readLine();
            out.println(name);

            Thread updatesThread = new Thread(() -> {
                while (true) {
                    try {
                        String message = in.readLine();
                        System.out.println(message);
                    } catch (IOException e) {
                        System.err.println("Error: " + e.getMessage());
                        System.exit(1);
                    }
                }
            });
            updatesThread.start();

            while (true) {
                String message = consoleIn.readLine();
                if (Objects.equals(message, "/q")) {
                    updatesThread.interrupt();
                    socket.close();
                    break;
                }
                out.println(message);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}