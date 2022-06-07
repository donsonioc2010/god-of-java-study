package f.trycatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Java 6과 7 이후의 변경점
public class TrayWithResource {
    public static void main(String[] args) {

    }

    //JDK 6 이전에는 Exception을 일일히 해야했슴
    public void JDK6scanFile(String fileName, String encoding) {
        Scanner sc = null;

        try {
            sc = new Scanner(new File(fileName), encoding);
            System.out.println(sc.nextLine());
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace(); //인코딩 타입이 존재하지 않는 경우
        } catch (FileNotFoundException ffe) {
            ffe.printStackTrace(); //파일이 없는 경우
        } catch (NullPointerException npe){
            npe.printStackTrace(); //File 혹은 Encoding이 Null인 경우
        } catch (Exception e) {
            e.printStackTrace(); //이외의 Exception
        } finally {
            if(sc != null) {
                sc.close();
            }
        }
    }

    // JDK7 이후 표시방법을 변경이 가능함
    public void JDK7scanFile(String fileName, String encoding) {
        Scanner sc = null;

        try {
            sc = new Scanner(new File(fileName), encoding);
            System.out.println(sc.nextLine());
        } catch (IllegalArgumentException | FileNotFoundException | NullPointerException exception) {
            exception.printStackTrace(); //간편하게 or로 묶는게 가능함
        } finally {
            if(sc != null) {
                sc.close();
            }
        }
    }
}
