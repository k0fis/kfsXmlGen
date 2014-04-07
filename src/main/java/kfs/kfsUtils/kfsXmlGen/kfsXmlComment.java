package kfs.kfsUtils.kfsXmlGen;


/**
 *
 * @author PaveDrim
 */
public class kfsXmlComment extends kfsContent  implements kfsConvertor<String, String> {

    public kfsXmlComment() {
        super(null, "", false, false);
        setFilter(this);
    }

    public kfsXmlComment(String cmt) {
        this();
        setValue(cmt);
    }

    @Override
    protected String getPrefix() {
        return "<!--";
    }

    @Override
    protected String getPostfix() {
        return "-->";
    }

    @Override
    public String convert(String object) {
        return object.replace("-->", "-- >");
    }

}
