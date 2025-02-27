import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        File folder = new File(".");
        File[] files = folder.listFiles();
        if (files == null)
            return;

        HashMap<String, File> textFiles = new HashMap<String, File>();
        for (File file : files) {
            String fileName = file.getName();
            if (fileName.contains(".txt")) {
                textFiles.put(fileName, file);
                System.out.println(file.getName());
            }
        }

        Scanner s = new Scanner(System.in);
        File selectedFile = null;
        while (selectedFile == null) {
            System.out.println("Выберите файл.");
            String selectedFileName = s.nextLine();
            if (textFiles.containsKey(selectedFileName)) {
                selectedFile = textFiles.get(selectedFileName);
            } else
                System.out.println("Файла с таким именем не существует");
        }

        System.out.println("Содержимое файла: ");

        BufferedReader reader = new BufferedReader(new FileReader(selectedFile)))
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        System.out.println("");

        System.out.println("Введите текст: ");
        String textToAdd = s.nextLine();
        FileOutputStream fos = new FileOutputStream(selectedFile, true);
        fos.write(textToAdd.getBytes(), 0, textToAdd.length());
    }
}