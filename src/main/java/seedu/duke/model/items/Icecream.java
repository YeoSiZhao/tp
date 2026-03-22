package seedu.duke.model.items;

import seedu.duke.model.Item;


public class Icecream extends Item {
    private String flavour;
    private boolean isDairyFree;

    public Icecream(String name, int quantity, String binLocation,
                    String expiryDate, String flavour, boolean isDairyFree) {
        super(name, quantity, binLocation, expiryDate);
        this.flavour = flavour;
        this.isDairyFree = isDairyFree;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public boolean isDairyFree() {
        return isDairyFree;
    }

    public void setDairyFree(boolean isDairyFree) {
        this.isDairyFree = isDairyFree;
    }

    @Override
    public String toString() {
        return "[IceCream] " + super.toString()
                + ", Flavour: " + flavour
                + ", DairyFree: " + isDairyFree;
    }
}
