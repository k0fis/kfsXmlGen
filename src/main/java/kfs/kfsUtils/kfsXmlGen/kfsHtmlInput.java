package kfs.kfsUtils.kfsXmlGen;

/**
 *
 * @author pavedrim
 */
public class kfsHtmlInput extends kfsXmlItem {

    public static final String typeSubmit = "submit";
    public static final String typeText = "text";

    public kfsHtmlInput(String type, String value, String name) {
        super("input");
        setAttr("type", type);
        setAttr("value", value);
        setAttr("name", name);
    }
}
