import java.awt.image.BufferedImage;
import java.io.IOException;

//clasa abstracta cu metoda  scriere a fisierului  si metoda de rotatie
public abstract class FileOperations {
    public abstract BufferedImage rotateImage(int ...degree);
    public abstract void writeFile(String output, String name, BufferedImage rotated_image);



}