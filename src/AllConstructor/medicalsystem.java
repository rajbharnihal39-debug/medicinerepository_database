package AllConstructor;

public class medicalsystem {

    private int role_id;
    private String role_name;
    private String description;

    public medicalsystem(int role_id, String role_name, String description) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.description = description;
    }

    public int getrole_id() {
        return role_id;
    }

    public void setrole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getrole_name() {
        return role_name;
    }

    public void setrole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role ID: " + role_id +
               "\nRole Name: " + role_name +
               "\nDescription: " + description;
    }
}
