package com.example.fah_sound_on_testcase_fail_serenity;

import javax.sound.sampled.*;
import java.net.URL;

public class SoundPlayer {

    public static void playFailSound() {
        try {
            URL soundUrl = SoundPlayer.class.getResource("/fahhhhh.wav");

            if (soundUrl == null) {
                System.out.println("❌ SOUND FILE NOT FOUND");
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundUrl);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.println("🔊 FAAHHH PLAYING 🔊");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}