package kfs.kfsUtils.kfsXmlGen;

/**
 *
 * @author PaveDrim
 */
public class kfsXmlItemList extends kfsXmlItem {
    private final String itemName;

    public kfsXmlItemList(String listName, String itemName) {
        super(listName);
        this.itemName = itemName;
    }

    public kfsXmlItem createNewItem() {
        kfsXmlItem xi = new kfsXmlItem(itemName);
        this.addSubItem(xi);
        return xi;
    }
}
