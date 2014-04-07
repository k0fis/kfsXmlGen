package kfs.kfsUtils.kfsXmlGen;

/**
 *
 * @author pavedrim
 */
public class kfsXmlAttrNonPair extends kfsXmlAttr{
    public kfsXmlAttrNonPair(String name) {
        super(name, "");
    }

    @Override
    public String toString() {
        return " "+name;
    }
    
}
