package me.muawb.project.sound;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.InputStream;

public class Turntable implements AutoCloseable{

    private static final Logger log = LoggerFactory.getLogger(Turntable.class);

    private boolean ch = false;
    private Player pl;

    public Turntable(String path){
        log.info("initializing");
        try {
            InputStream in = this.getClass().getResourceAsStream(path);
            pl = new Player(in);
            ch = true;
        } catch (Exception e){
            e.printStackTrace();
            ch = false;
        }
    }

    public void play() throws JavaLayerException {
        pl.play();
        log.info("Run the audio file");
    }

    public boolean isActive(){
        return ch;
    }

    @Override
    public void close() throws Exception {
        if (pl != null | pl == null){
            pl.close();
        }
    }
}
