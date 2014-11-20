/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soundanoid;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 *
 * @author fernando
 */
public class Sound {
    public static final AudioClip RACQUET = Applet.newAudioClip(Sound.class.getResource("sound/woosh.wav"));
    public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("sound/game_over.wav"));
    public static final AudioClip WALL_LEFT = Applet.newAudioClip(Sound.class.getResource("sound/blop.wav"));
    public static final AudioClip BACKGROUND1 = Applet.newAudioClip(Sound.class.getResource("sound/background.wav"));
    public static final AudioClip BACKGROUND2 = Applet.newAudioClip(Sound.class.getResource("sound/hammer.wav"));
    public static final AudioClip WALL_TOP = Applet.newAudioClip(Sound.class.getResource("sound/slap.wav"));
    public static final AudioClip WALL_RIGHT = Applet.newAudioClip(Sound.class.getResource("sound/pin.wav"));
    public static final AudioClip BLOCK1 = Applet.newAudioClip(Sound.class.getResource("sound/block1.wav"));
    public static final AudioClip BLOCK2 = Applet.newAudioClip(Sound.class.getResource("sound/block2.wav"));
    public static final AudioClip BLOCK3 = Applet.newAudioClip(Sound.class.getResource("sound/block3.wav"));
    public static final AudioClip BLOCK4 = Applet.newAudioClip(Sound.class.getResource("sound/block4.wav"));
    public static final AudioClip BLOCK5 = Applet.newAudioClip(Sound.class.getResource("sound/block5.wav"));
 
    
    public static void stopSounds(){
        Sound.RACQUET.stop();
        Sound.WALL_LEFT.stop();
        Sound.WALL_RIGHT.stop();
        Sound.WALL_TOP.stop();
        Sound.BACKGROUND1.stop();
        Sound.BACKGROUND2.stop();
    }
    
}
