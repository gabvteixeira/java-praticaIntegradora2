package competition;

import java.util.HashMap;

public class Competition {
    private HashMap<String, Modality> modalities;
    private int athleteCount;

    public Competition() {
        this.modalities = new HashMap<>();
        this.athleteCount = 0;
    }

    public Competition(HashMap<String, Modality> modalities, int athleteCount) {
        this.modalities = modalities;
        this.athleteCount = athleteCount;
    }

    public boolean addModality(Modality modality) {
        if(this.modalities.get(modality.getName()) != null){
            return false;
        }

        this.modalities.put(modality.getName(), modality);
        return true;
    }

    public boolean addAthlete(Athlete athlete, String modalityName) {
        Modality modality = this.modalities.get(modalityName);
        if(modality != null &&
                modality.getSubscriptionById(athlete.getRg()) == null){

            if(athlete.getAge() < modality.getMinAge()){
                System.out.println("O atleta não possui a idade mínima para a categoria");
                return false;
            }

            Subscription newSubscription = modality.addAthlete(this.athleteCount +1, athlete);
            System.out.println("Taxa paga: " + newSubscription.getTax());
            this.athleteCount += 1;
            return true;
        }

        System.out.println("Categoria inexistente ou Atleta já inscrito");
        return false;
    }

    public boolean removeAthlete(String modalityName, String rg){
        Modality modality = this.modalities.get(modalityName);
        if(modality != null){
            Subscription removedSubscription = modality.removeAthlete(rg);
            if(removedSubscription != null) {
                return true;
            }
        }

        return false;
    }

    public void showAllAthletesByModality(String modalityName){
        Modality modality = this.modalities.get(modalityName);
        if(modality != null){
            System.out.println("PARTICIPANTES DA MODALIDADE - " + modalityName);

            if(modality.getSubscriptions().isEmpty()){
                System.out.println("Nao há nenhum atleta inscrito para essa modalidade");
            }

            for(Subscription subscription: modality.getSubscriptions().values()) {
                Athlete athlete = subscription.getAthlete();
                System.out.println("Inscricão: #" + subscription.getId());
                System.out.println("Taxa de inscricao: "+ subscription.getTax());
                athlete.showAthlete();
                System.out.println("-----");
            }
        } else {
            System.out.println("Modalidade não encontrada");
        }

    }
}
