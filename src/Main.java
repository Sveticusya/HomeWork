import java.io.*;
import java.util.HashMap;
import java.util.Random;
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

        System.out.println("Введите символы для поиска.");
        char[] symbols = s.nextLine().toCharArray();
        int count = 0;

        BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
        String line;
        while ((line = reader.readLine()) != null) {
            char[] lineChars = line.toCharArray();
            for(int i = 0; i <= lineChars.length - symbols.length; i++) {
                boolean allEquals = true;
                for(int j = 0; j < symbols.length; j++) {
                    allEquals &= lineChars[i + j] == symbols[j];
                    if(!allEquals)
                        break;
                }

                if(allEquals)
                    count++;
            }
        }

        System.out.println("Количество повторений: " + count);
    }
}