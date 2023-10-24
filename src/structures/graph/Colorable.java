package structures.graph;

import java.util.List;

public abstract class Colorable<Data, ColorType> {

    public abstract boolean mayConflictWith(final Data other);

    public abstract boolean hasConflictWith(final Data other);

    public abstract String identify();

    public abstract ColorType getColorInfo();

    public abstract void setColorInfo(final ColorType info);

    public void associate(final List<ColorType> possibilities, final Color color) {
        setColorInfo(possibilities.get(color.ordinal()));
    };
}
