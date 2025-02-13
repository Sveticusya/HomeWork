import java.io.*;
import java.net.Socket;

import static java.lang.System.out;

public class ServerThread extends Thread{
    private Socket socket;

    private BufferedReader in;
    private BufferedWriter out;

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }

    @Override
    public void run() {
        String word;
        try {
            out.write("Доступные операции: +, -, *, / \n");
            out.flush();

            while (true) {
                word = String.copyValueOf(in.readLine().toCharArray());
                System.out.println(word);

                Integer indexOfOperation = word.indexOf("+");
                Operations operation = Operations.SUM;
                if (indexOfOperation == -1) {
                    indexOfOperation = word.indexOf("-");
                    operation = Operations.SUBSTRACT;
                    if (indexOfOperation == -1) {
                        indexOfOperation = word.indexOf("*");
                        operation = Operations.MULTIPLY;
                        if (indexOfOperation == -1) {
                            indexOfOperation = word.indexOf("/");
                            operation = Operations.DIVIDE;
                        }
                    }
                }

                if (indexOfOperation == -1) {
                    out.write("Не удалось посчитать выражение \n");
                    out.flush();
                }

                Integer value1 = Integer.valueOf(word.substring(0, indexOfOperation));
                Integer value2 = Integer.valueOf(word.substring(indexOfOperation + 1));
                switch (operation) {
                    case SUM -> out.write(sum(value1, value2) + "\n");
                    case SUBSTRACT -> out.write(substract(value1, value2) + "\n");
                    case MULTIPLY -> out.write(multiply(value1, value2) + "\n");
                    case DIVIDE -> out.write(Float.toString(divide(value1, value2)) + "\n");
                }
                out.flush();
            }
        }
        catch (IOException e) {
        }
    }

    private void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {}
    }


public static Integer sum(Integer a, Integer b) {
    return a + b;
}

public  static Integer substract(Integer a, Integer b) {
    return a - b;
}

public  static float divide(Integer a, Integer b) {
    return a.floatValue() / b.floatValue();
}

public  static Integer multiply(Integer a, Integer b) {
    return a * b;
}
}
