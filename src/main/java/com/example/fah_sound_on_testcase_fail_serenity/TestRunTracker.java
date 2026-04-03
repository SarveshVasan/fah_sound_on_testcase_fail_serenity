package com.example.fah_sound_on_testcase_fail_serenity;

import com.intellij.execution.ExecutionListener;
import com.intellij.execution.ExecutionManager;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.application.ApplicationActivationListener;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class TestRunTracker implements ApplicationActivationListener {

    public TestRunTracker() {
        System.out.println("🚀 TRACKER CONSTRUCTOR CALLED 🚀");

        // Hook globally once plugin loads
        com.intellij.openapi.application.ApplicationManager.getApplication()
                .getMessageBus()
                .connect()
                .subscribe(
                        ExecutionManager.EXECUTION_TOPIC,
                        new ExecutionListener() {
                            @Override
                            public void processTerminated(@NotNull String executorId,
                                                          @NotNull ExecutionEnvironment env,
                                                          @NotNull ProcessHandler handler,
                                                          int exitCode) {

                                System.out.println("EXIT CODE: " + exitCode);

                                if (exitCode != 0) {
                                    System.out.println("🔥 FAILURE DETECTED 🔥");
                                    SoundPlayer.playFailSound();
                                }
                            }
                        }
                );
    }
}