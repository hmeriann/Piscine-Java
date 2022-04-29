package preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    @Override
    public String process(String s) {
        return s.toUpperCase();
    }
}
