import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

//clasa ce mosteneste FileOperations si implemeteaza metodele abstarcte
public class Image extends FileOperations {
    BufferedImage image;

    @Override
    //implemetarea metodei de rotatie
    public BufferedImage rotateImage(int ...degree){
          ImageToRotate rotation1 = new ImageToRotate(this.image);
          BufferedImage rotated_image = this.image;
          int var = 0;
          for (int degree1 : degree)  var += degree1;

          switch (var % 360){
             case 90:
                 rotated_image = rotation1.rotates_with_90();
                 break;
             case 180:
                 rotated_image = rotation1.rotates_with_180();
                 break;
             case 270:
                 rotated_image = rotation1.rotates_with_270();
                 break;
			case 0:rotated_image = this.image;
			     break;
             default:

                System.out.println("Wrong angle!");
          }

        return rotated_image;
    }


    @Override
    //scrierea imaginii noi
    public void writeFile(String output, String name, BufferedImage rotated) {
        File output_file = new File(output, name);
        try{
            ImageIO.write(rotated, "bmp", output_file);
            System.out.println("The image is written !");

        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    //citirea imaginii sursa multithreading
    public void readFile(String String_input) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(String_input);
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file stream");
            e.printStackTrace();
        }
        int size;
        try {
            size = inputStream.available();
        } catch (IOException e) {
            System.out.println("Could not find the size");
            e.printStackTrace();
            throw new RuntimeException();
        }
        int partialSize = size / 4;
        Buffer buffer = new Buffer(partialSize, size, inputStream);
        Thread threads[] = new Thread[2];
        threads[0] = new Thread(new Producer(buffer));//primul thread ce ia o patrime din info si dupa va intra in NO RUNNABLE
        threads[1] = new Thread(new Consumer(buffer));//Al doilea thread ce "consuma" informatia produsa

        for (int i = 0; i < 2; i++)
            threads[i].start();//activare thread-uri
        for (int i = 0; i < 2; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        image = createImageFromBytes(buffer.imgg);//convertesc imaginea
    }
    private  BufferedImage createImageFromBytes(byte[] imageData) {//metoda ce imi converteste imaginea din bytes in format dorit de mine
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        try {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}