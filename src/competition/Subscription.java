package competition;

public class Subscription {
    int id;
    Athlete athlete;
    int tax;

    public Subscription(int id, Athlete athlete) {
        this.id = id;
        this.athlete = athlete;
    }

    public int getId() {
        return id;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getTax() {
        return tax;
    }

    public Athlete getAthlete() {
        return athlete;
    }
}
