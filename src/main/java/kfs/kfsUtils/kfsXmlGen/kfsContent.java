package kfs.kfsUtils.kfsXmlGen;


/**
 *
 * @author PaveDrim
 */
class kfsContent implements kfsConvertor<String, String> {

    private String value;
    private boolean noFormatValue;
    private boolean noFilterValue;
    private kfsConvertor<String, String> filter;

    public kfsContent(kfsConvertor<String, String> filter) {
        this(filter, "", false, false);
    }

    public kfsContent(kfsConvertor<String, String> filter, String value) {
        this(filter, value, false, false);
    }

    public kfsContent(kfsConvertor<String, String> filter, String value, boolean noFormatValue, boolean noFilterValue) {
        this.filter = filter != null ? filter : this;
        this.noFormatValue = noFormatValue;
        this.value = filter.convert(value != null ? value : "");
        this.noFilterValue = noFilterValue;
    }

    public int getValueLength() {
        return (value == null) ? 0 : value.length();
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        if (noFilterValue) {
            this.value = value;
        } else {
            this.value = filter.convert(value != null ? value : "");
        }
    }

    /**
     * @return the noFormatValue
     */
    public boolean isNoFormatValue() {
        return noFormatValue;
    }

    /**
     * @param noFormatValue the noFormatValue to set
     */
    public void setNoFormatValue(boolean noFormatValue) {
        this.noFormatValue = noFormatValue;
    }

    protected void setFilter(kfsConvertor<String, String> filter) {
        this.filter = filter;
    }

    /**
     * @return the filter
     */
    public kfsConvertor<String, String> getFilter() {
        return filter;
    }

    /*
     * idempotent
     */
    @Override
    public String convert(String object) {
        return object;
    }

    protected String getPrefix() {
        return "";
    }

    protected String getPostfix() {
        return "";
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(int inx) {
        return kfsXmlItem.setIndent(!noFormatValue, new kfsSb(), inx)//
                .a(getPrefix(), getValue(), getPostfix())//
                .toString();
    }

    public boolean isNoFilterValue() {
        return noFilterValue;
    }

    public void setNoFilterValue(boolean noFilterValue) {
        this.noFilterValue = noFilterValue;
    }
}
