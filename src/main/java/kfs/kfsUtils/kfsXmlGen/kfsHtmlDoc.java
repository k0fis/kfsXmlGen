package kfs.kfsUtils.kfsXmlGen;


/**
 *
 * @author PaveDrim
 */
public class kfsHtmlDoc extends kfsXmlItem {

    public static final String html40 = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">";
    public static final String scriptTypeJs = "text/javascript";
    //
    public final kfsXmlItem head;
    public final kfsXmlItem body;

    public kfsHtmlDoc(String title) {
        super("html");
        head = new kfsXmlItem("head")//
                .addSubItem("title", title)//                
                .addSubItem(//
                new kfsXmlItem("meta")//
                .addAttribute("http-equiv", "Content-Type").addAttribute("content", "text/html; charset=utf-8"));
        body = new kfsXmlItem("body");
        addSubItem(head);
        addSubItem(body);
    }

    @Override
    public String toString() {
        return (new kfsSb())//
                .anl(html40)//
                .anl(super.toString()) //
                .toString();
    }

    public kfsHtmlDoc setOnLoad(String load) {
        kfsXmlAttr xa = findAttributeByName("onload");
        if (xa != null) {
            xa.setValue(load);
        } else {
            xa = new kfsXmlAttr("onload", load);
            body.addAttribute(xa);
        }
        return this;
    }

    public kfsHtmlDoc addScript( String scriptText) {
        return addScript("text/javascript", scriptText);
    }
    
    /**
     * 
     * @param scriptType
     * @param scriptText
     * @return
     * @deprecated use addScript
     */
    @Deprecated 
    public kfsHtmlDoc addSrcipt(String scriptType, String scriptText) {
        return addScript(scriptType, scriptText);
    }
    public kfsHtmlDoc addScript(String scriptType, String scriptText) {
        kfsXmlItem scr = new kfsXmlItem("script");
        scr.addAttribute("type", scriptType);
        scr.setNoFilterValue(true);
        scr.setValue((new kfsSb()).anl("<!--").anl(scriptText).anl("-->").toString());
        head.addSubItem(scr);
        return this;
    }
    
    public kfsHtmlDoc addScriptRef( String scriptUrl) {
        head.addSubItem(new kfsXmlItem("script")//
                .addAttribute("src", scriptUrl)//
                .addAttribute("language", "javascript")//
                .addAttribute("type", "text/javascript")//
                .setValue(" ")
                );
        return this;
    }

    public kfsHtmlDoc addCssFile(String file) {
        kfsXmlItem css = new kfsXmlItem("link");
        css.addAttribute("rel", "stylesheet");
        css.addAttribute("type", "text/css");
        css.addAttribute("href", file);
        head.addSubItem(css);
        return this;
    }

    public kfsHtmlDoc addHr() {
        body.addSubItem(new kfsXmlItem("hr"));
        return this;
    }
    public kfsHtmlDoc addH(int hInx, String text) {
        body.addSubItem((new kfsXmlItem("h" + Integer.toString(hInx))).setValue(text));
        return this;
    }

    
    public kfsHtmlDoc addBodyItem(kfsXmlItem ... it) {
        body.addSubItemArr(it);
        return this;
    }
    
    /*
    public static void main(String []a) {
    kfsHtmlDoc d = new kfsHtmlDoc("baf");
    d.body.addSubItem("p", "Hi,")//
    .addSubItem("p", "&nbsp;")  
    .addSubItem("p", "There is new report")  
    .addSubItem(new kfsXmlItem("p").addSubItem(//
    new kfsXmlItem("a")//
    .addAttribute("href", "dfdfdf")
    .setValue("fdfdfd")
    ))
    .addSubItem("p", "&nbsp;")  
    .addSubItem("p", "Performance team");
    
    System.err.println(d.toString());
    }
     */
}
