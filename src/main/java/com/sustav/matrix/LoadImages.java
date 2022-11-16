package com.sustav.matrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadImages {
    public static void main(String[] args) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("stars2.png");

        BufferedImage img = ImageIO.read(is);

        int[][] matrixOfImage = getMatrixOfImage(img);
        Color[][] matrixOfImage2 = getMatrixOfImage2(img);


    }

    public static int[][] getMatrixOfImage(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        int[][] pixels = new int[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x][y] = bufferedImage.getRGB(x, y);
            }
        }

        return pixels;
    }

    public static Color[][] getMatrixOfImage2(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        Color[][] pixels = new Color[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x][y] = new Color(bufferedImage.getRGB(x, y));
            }
        }

        return pixels;
    }
}
