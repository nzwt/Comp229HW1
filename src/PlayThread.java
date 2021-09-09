
import java.io.FileInputStream;

import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 * Do not modify this file.
 * @author celiachen
 *
 */
public class PlayThread implements Runnable {
    public String song;
    
    public PlayThread(String song) {
        this.song = song;
    }
    public void run() {
        try{
            FileInputStream fis = new FileInputStream(song);
            AdvancedPlayer p = new AdvancedPlayer(fis);
            p.play();
        } catch(Exception e){}
        //MP3Player.doneSong();
    }
    
}