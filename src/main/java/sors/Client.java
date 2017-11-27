package sors;

class Client {
    private String id;
    private String fullName;

    String getId() {
        return id;
    }

    String getFullName() {
        return fullName;
    }

    Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
