package kfs.kfsUtils.kfsXmlGen;

import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author PaveDrim
 */
public class kfsXmlDoc extends kfsXmlItem implements Iterable<kfsXmlDocDef> {

    private final ArrayList<kfsXmlDocDef> defs;

    public kfsXmlDoc(String name) {
        super(name);
        defs = new ArrayList<kfsXmlDocDef>();
        addDocAttr("xml", "encoding", "UTF-8", "version", "1.0");
    }

    public final kfsXmlDoc addDocAttr(String attrName, String a1Name, //
            String a1Value, String a2Name, String a2Value) {
        for (kfsXmlDocDef dd : defs) {
            if (dd.getName().equals(attrName)) {
                dd.setAttribute(a1Name, a1Value);
                dd.setAttribute(a2Name, a2Value);
                return this;
            }
        }
        defs.add((new kfsXmlDocDef(attrName))//
                .addAttribute(a1Name, a1Value)//
                .addAttribute(a2Name, a2Value)//
                );
        return this;
    }

    public kfsXmlDoc addStylesheet(String href) {
        return addDocAttr("xml-stylesheet", "type", "text/xsl", "href", href);
    }

    @Override
    public String toString() {
        return (new kfsSb())//
                .aIter(defs, kfsSb.nl).nl(defs.size() <= 1).a(super.toString())//
                .toString();
    }

    @Override
    public Iterator<kfsXmlDocDef> iterator() {
        return defs.iterator();
    }


}
