package spotifire.data;

import java.util.Objects;

public class FilterDefinition {

    private String field;
    private FilterOperator operator;
    private String value;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public FilterOperator getOperator() {
        return operator;
    }

    public void setOperator(FilterOperator operator) {
        this.operator = operator;
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
        FilterDefinition that = (FilterDefinition) o;
        return Objects.equals(field, that.field) &&
            operator == that.operator &&
            Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, operator, value);
    }

    @Override
    public String toString() {
        return "FilterDefinition{" +
            "field='" + field + '\'' +
            ", operator=" + operator +
            ", value='" + value + '\'' +
            '}';
    }
}
