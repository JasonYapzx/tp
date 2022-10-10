package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.entry.*;
import seedu.address.model.tag.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Jackson-friendly version of {@link Income}
 */
public class JsonAdaptedIncome extends JsonAdaptedEntry {
    /**
     * Constructs a {@code JsonAdaptedEntry} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedIncome(@JsonProperty("description") String description, @JsonProperty("amount") String amount,
                            @JsonProperty("date") String date, @JsonProperty("tagged") List<JsonAdaptedTag> tagged) {
        super(description, amount, date, tagged);
    }

    public JsonAdaptedIncome(Entry source) {
        super(source);
    }

    @Override
    public Income toModelType() throws IllegalValueException {
        checkIsValidJsonEntry();
        final List<Tag> personTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            personTags.add(tag.toModelType());
        }

        final Description modelDescription = new Description(description);

        final Amount modelAmount = new Amount(amount);

        final Date modelDate = new Date(date);

        final Set<Tag> modelTags = new HashSet<>(personTags);
        return new Income(modelDescription, modelDate, modelAmount, modelTags);
    }
}