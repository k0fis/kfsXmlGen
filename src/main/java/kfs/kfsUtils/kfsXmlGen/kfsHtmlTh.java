package kfs.kfsUtils.kfsXmlGen;

/**
 *
 * @author pavedrim
 */
public class kfsHtmlTh extends kfsXmlItem {

    public kfsHtmlTh(String content) {
        super("th");
        setValue(content);
    }

    public kfsHtmlTh setColSpan(int colspan) {
        setAttr("colspan", Integer.toString(colspan));
        return this;
    }
    public kfsHtmlTh setStyle(String style) {
        setAttr("style", style);
        return this;
    }
    public kfsHtmlTh setClass(String cls) {
        setAttr("class", cls);
        return this;
    }
}
