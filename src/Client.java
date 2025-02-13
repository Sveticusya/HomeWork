import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Socket clientSocket;
    private static BufferedReader reader;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            try {

                clientSocket = new Socket("localhost", 4004);

                reader = new BufferedReader(new InputStreamReader(System.in));

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                String serverWord = in.readLine();
                System.out.println(serverWord);
                System.out.println("Введите команду");
                System.out.print("Первое число: ");
                Integer value1 = Integer.parseInt(reader.readLine());
                System.out.print("Второе число: ");
                Integer value2 = Integer.parseInt(reader.readLine());

                String operation = "";
                while (true) {
                    System.out.print("Действие: ");
                    operation = reader.readLine();
                    if (operation.equals("*") || operation.equals("+") || operation.equals("-") || operation.equals("/"))
                        break;
                }

                out.write(value1 + operation + value2 + "\n");
                out.flush();

                serverWord = in.readLine();
                System.out.print("Результат: ");
                System.out.println(serverWord);

            } finally {
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}