package proga.homework1_5;

import java.util.Objects;

public class Visitor {
    private String name;
    private String passId;
    public Visitor(String name, String passId) {
        this.name = name;
        this.passId = passId;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPassId() { return passId; }
    public void setPassId(String passId) { this.passId = passId; }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Visitor visitor = (Visitor) obj;
        return Objects.equals(passId, visitor.passId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(passId);
    }
    @Override
    public String toString() {
        return name + " (" + passId + ")";
    }
}