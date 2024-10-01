package com.sustav.ALGORITHM.pattern.structural.bridge.video;

public class Main {
    public static void main(String[] args) {
        YoutubeVideo youtubeVideo = new YoutubeVideo(new HDProcessor());
        youtubeVideo.play("fff");

        NetflixVideo netflixVideo = new NetflixVideo(new UHD4KProcessor());
        netflixVideo.play("hhh");
    }
}
