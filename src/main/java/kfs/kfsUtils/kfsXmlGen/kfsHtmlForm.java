package kfs.kfsUtils.kfsXmlGen;

/**
 *
 * @author pavedrim
 */
public class kfsHtmlForm extends kfsXmlItem {
    
    public enum kfsHtmlFormMethod {
        post, get
    };
        
    public kfsHtmlForm(kfsHtmlFormMethod actionType, String action, String name) {
        super("form");
        if (actionType == kfsHtmlFormMethod.post) {
            addAttribute("method", "post");
        } else
        if (actionType == kfsHtmlFormMethod.get) {
            addAttribute("method", "get");
        }
        if ((action != null) && (action.length() > 0)) {
            addAttribute("action", action);
        }
        if ((name != null) && (name.length() > 0)) {
            addAttribute("name", name);
        }
    }
}
