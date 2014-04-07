package kfs.kfsUtils.kfsXmlGen;

/**
 *
 * @author PaveDrim
 */
public class kfsXmlAttr extends kfsName {

    private String value;

    public kfsXmlAttr(String name) {
        this(name, "");
    }

    public kfsXmlAttr(String name, String value) {
        super(name);
        this.value = value;
    }

    public kfsXmlAttr setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return (new kfsSb())//
                .a(" ", getName(), "=\"", value, "\"")
                .toString();
    }
}
