package com.sustav.ALGORITHM.pattern.structural.bridge.video;

public abstract class Video {

    protected VideoProcessor videoProcessor;

    public Video(VideoProcessor videoProcessor) {
        this.videoProcessor = videoProcessor;
    }

    public abstract void play(String videoFile);
}
