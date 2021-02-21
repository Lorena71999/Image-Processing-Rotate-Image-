import java.io.IOException;

public class Producer extends Thread {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                buffer.put();
            } catch (IOException e) {
                    e.printStackTrace();
            }
            System.out.println("Producatorul a  citit:\t" + i + "-parte !");
            try{
                sleep((int)(Math.random() * 1000));

            }catch ( InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }
}