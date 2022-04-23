package edu.school21.printer.logic;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Logic {
     BColor col;
     ColoredPrinter coloredPrinter = new ColoredPrinter.Builder(1, false).build();

    public static void ft_draw(BufferedImage pic, int[][] picArray) {
        try {
            BufferedImage picture = ImageIO.read("/resources/it.bmp");
            for (int x = 0; x < pic.getWidth(); x++) {
                for (int y = 0; y < pic.getHeight(); y++) {
                    Color color = new Color(picture.getRGB(x,y));
                    int red = color.getRed();
                    if (red == 0)
                        color = Ansi.BColor.valueOf(black);
                    else
                        color = Ansi.BColor.valueOf(white);
                    coloredPrinter.print(" ", Attribute.NONE, FColor.NONE, color);
//                    System.out.print((char) picArray[y][x]);
                }
//                System.out.print("\n");
                coloredPrinter.print("", Attribute.NONE, FColor.NONE, BColor.NONE);
            }
        } catch (IllegalArgumentException e) {
            coloredPrinter.print("", Attribute.NONE, FColor.NONE, BColor.NONE);
            System.out.println("Invalid color");
        } catch (IOException exception) {
            System.out.println("No picture");
            System.exit(1);
        }
    }
}
