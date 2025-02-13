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
        if(files != null) {
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
                if(textFiles.containsKey(selectedFileName)) {
                    selectedFile = textFiles.get(selectedFileName);
                }
                else
                    System.out.println("Файла с таким именем не существует");
            }

            FileInputStream fis= new FileInputStream(selectedFile);     //opens a connection to an actual file
            System.out.println("Содержимое файла: ");
            int r=0;
            while((r=fis.read())!=-1) {
                System.out.print((char) r);      //prints the content of the file
            }
            System.out.println("");

            System.out.println("Введите текст: ");
            String textToAdd = s.nextLine();
            FileOutputStream fos = new FileOutputStream(selectedFile, true);
            fos.write(textToAdd.getBytes(), 0, textToAdd.length());
        }
    }
}