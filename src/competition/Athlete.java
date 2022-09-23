package competition;

public class Athlete {
    private String rg;
    private String name;
    private String surname;
    private String phone;
    private String emergencyPhone;
    private String bloodType;
    private int age;
    public Athlete(String rg, String name, String surname, String phone, String emergencyPhone, String bloodType, int age) {
        this.rg = rg;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.emergencyPhone = emergencyPhone;
        this.bloodType = bloodType;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public String getBloodType() {
        return bloodType;
    }

    public int getAge() {
        return age;
    }

    public String getRg() {
        return rg;
    }

    public void showAthlete(){
        System.out.println("RG: "+this.rg);
        System.out.println("Nome: " + this.name + " "+ this.surname);
        System.out.println("Idade: " + this.age);
        System.out.println("Tipo Sanguíneo: " + this.bloodType);
        System.out.println("Telefone Pessoal: " + this.phone);
        System.out.println("Telefone de Emergência: " + this.emergencyPhone);
    }
}
