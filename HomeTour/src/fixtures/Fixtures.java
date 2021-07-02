package src.fixtures;

public abstract class Fixtures {
    private String name;
    private String shortDesc;
    private String longDesc;

    public Fixtures() {

    }

    public Fixtures(String name, String shortDesc, String longDesc) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSD() {
        return shortDesc;
    }

    public void setSD(String shortDes) {
        this.shortDesc = shortDesc;
    }

    public String getLD() {
        return longDesc;
    }

    public void setLD(String longDesc) {
        this.longDesc = longDesc;
    }

}
