package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Program {
    private static char WHITE;
    private static char BLACK;
    private static BufferedImage pic;

    public static void main(String[] args) throws IOException {
        // check
        if (args.length != 3) {
            System.out.println("Wrong count of args");
            System.exit(1);
        }
        // read
        char wh = args[0].charAt(0);
        char bl = args[1].charAt(0);
        String path = args[2];

        pic = ImageIO.read(new File(path));
        int[][] picArray = Logic.ft_read(pic, wh, bl);
        Logic.ft_draw(pic, picArray);
    }
}