import java.util.ArrayList;

public class ContreIndication {
    private static final ArrayList<String> codes = new ArrayList<>();

    private String code;
    private String description;
    private Medicament medicament;

    public ContreIndication(String code, String description, Medicament medicament) {
        if(ContreIndication.codes.stream().anyMatch(c -> c.equals(code))) {
            throw new IllegalArgumentException("Une ContreIndication avec le meme code deja exist");
        }

        this.code = code;
        this.description = description;
        this.medicament = medicament;
        ContreIndication.codes.add(code);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", this.getCode(), this.getDescription());
    }
}