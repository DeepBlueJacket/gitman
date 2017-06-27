package game.input;
import game.entity.Entity;
import game.inpuRawConsoleInput;
import java.io.*;

public class Input {
    private static int omitTheSameKeyCounter=0;
    private static RawConsoleInput in = new RawConsoleInput();;
    private static char lastKey;
    private static long elapsedTimeBetweenKeys;// contador de tiempo entre teclas
    private static final int WAIT_PER_KEY = 20;//intervalo de tiempo entre teclas
    private static final int TIMES_OMITTED_THE_SAME_KEY = 2;
    public static final char DEFAULT_KEY = 'f';

    public static char getKey() {
        char key = DEFAULT_KEY;
        if( (System.currentTimeMillis() - elapsedTimeBetweenKeys) >
            WAIT_PER_KEY)
        {
            key = read();
            elapsedTimeBetweenKeys = System.currentTimeMillis();
        }
        return key;
    }

    private static boolean isTheSameKey(char newKey) {
        if( (lastKey != newKey) ||
           (omitTheSameKeyCounter > TIMES_OMITTED_THE_SAME_KEY) )
        {
            lastKey = newKey;
            omitTheSameKeyCounter = 0;
            return false;
        }
        else{
            omitTheSameKeyCounter++;
            return true;
        }
    }

    private static char read() {
        char key = DEFAULT_KEY;
        try {
            key = (char)in.read(false);
            if(isTheSameKey(key))
                key = DEFAULT_KEY;
        } catch(IOException ex) {

        } finally {
            return key;
        }
    }
}
