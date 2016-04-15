/*
* Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik
* der Landeshauptstadt München, 2015
*/
package de.cbb;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author martin.dietrich
 * erster commit nach stash
 */
public class Teatime {
    
    public static String WAV = "Sci Fi Robot-SoundBible.com-481033379.wav";
        
    public static void main(String[] args) throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
        
        if (args.length>0 && !args[0].isEmpty())
            WAV=args[0];
        
        System.out.println("Enter min:");
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line = r.readLine();
        int min = Integer.parseInt(line);
        Thread.sleep(min * 1000 * 60);
        
        play2();
        
        System.out.println("FIN");
    }
    
    private static void play2() {
        try {
            File yourFile = new File(System.getProperty("user.home")+"\\"+WAV);
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;
            
            stream = AudioSystem.getAudioInputStream(yourFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            System.out.println(info.getFormats()[0].toString());
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
            System.out.println("started");
        while(clip.isActive())
            Thread.sleep(10);
        }
        catch (Exception e) {
            //whatevers
        }
    }
    
    
}
