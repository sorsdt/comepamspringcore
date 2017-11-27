package ua.epam.spring.core.beans;

public class Client {
    private String id;
    private String fullName;

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Client() {
    }

    public Client(String id) {
        this.id = id;
    }

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
