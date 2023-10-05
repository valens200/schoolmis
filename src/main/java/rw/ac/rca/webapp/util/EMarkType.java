package rw.ac.rca.webapp.util;

public enum EMarkType {
    EXAM("EXAM"),
    TEST("TEST"),
    ASSIGNMENT("ASSIGNMENT"),
    PROJECT("PROJECT");

    private String type;

    EMarkType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
