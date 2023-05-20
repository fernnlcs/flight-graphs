package structures.graph;

import java.util.List;

public abstract class Colorable<Data, ColorType> {

    public abstract boolean mayConflictWith(Data other);

    public abstract boolean hasConflictWith(Data other);

    public abstract String identify();

    public abstract ColorType getColorInfo();

    public abstract void setColorInfo(ColorType info);

    public void associate(List<ColorType> possibilities, Color color) {
        switch (color) {
            case Yellow:
                setColorInfo(possibilities.get(0));
                break;

            case Green:
                setColorInfo(possibilities.get(1));
                break;

            case Blue:
                setColorInfo(possibilities.get(2));
                break;

            case Red:
                setColorInfo(possibilities.get(3));
                break;

            case Orange:
                setColorInfo(possibilities.get(4));
                break;

            case Purple:
                setColorInfo(possibilities.get(5));
                break;

            default:
                break;
        }
    };
}
