package bd.model.domain;

public enum Role {
    CLIENTE(1),
    TASSISTA(2),

    GESTORE(3);

    private final int id;

    private Role(int id) {
        this.id = id;
    }

    public static Role fromInt(int id) {
        for (Role type : values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }
}
