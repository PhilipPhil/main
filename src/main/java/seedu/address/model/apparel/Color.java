package seedu.address.model.apparel;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Objects;

/**
 * Represents an Apparel's color in the address book.
 */
public class Color implements Comparable<Color> {

    public static final String MESSAGE_CONSTRAINTS =
            "Colors should only be those that are listed in the list of accepted colors.\n"
                    + "Type `colors` to see all the accepted colors.";

    private ColorValue primary;

    public Color() { }

    /**
     * Constructs a {@code Color}.
     *
     * @param primary A valid primary color.
     */
    public Color(ColorValue primary) {
        requireNonNull(primary);
        checkArgument(ColorValue.isValidColor(primary), MESSAGE_CONSTRAINTS);

        this.primary = primary;
    }

    /**
     * Constructs a {@code Color}.
     *
     * @param primary A valid primary color.
     */
    public Color(String primary) {
        requireNonNull(primary);
        checkArgument(ColorValue.isValidColor(primary), MESSAGE_CONSTRAINTS);

        this.primary = ColorValue.valueOf(primary.toUpperCase());
    }

    public ColorValue getPrimary() {
        return primary;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Color // instanceof handles nulls
                && primary == (((Color) other).primary)); // state check
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(primary);
    }

    @Override
    public int compareTo(Color other) {
        return this.primary.name().compareTo(other.primary.name());
    }

    @Override
    public String toString() {
        return primary.name();
    }

}
