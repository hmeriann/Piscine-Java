package renderer;

import preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {

    private PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void print(String s) {
        System.err.println(preProcessor.process(s));
    }
}
