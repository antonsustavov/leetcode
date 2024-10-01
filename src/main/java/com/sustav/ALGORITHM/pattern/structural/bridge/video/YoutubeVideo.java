package com.sustav.ALGORITHM.pattern.structural.bridge.video;

public class YoutubeVideo extends Video {

    public YoutubeVideo(VideoProcessor videoProcessor) {
        super(videoProcessor);
    }

    @Override
    public void play(String videoFile) {
        videoProcessor.process(videoFile);
    }
}
