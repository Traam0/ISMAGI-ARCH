import java.util.ArrayList;

public class Medicament {
    private static final ArrayList<Medicament> instances = new ArrayList<>();

    private String nom;
    private String descriptionFr;
    private String descriptionLat;
    private int conditionnement;
    private ArrayList<ContreIndication> contreIndications;

    public Medicament(String nom, String descriptionFr, String descriptionLat, int conditionnement){
        if(Medicament.instances.stream().anyMatch(instance -> instance.nom.equals(nom))) {
            throw new IllegalArgumentException("Medicament already exists");
        }
        this.nom = nom;
        this.descriptionLat = descriptionLat;
        this.descriptionFr = descriptionFr;
        this.conditionnement = conditionnement;
        this.contreIndications = new ArrayList<>();
        Medicament.instances.add(this);
    }

    public Medicament(String nom, String descriptionFr, String descriptionLat, int conditionnement, ArrayList<ContreIndication> contreIndications){
        this(nom, descriptionFr, descriptionLat, conditionnement);
        this.contreIndications = contreIndications;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescriptionFr() {
        return descriptionFr;
    }

    public void setDescriptionFr(String descriptionFr) {
        this.descriptionFr = descriptionFr;
    }

    public String getDescriptionLat() {
        return descriptionLat;
    }

    public void setDescriptionLat(String descriptionLat) {
        this.descriptionLat = descriptionLat;
    }

    public int getConditionnement() {
        return conditionnement;
    }

    public void setConditionnement(int conditionnement) {
        this.conditionnement = conditionnement;
    }

    public ArrayList<ContreIndication> getContreIndications() {
        return contreIndications;
    }

    public void setContreIndications(ArrayList<ContreIndication> contreIndications) {
        this.contreIndications = contreIndications;
    }

    public void addContreIndications(ContreIndication value){
        this.contreIndications.add(value);
    }

    public void removeContreIndications(ContreIndication value){
        this.contreIndications.remove(value);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getNom())
                .append(" a pour description courte << ")
                .append(this.getDescriptionFr())
                .append(" >> et une description longue << ")
                .append(this.getDescriptionLat())
                .append(" >>. Il est conditionne en boite de ")
                .append(this.getConditionnement())
                .append("\n\t• Ses contre indication sont :");

        for (ContreIndication contreIndication : this.getContreIndications()) {
            builder.append("\n\t\t○ ").append(contreIndication);
        }


        return builder.toString();
    }
}


