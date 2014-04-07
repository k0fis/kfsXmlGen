package kfs.kfsUtils.kfsXmlGen;

import java.util.ArrayList;


/**
 *
 * @author PaveDrim
 */
public class kfsXmlDocDef extends kfsName{

    private final ArrayList<kfsXmlAttr> attrs;

    public kfsXmlDocDef(String name) {
        super(name);
        attrs = new ArrayList<kfsXmlAttr>();
    }

    public Iterable<kfsXmlAttr> attributes() {
        return attrs;
    }

    public kfsXmlDocDef addAttribute(kfsXmlAttr ai) {
        attrs.add(ai);
        return this;
    }

    public kfsXmlDocDef addAttribute(String name, String value) {
        return addAttribute(new kfsXmlAttr(name, value));
    }

    public kfsXmlDocDef setAttribute(String name, String value) {
        for (kfsXmlAttr a : attrs) {
            if (a.getName().equals(name)) {
                a.setValue(value);
                return this;
            }
        }
        return addAttribute(new kfsXmlAttr(name, value));
    }


    @Override
    public String toString() {
        return (new kfsSb())//
                .a("<?", getName())//
                .aIter(attrs, " ")
                .a("?>")
                .toString();
    }

}
