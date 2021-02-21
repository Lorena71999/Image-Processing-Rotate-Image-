import java.io.IOException;

public class Consumer extends Thread {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        for (int i = 0; i < 4; i++) {
            buffer.get();
            System.out.println("Consumatorul a primit partea de informatie!\t");
            try{
                sleep((int)(Math.random() * 1000));

            }catch ( InterruptedException e) {
                   e.printStackTrace();
            }
        }
    }
}