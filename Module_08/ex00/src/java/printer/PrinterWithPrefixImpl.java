package printer;

import renderer.Renderer;
import renderer.RendererErrImpl;

public class PrinterWithPrefixImpl implements Printer {
    private String prefix;
    private Renderer renderer;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.prefix = "";
        this.renderer = renderer;
    }

    public void  setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void print(String text) {
        renderer.print(this.prefix + text);
    }
}
