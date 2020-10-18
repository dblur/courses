public Label checkLabels(TextAnalyzer[] analyzers, String text) {
    for (TextAnalyzer t_check: analyzers){
        Label result = t_check.processText(text);
        if (!result.equals(Label.OK)){
    return result;
        }
    }
    return Label.OK;
}

    public abstract class KeywordAnalyzer implements TextAnalyzer {
        abstract protected String[] getKeywords();
	    abstract protected Label getLabel();
	    
	    public Label processText(String text) {
	        String[] keywords = getKeywords();
            
	        for (int i = 0; i < keywords.length; i++) {
	            if (text.contains(keywords[i])) {
	                return getLabel();
	            }
	        }
	        return Label.OK;
	    }
	}

public class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;
    private Label label = Label.SPAM;
    
    public SpamAnalyzer(String[] keywords){
        this.keywords = keywords;
    }
    protected String[] getKeywords(){
        return keywords;
    }
    protected Label getLabel(){
        return label;
    }
}

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private String[] keywords = new String[] {":(","=(",":|"};
    private Label label = Label.NEGATIVE_TEXT;
    
    protected String[] getKeywords(){
        return keywords;
    }
    protected Label getLabel(){
        return label;
    }
}

public class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;
    private Label label = Label.TOO_LONG;
    
    public TooLongTextAnalyzer(int length){
        this.maxLength = length;
    }
    
    public Label processText(String text){
        if (text.length() > maxLength){
            return label;
        }
   
        return Label.OK;
    }
}
