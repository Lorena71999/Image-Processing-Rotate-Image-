import java.awt.image.BufferedImage;

//clasa cu metodele de rotatie
public class ImageToRotate implements RotateAngle {
    private int height;
    private int width;
    private BufferedImage image;

    ImageToRotate(BufferedImage image){
        this.height = image.getHeight();
        this.width = image.getWidth();
        this.image = image;
    }

    //rotire imagine 90 de grade dreapta
    @Override
    public BufferedImage rotates_with_90(){
        //height si width sunt inversate
        BufferedImage rotated_img = new BufferedImage(this.height, this.width, this.image.getType());

        for(int i=0; i<this.height; i++)
            for(int j=0; j<this.width; j++)
                rotated_img.setRGB((this.height - 1)-i, j, image.getRGB(j, i));

        return rotated_img;
    }


    @Override
    //rotire imagine cu 180 de grade
    public BufferedImage rotates_with_180(){
        BufferedImage rotated_img = new BufferedImage(this.width, this.height, this.image.getType());
        //dimensiunile noii imagini raman la fel cu imaginea originala
        for(int i=0; i<this.height; i++)
            for(int j=0; j<this.width; j++)
                rotated_img.setRGB((this.width - 1)-j, (this.height - 1)-i, image.getRGB(j, i));

        return rotated_img;
    }


    @Override
    //rotire imagine cu 270 de grade
    public BufferedImage rotates_with_270(){
        BufferedImage rotated_img = new BufferedImage(this.height, this.width, this.image.getType());
        //height si width sunt inversate la declararea noii imagini deoarece poza rotita isi va inversa dimensiunile

        for(int i=0; i<this.height; i++)
            for(int j=0; j<this.width; j++)
                rotated_img.setRGB(i, (this.width - 1)-j, image.getRGB(j, i));

        return rotated_img;
    }

}