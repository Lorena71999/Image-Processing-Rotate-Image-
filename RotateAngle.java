import java.awt.image.BufferedImage;

//interfata
public interface RotateAngle {//nu este nevoie sa pun public ele sunt by default public abstract
     BufferedImage rotates_with_90();
     BufferedImage rotates_with_180();
     BufferedImage rotates_with_270();
}