package me.muawb.project.sound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class let plays music, and short audio files.
 * File format need would only mp3.
 * Implements functional interface a AutoClosable,
 * which have one method {@link AutoCloseable#close()}.
 */

public class MusicPlayer implements AutoCloseable, Audio {

    //Include is logging in thish class.
    private static final Logger log = LoggerFactory.getLogger(MusicPlayer.class);
    //Path to audio file which located in folder a resources.
    private static final String MUSIC_VAVILOV = "/sound/vavilov.wav";

    //Represent references of this class.
    private static MusicPlayer player;
    //Enable create stream for input audio file.
    private static AudioInputStream audioInput;
    //Clip is manage of audio file.
    private static Clip playAudio;
    //FloatControl let set a volume.
    private static FloatControl controlAudio;

    //Determine, invoked method init or not.
    private static boolean released;
    //Determine, been play is sound or not.
    private static boolean playing;

    public MusicPlayer(){

    }

    /**
     * Here initializing of object and set few is configuration.
     *
     * @return
     *      created object it is class.
     */

    public static MusicPlayer init(){
        player = new MusicPlayer();
        try {
            log.info("Create object...");
            //Read stream of resources folder.
            InputStream in = MusicPlayer.class.getResourceAsStream(MUSIC_VAVILOV);
            //Set marker.
            InputStream bufferedIn = new BufferedInputStream(in);
            //Receive stream.
            audioInput = AudioSystem.getAudioInputStream(bufferedIn);
            playAudio = AudioSystem.getClip();
            playAudio.open(audioInput);

            log.info("Object created complete.");
            released = true;
        } catch (Exception e){
            log.error("Play is music file of complete error." , e);
            released = false;
            player.close();
        }
        return player;
    }

    /**
     * Allow increase or decrease volume for sound.
     * @param volume
     *          value
     */

    @Override
    public void setVolume(float volume) {
        controlAudio = (FloatControl) playAudio.getControl(FloatControl.Type.MASTER_GAIN);
        controlAudio.setValue(volume);

    }

    @Override
    public void play() {
        play(true);
    }

    /**
     * Play sound after invoked is method {@link #init()}.
     *
     * @param act
     *      determine play sound or not.
     */

    @Override
    public void play(boolean act) {
        //If object created.
        if (released){
            //If act equals true.
            if (act){
                playAudio.stop();
                //Set position audio line onto start.
                playAudio.setFramePosition(0);
                playAudio.start();
                playing = true;
            } else if (!isActive()){
                //If sound not active, start sound.
                playAudio.start();
                playAudio.setFramePosition(0);
                playing = true;
            }
        }
    }

    /**
     * Make do entry in audio file.
     * Invoked after call {@link #play()} or {@link #play(boolean)} method.
     */

    @Override
    public void join() {
        //If initializing not pass, exit out.
        if (!released == true){
            return;
        }
        try {
            Thread.sleep(playAudio.getMicrosecondLength() / 1000);
        } catch (InterruptedException e){
            log.debug("Sleep is current thread complete with error", e);
        }

    }

    /**
     * Inform, active sound or not.
     * @return
     *      true or false.
     */

    @Override
    public boolean isActive() {
        return released;
    }

    /**
     * Stop playing of sound.
     */

    @Override
    public void stop(){
        //If active, stop it.
        if (playing){
            playAudio.stop();
        }
    }

    /**
     * Only method from functionality interface {@link AutoCloseable}.
     * This method close stream which uses it class.
     */

    @Override
    public void close() {
        try {
            if (playAudio != null){
                playAudio.close();
                log.debug("Clip close.");
            }

            if (audioInput != null){
                audioInput.close();
                log.debug("AudioInputStream close.");
            }
        } catch (IOException e){
            log.error("MusicPlayer: ", "Can't stop play sound !");
        }
    }
}
