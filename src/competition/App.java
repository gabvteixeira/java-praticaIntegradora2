package competition;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static final String SMALL = "Circuito Pequeno";
    public static final String MEDIUM = "Circuito Médio";
    public static final String ADVANCED = "Circuito Avancado";


    public static void main(String[] args) {
        Competition competition = new Competition();

        Modality small = new Modality(SMALL,1300,1500);
        Modality medium = new Modality(MEDIUM,2000,2300);
        Modality advanced = new Modality(ADVANCED, 18, 0,2800);

        competition.addModality(small);
        competition.addModality(medium);
        competition.addModality(advanced);

        while(true){
            System.out.println("Selecione uma das opcoes:");

            System.out.println("1 - Listar atletas de uma categoria");
            System.out.println("2 - Adicionar atleta em uma categoria");
            System.out.println("3 - Remover atleta de uma categoria");
            System.out.println("4 - Encerrar execucao");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            int modalityOption;
            String modalityName;
            switch (option){
                case 1:
                    showDefaultModalities();
                    int modality = scanner.nextInt();
                    modalityName = getModalityName(modality);
                    competition.showAllAthletesByModality(modalityName);
                    System.out.println();
                    break;
                case 2:
                    showDefaultModalities();
                    modalityOption = scanner.nextInt();
                    modalityName = getModalityName(modalityOption);
                    Athlete newAthlete = generateAthlete();
                    System.out.println("Inserindo atleta gerado: ");
                    newAthlete.showAthlete();
                    competition.addAthlete(newAthlete,modalityName);
                    System.out.println();
                    break;
                case 3:
                    showDefaultModalities();
                    modalityOption = scanner.nextInt();
                    modalityName = getModalityName(modalityOption);
                    System.out.println("Digite o rg do participante a ser removido");
                    scanner.nextLine();
                    String rg = scanner.nextLine();
                    if(competition.removeAthlete(modalityName, rg)){
                        System.out.println("Atleta removido com sucesso");
                    } else {
                        System.out.println("Erro ao remover atleta!");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("See you again, space cowboy!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Digite uma opcao valida!!!");
            }
        }

    }

    public static void showDefaultModalities(){
        System.out.println("Selecione o nome da modalidade");
        System.out.println("1 - Circuito Pequeno");
        System.out.println("2 - Circuito Medio");
        System.out.println("3 - Circuito Avancado");
    }

    public static String getModalityName(int option){
        switch (option){
            case 1: return SMALL;
            case 2: return MEDIUM;
            case 3: return ADVANCED;
            default: return "";
        }
    }

    public static Athlete generateAthlete(){
        String[] names = {"Pedro", "Gabriel", "Felipe", "Giovanna", "Michelle", "Anderson"};
        String[] surnames = {"Silva", "Santos", "Pereira", "Klein"};
        String randomCpf = String.valueOf(new Random().nextInt(10000));
        String randomPhone1 = String.valueOf(new Random().nextInt(10000));
        String randomPhone2 = String.valueOf(new Random().nextInt(10000));
        int randomAge = new Random().nextInt(99);


        return new Athlete(randomCpf,
                getRandomFromArray(names),
                getRandomFromArray(surnames),
                randomPhone1,
                randomPhone2,
                "O",
                randomAge);
    }
    public static String getRandomFromArray(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
