package film;

public class Film {
    private String name;
    private String type;
    private boolean isInStore;

    public Film(String name, String type, boolean isInStore) {
        this.name = name;
        this.type = type;
        this.isInStore = isInStore;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isInStore() {
        return isInStore;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setInStore(boolean inStore) {
        isInStore = inStore;
    }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}
