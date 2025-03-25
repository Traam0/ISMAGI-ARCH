package common;

public final class Client {
    private int points;
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private Chariot chariot;

    public Client() {

    }

    public Client(String id, String firstName, String lastName, String phone) {
        this();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Client(String id, String firstName, String lastName, String phone, int points) {
        this(id, firstName, lastName, phone);
        this.points = points;
    }

    public Client(String id, String firstName, String lastName, String phone, int points, Chariot chariot) {
        this(id, firstName, lastName, phone, points);
        this.chariot = chariot;
    }

    public Client(Client client) {
        this();
        this.setId(client.getId());
        this.setFirstName(client.getFirstName());
        this.setLastName(client.getLastName());
        this.setPhone(client.getPhone());
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        if (value.equals(this.id))
            return;
        this.id = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        if (value.equals(this.firstName))
            return;
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        if (value.equals(this.lastName))
            return;
        this.lastName = value;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String value) {
        if (value.equals(this.phone))
            return;
        this.phone = value;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int value) {
        if (value == this.points)
            return;
        this.points = value;
    }

    public Chariot getChariot() {
        return chariot;
    }

    public void setChariot(Chariot value) {
        if (value.equals(this.chariot))
            return;
        this.chariot = value;
    }
}
