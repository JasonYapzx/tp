package seedu.pennywise.model.entry;

/**
 * Represents an Expenditure in the penny wise application.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Expenditure extends Entry {
    /**
     * Every field must be present and not null.
     */
    public Expenditure(Description description, Date date, Amount amount, Tag tag) {
        super(description, date, amount, tag);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getDescription())
                .append("; Date: ")
                .append(getDate())
                .append("; Amount: ")
                .append(getAmount())
                .append("; Tag: ")
                .append(getTag());

        return builder.toString();
    }
}