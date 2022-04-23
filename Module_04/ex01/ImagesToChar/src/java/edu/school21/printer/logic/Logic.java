package edu.school21.printer.logic;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Logic {


    public static void ft_draw(BufferedImage pic, int[][] picArray) {
        for (int x = 0; x < pic.getWidth(); x++) {
            for (int y = 0; y < pic.getHeight(); y++) {
                System.out.print((char)picArray[y][x]);
            }
            System.out.print("\n");
        }
    }

    public static int[][] ft_read(BufferedImage pic, char wh, char bl) {
        int[][] picArray = new int[pic.getWidth()][pic.getHeight()];

        for (int x = 0; x < pic.getWidth(); x++) {
            for (int y = 0; y < pic.getHeight(); y++) {
                int color = pic.getRGB(x, y);
                if (color == Color.BLACK.getRGB())
                    picArray[x][y] = bl;
                else if (color == Color.WHITE.getRGB())
                    picArray[x][y] = wh;
                else {
                    System.out.println("Wrong color in the .bmp file");
                    System.exit(1);
                }
            }
        }
        return picArray;
    }
}
