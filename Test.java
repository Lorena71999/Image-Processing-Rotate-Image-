import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class Test extends Image {

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);


        long start_read = System.currentTimeMillis();
        // citire info fisier sursa
        System.out.println("Tastati, va rog, locatia imaginii ce se doreste a fi rotita:");
        String String_input = sc.nextLine();
        

        // citire info fisier destinatie
        System.out.println("Tastati, va rog, locatia dorita pentru salvarea imaginii rotite:");
        String String_output = sc.nextLine();
      


        System.out.println("Tastati, va rog, numele  imaginii rotite:");
        String String_name = sc.next() + ".bmp";

        System.out.println("Tastati de cate ori rotim imaginea?");
        int rot = sc.nextInt();
        int[] degree = new int[rot];

        System.out.println("Alegeti, va rog, gradele pentru rotira imaginii(90,180,270):");
        for (int i = 0; i < rot; i++)
            degree[i] = sc.nextInt();
            sc.close();
        long stop_read = System.currentTimeMillis();

        BufferedImage rotated;
        Image img = new Test();

        //citire fisier sursa
        long start_read_source = System.currentTimeMillis();
        img.readFile(String_input);
        long stop_read_source = System.currentTimeMillis();


        //procesare imagine
        long start_rotation = System.currentTimeMillis();
        rotated = img.rotateImage(degree);
        long stop_rotation = System.currentTimeMillis();

        //scriere fisier destinatie
        long start_destination = System.currentTimeMillis();
        img.writeFile(String_output, String_name, rotated);
        long stop_destination = System.currentTimeMillis();


        //etapele de citire/scriere/procesare
        System.out.println("Etapa de citire a informatiei despre imagine dureaza: " + (stop_read - start_read) + " milisecunde");
        System.out.println("Etapa de citire a fisierului sursa dureaza: " + (stop_read_source - start_read_source) + " milisecunde");
        System.out.println("Etapa de procesare a imaginii dureaza: " + (stop_rotation - start_rotation) + " milisecunde");
        System.out.println("Etapa de scriere a fisierului destinatie dureaza: " + (stop_destination - start_destination) + " milisecunde");

    }

}