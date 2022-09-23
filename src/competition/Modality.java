package competition;

import java.util.HashMap;

public class Modality {
    private String name;
    private int underAgeTax;
    private int tax;
    private int minAge;
    private HashMap<String, Subscription> subscriptions;

    public Modality(String name, int underAgeTax, int tax) {
        this.name = name;
        this.minAge = 0;
        this.underAgeTax = underAgeTax;
        this.tax = tax;
        this.subscriptions = new HashMap<>();
    }

    public int getMinAge() {
        return minAge;
    }

    public Modality(String name, int minAge, int underAgeTax, int tax) {
        this.name = name;
        this.minAge = minAge;
        this.underAgeTax = underAgeTax;
        this.tax = tax;
        this.subscriptions = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Subscription getSubscriptionById(String id){
        return this.subscriptions.get(id);
    }

    public HashMap<String, Subscription> getSubscriptions() {
        return subscriptions;
    }

    public Subscription addAthlete(int id, Athlete athlete){
        Subscription newSubscription = new Subscription(id, athlete);
        int calculateTax = athlete.getAge() >= 18 ? this.tax : this.underAgeTax;
        newSubscription.setTax(calculateTax);
        this.subscriptions.put(athlete.getRg(), newSubscription);

        return newSubscription;
    }

    public Subscription removeAthlete(String rg) {
        return this.subscriptions.remove(rg);
    }
}
