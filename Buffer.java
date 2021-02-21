import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Semaphore;

public class Buffer {// pentru comunicarea celor dou fire de executie am creat clasa Buffer ce contine 2 metode(put() si get()) sincronizate
    private int partialSize;
    private  int size;
    private  InputStream finalInputStream;
    private byte[] array;
    public  byte[] imgg;//aici pun imaginea finala
    private boolean ok = false;
    int index = 0;

    public Buffer(int partialSize, int size, InputStream inputStram) {
        this.partialSize = partialSize;
        this.size = size;
        array = new byte[partialSize];
        imgg = new byte[size];
        finalInputStream = inputStram;
    }

    public synchronized void get() {
        while (!ok) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        for (int j = 0; j < partialSize; j++) {
            imgg[index++] = array[j];
        }
        ok = false;
        notifyAll();

    }



    public synchronized void put() throws IOException {
        while (ok) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        finalInputStream.read(array);
        ok = true;
        notifyAll();

    }
}