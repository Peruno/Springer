import java.util.ArrayList;
import java.util.List;

public class Knight {
    Field field;
    List<Field> jumpPath = new ArrayList<>();

    public Knight(int xPosition, int yPosition) {
        this.field = new Field(xPosition, yPosition);
        this.jumpPath .add(this.field);
    }

    public void jumpTo(Field field) {
        this.field = field;
        this.jumpPath.add(field);
    }

    public List<Field> getUnusedFields(List<Field> currentPath) {
        List<Field> reachableFields = getPossibleFields();
        List<Field> validFields = new ArrayList<>();
        for (Field field : reachableFields) {
            if (!currentPath.contains(field)) {
                validFields.add(field);
            }
        }
        return validFields;
    }

    private List<Field> getPossibleFields() {
        int currentXPosition = field.xPosition;
        int currentYPosition = field.yPosition;

        List<Field> all8FieldsAround = getAll8FieldsAround(currentXPosition, currentYPosition);

        List<Field> possibleFields = new ArrayList<>();
        for (Field field : all8FieldsAround) {
            if (Field.isFieldOnBoard(field.xPosition, field.yPosition)) {
                possibleFields.add(field);
            }
        }

        return possibleFields;
    }

    private List<Field> getAll8FieldsAround(int currentXPosition, int currentYPosition) {
        List<Field> allFields = new ArrayList<>();

        allFields.add(new Field(currentXPosition + 1, currentYPosition + 2));
        allFields.add(new Field(currentXPosition + 1, currentYPosition - 2));
        allFields.add(new Field(currentXPosition + 2, currentYPosition + 1));
        allFields.add(new Field(currentXPosition + 2, currentYPosition - 1));
        allFields.add(new Field(currentXPosition - 1, currentYPosition + 2));
        allFields.add(new Field(currentXPosition - 1, currentYPosition - 2));
        allFields.add(new Field(currentXPosition - 2, currentYPosition + 1));
        allFields.add(new Field(currentXPosition - 2, currentYPosition - 1));
        return allFields;
    }
}
