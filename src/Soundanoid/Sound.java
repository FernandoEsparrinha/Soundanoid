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
    public static final AudioClip RACQUET = Applet.newAudioClip(Sound.class.getResource("woosh.wav"));
    public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("game_over.wav"));
    
}
