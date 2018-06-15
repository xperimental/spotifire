package spotifire.data;

import java.util.Arrays;

public class FunnelDefinition {

    private FilterDefinition[] filters;
    private ConditionDefinition[] conditions;

    public FilterDefinition[] getFilters() {
        return filters;
    }

    public void setFilters(FilterDefinition[] filters) {
        this.filters = filters;
    }

    public ConditionDefinition[] getConditions() {
        return conditions;
    }

    public void setConditions(ConditionDefinition[] conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunnelDefinition that = (FunnelDefinition) o;
        return Arrays.equals(filters, that.filters) &&
            Arrays.equals(conditions, that.conditions);
    }

    @Override
    public int hashCode() {

        int result = Arrays.hashCode(filters);
        result = 31 * result + Arrays.hashCode(conditions);
        return result;
    }

    @Override
    public String toString() {
        return "FunnelDefinition{" +
            "filters=" + Arrays.toString(filters) +
            ", conditions=" + Arrays.toString(conditions) +
            '}';
    }
}
