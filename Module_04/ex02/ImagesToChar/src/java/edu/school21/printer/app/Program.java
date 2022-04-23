package edu.school21.printer.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import edu.school21.printer.logic.Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Program {

    private static BufferedImage pic;

    @Parameter(names={"--white="})
    char wh;
    @Parameter(names={"--black="})
    char bl;

    public static void main(String[] args) throws IOException {
        Program program = new Program();

        try {
            JCommander.newBuilder().addObject(program).build().parse(args);
            program.run();
        } catch (ParameterException e) {
            System.err.println("Error arguments\nUsage: --white=<COLOR> --black=<COLOR>");
            System.exit(1);
        }
    }

    public void run() {
        Logic logic = new Logic();
        if (wh == null || bl == null) {
            System.err.println("Please add color parameters");
            System.exit(1);
        }
        logic.ft_read(pic, wh, bl);
        logic.ft_draw(pic, Program.class.getResource("/resources/it.bmp"));
    }
}