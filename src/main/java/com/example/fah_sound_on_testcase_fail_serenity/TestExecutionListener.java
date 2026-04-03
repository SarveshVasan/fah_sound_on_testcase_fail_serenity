package com.example.fah_sound_on_testcase_fail_serenity;

import com.intellij.execution.ExecutionListener;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import org.jetbrains.annotations.NotNull;

public class TestExecutionListener implements ExecutionListener {

    @Override
    public void processTerminated(@NotNull String executorId,
                                  @NotNull ExecutionEnvironment env,
                                  @NotNull ProcessHandler handler,
                                  int exitCode) {

        System.out.println("PROCESS TERMINATED: " + exitCode);

        if (exitCode != 0) {
            System.out.println("🔥 TEST FAILURE DETECTED 🔥");
            SoundPlayer.playFailSound();
        }
    }
}