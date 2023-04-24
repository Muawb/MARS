package me.muawb.project.sound;

public interface Audio {

    void setVolume(float volume);

    void play();

    void play(boolean act);

    void join();

    boolean isActive();

    void stop();

}
