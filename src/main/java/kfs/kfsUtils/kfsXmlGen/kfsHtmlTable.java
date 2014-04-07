package kfs.kfsUtils.kfsXmlGen;

/**
 *
 * @author pavedrim
 */
public class kfsHtmlTable extends kfsXmlItem {
    
    public kfsHtmlTable() {
        super("table");
    }
    
    public kfsHtmlTable addRow(kfsXmlItem ... cells) {
        kfsXmlItem ret = new kfsXmlItem("tr");
        for (kfsXmlItem rr : cells) {
            ret.addSubItem(rr);
        }
        addSubItem(ret);
        return this;
    }
}
