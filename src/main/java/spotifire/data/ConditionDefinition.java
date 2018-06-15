package spotifire.data;

import java.util.Objects;

public class ConditionDefinition {

    private ConditionType type;
    private String value;

    public ConditionType getType() {
        return type;
    }

    public void setType(ConditionType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConditionDefinition that = (ConditionDefinition) o;
        return type == that.type &&
            Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }

    @Override
    public String toString() {
        return "ConditionDefinition{" +
            "type=" + type +
            ", value='" + value + '\'' +
            '}';
    }
}
