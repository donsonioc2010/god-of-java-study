package e.io;

import static java.io.File.separator;

import java.io.*;
import java.util.Scanner;

public class ManageTextFile {
    public static void main(String[] args) {
        String pathName = separator +"Users"+ separator+"kimjongwon"+ separator + "GodOfJavaFileTest" + separator + "text";

        ManageTextFile manager = new ManageTextFile();
        int numberCount = 10;
        String fullPath = pathName + separator + "number.txt";
        //manager.writeFile(fullPath, numberCount);
        //manager.readFile(fullPath, numberCount);
        manager.readFileWithScanner(fullPath);
    }

    public void writeFile(String fileName, int numberCount) {
        FileWriter fileWriter = null;
        BufferedWriter bufferWirter = null;

        try {
            //fileWriter = new FileWriter(fileName);
            fileWriter = new FileWriter(fileName, true); //true 는 파일 붙여쓰기, false는 덮어쓰기
            bufferWirter = new BufferedWriter(fileWriter);
            for(int loop = 0; loop <= numberCount; loop++) {
                bufferWirter.write(Integer.toString(loop));
                bufferWirter.newLine();
            }
            System.out.println("Write Success");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(bufferWirter != null){
                try {
                    bufferWirter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void readFile(String fileName, int numberCount) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            String data;
            while((data = bufferedReader.readLine()) != null) {
                System.out.println(data);
            }

            System.out.println("Read Success");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void readFileWithScanner(String fileName) {
        File file = new File(fileName);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(sc != null) {
                sc.close();
            }
        }
    }
}
