import java.util.HashMap;
import java.util.Map;

public class Field {
    public int xPosition;
    public int yPosition;

    public Field(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public static boolean isFieldOnBoard(int xPosition, int yPosition) {
        boolean xIsValid = (0 <= xPosition) && (xPosition <= 7);
        boolean yIsValid = (0 <= yPosition) && (yPosition <= 7);

        return xIsValid && yIsValid;
    }

    public static String getNameOfField(Field field) {
        Map<Integer, String> mapFromIntToStrings = new HashMap<Integer, String>();
        mapFromIntToStrings.put(0, "A");
        mapFromIntToStrings.put(1, "B");
        mapFromIntToStrings.put(2, "C");
        mapFromIntToStrings.put(3, "D");
        mapFromIntToStrings.put(4, "E");
        mapFromIntToStrings.put(5, "F");
        mapFromIntToStrings.put(6, "G");
        mapFromIntToStrings.put(7, "H");

        String nameOfField = mapFromIntToStrings.get(field.xPosition) +
                (field.yPosition + 1);
        return nameOfField;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Field other = (Field) obj;
        if (this.xPosition != other.xPosition) {
            return false;
        }

        if (this.yPosition != other.yPosition) {
            return false;
        }

        return true;
    }

}
