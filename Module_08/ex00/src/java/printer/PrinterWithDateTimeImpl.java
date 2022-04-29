package printer;

import renderer.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {
    private Renderer renderer;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void print(String s) {
        renderer.print(LocalDateTime.now() + s);
    }
}
