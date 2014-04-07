package kfs.kfsUtils.kfsXmlGen;

/**
 *
 * @author PaveDrim
 */
class kfsName {

    public final String name;

    public kfsName(String name) {
        this.name = getNameFromName(name);
    }
    /*
     public void setName(String name) {
     this.name = getNameFromName(name);
     }
     */

    public String getName() {
        return name;
    }

    public static String getNameFromName(String name) {
        return name.trim().replaceAll("\\s", "_").toLowerCase();
    }

}
