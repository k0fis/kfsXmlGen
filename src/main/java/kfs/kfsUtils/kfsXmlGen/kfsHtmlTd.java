package kfs.kfsUtils.kfsXmlGen;

/**
 *
 * @author pavedrim
 */
public class kfsHtmlTd extends kfsXmlItem {

    public kfsHtmlTd() {
        super("td");
    }

    public kfsHtmlTd setSpace() {
        setValue("&nbsp;");
        return this;
    }
    
    public kfsHtmlTd(String content) {
        this();
        setValue(content);
    }

    public kfsHtmlTd setPreContent(String content) {
        this.setNoFilterValue(true);
        this.setValue((new kfsXmlItem("pre")).setValue(content).toString());
        return this;
    }
    public kfsHtmlTd setColSpan(int colspan) {
        setAttr("colspan", Integer.toString(colspan));
        return this;
    }

    public kfsHtmlTd setStyle(String style) {
        setAttr("style", style);
        return this;
    }

    public kfsHtmlTd setClass(String cls) {
        setAttr("class", cls);
        return this;
    }    
}
