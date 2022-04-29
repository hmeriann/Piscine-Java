package renderer;

import preprocessor.PreProcessor;

public class RendererStandardImpl implements Renderer {
    private PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void print(String s) {
        System.out.println(preProcessor.process(s));
    }

}
