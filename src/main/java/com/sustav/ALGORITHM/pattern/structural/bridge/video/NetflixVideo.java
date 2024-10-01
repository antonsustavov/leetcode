package com.sustav.ALGORITHM.pattern.structural.bridge.video;

public class NetflixVideo extends Video {

    public NetflixVideo(VideoProcessor videoProcessor) {
        super(videoProcessor);
    }

    @Override
    public void play(String videoFile) {
        videoProcessor.process(videoFile);
    }
}
