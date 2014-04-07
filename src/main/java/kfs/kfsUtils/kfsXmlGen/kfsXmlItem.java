package kfs.kfsUtils.kfsXmlGen;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author PaveDrim
 */
public class kfsXmlItem extends kfsName implements kfsConvertor<String, String>,//
        kfsGetXml {

    private final kfsContent value;
    private final ArrayList<kfsXmlAttr> attrList = new ArrayList<kfsXmlAttr>();
    private final ArrayList<kfsXmlItem> subItems = new ArrayList<kfsXmlItem>();
    private final ArrayList<kfsXmlComment> helpLine = new ArrayList<kfsXmlComment>();

    public kfsXmlItem(String name) {
        super(name);
        value = new kfsContent(this, "", false, false);
    }

    public Iterable<kfsXmlAttr> attributes() {
        return attrList;
    }

    public String getValue() {
        return value.getValue();
    }

    public kfsXmlItem setValue(String value) {
        this.value.setValue(value);
        return this;
    }

    public boolean isNoFilterValue() {
        return this.value.isNoFilterValue();
    }

    public void setNoFilterValue(boolean noFilterValue) {
        this.value.setNoFilterValue(noFilterValue);
    }
    
    public kfsXmlItem setNoFormatValue(boolean value) {
        this.value.setNoFormatValue(value);
        return this;
    }

    public Iterable<kfsXmlItem> subItems() {
        return subItems;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    private String getEnd() {
        String n = getName();
        return (n.equalsIgnoreCase("link") ||//
                n.equalsIgnoreCase("meta")  //
                )?"":" /";
    }
    
    public String toString(int inx) {
        kfsSb sb = new kfsSb();

        for (kfsXmlComment line : helpLine) {
            sb.anl(line.toString(inx));
        }

        setIndent(true, sb, inx)//
                .a("<", getName())//
                .aIter(attrList, "")//
                .ad((subItems.size() <= 0) && (value.getValueLength() <= 0), getEnd())//
                .a(">");
        if (subItems.size() > 0) {
            sb.nl();
            for (kfsXmlItem su : subItems) {
                sb.anl(su.toString(inx + 1));
            }
        }

        if (value.getValueLength() > 0) {
            setIndent(subItems.size() > 0 && //
                    !value.isNoFormatValue(), sb, inx + 1).a(value);
        }

        if (subItems.size() > 0) {
            if (value.getValueLength() > 0) {
                sb.nl();
            }
            setIndent(true, sb, inx).a("</", getName(), ">");
        } else {
            sb.ad(value.getValueLength() > 0, "</", getName(), ">");
        }

        return sb.toString();
    }

    public kfsXmlItem addSubItem(String name, String value) {
        subItems.add(new kfsXmlItem(name).setValue(value));
        return this;
    }

    public kfsXmlItem addSubItemLst(Iterable<? extends kfsXmlItem> iters) {
        for (kfsXmlItem gx : iters) {
            subItems.add(gx);
        }
        return this;
    }

    public kfsXmlItem addSubItemArr( kfsXmlItem ... iters) {
        subItems.addAll(Arrays.asList(iters));
        return this;
    }

    public kfsXmlItem addSubItem(Iterable<? extends kfsGetXml> iters) {
        for (kfsGetXml gx : iters) {
            subItems.add(gx.getXml());
        }
        return this;
    }

    public kfsXmlItem addSubItem(kfsXmlItem sui) {
        subItems.add(sui);
        return this;
    }

    public kfsXmlItem addAttribute(kfsXmlAttr ai) {
        attrList.add(ai);
        return this;
    }

    public kfsXmlItem addAttribute(String name) {
        return addAttribute(new kfsXmlAttrNonPair(name));
    }
    
    public kfsXmlItem addAttribute(String name, String value) {
        return addAttribute(new kfsXmlAttr(name, value));
    }

    public kfsXmlItem addAttribute(boolean reallyAdd, String name, String value) {
        if (reallyAdd) {
            return addAttribute(new kfsXmlAttr(name, value));
        }
        return this;
    }
    
    public kfsXmlAttr findAttributeByName(String name) {
        for (kfsXmlAttr xa : attrList) {
            if (xa.name.equalsIgnoreCase(name)) {
                return xa;
            }
        }
        return null;
    }

    public kfsXmlItem setAttr(String name, String val) {
         kfsXmlAttr xa = findAttributeByName(name);
        if (xa != null) {
            xa.setValue(val);
        } else {
            this.addAttribute(new kfsXmlAttr(name, val));
        }
        return this;
    }
    
    public Iterable<kfsXmlComment> helpLines() {
        return helpLine;
    }

    public kfsXmlItem addHelpLine(String line) {
        helpLine.add(new kfsXmlComment(line));
        return this;
    }

    @Override
    public String convert(String object) {
        return object.replace("<", "&lt;").replace(">", "&gt;");
    }

    public static kfsSb setIndent(boolean really, kfsSb sb, int inx) {
        if (!really) {
            return sb;
        }
        return sb.aTimes(inx, "  ", "");
    }

    @Override
    public kfsXmlItem getXml() {
        return this;
    }
}
