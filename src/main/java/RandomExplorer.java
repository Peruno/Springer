import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomExplorer {

    Random randomizer = new Random();

    public void doRandomRun(int attempt){
        Knight knight = new Knight(0, 0);
        List<Field> currentPath = new ArrayList<>();
        currentPath.add(knight.field);
        int jumps = 0;

        while (jumps < 63) {
            List<Field> validFields = knight.getUnusedFields(currentPath);

            if (validFields.isEmpty()) {
                return;
            }

            int numberOfValidFields = validFields.size();
            Field randomlyChosenNextField = validFields.get(randomizer.nextInt(numberOfValidFields));

            knight.jumpTo(randomlyChosenNextField);
            jumps += 1;
            currentPath.add(randomlyChosenNextField);

            if (jumps == 63) {
                System.out.println("Found a solution on attempt " + attempt);
                printPath(currentPath);
                writeResultToFile(currentPath);
                return;
            }
        }
    }

    public void printPath(List<Field> path) {
        System.out.println("Path: ");
        StringBuilder pathBuilder = new StringBuilder();
        for (Field field : path) {
            String name = Field.getNameOfField(field);
            pathBuilder.append(Field.getNameOfField(field));
            pathBuilder.append(" -> ");
        }
        pathBuilder.setLength(pathBuilder.length() - 4);
        System.out.println(pathBuilder.toString());
    }



    private void writeResultToFile(List<Field> knightPath) {
        try {
            FileWriter myWriter = new FileWriter("success.txt");
            for (Field field : knightPath) {
                String name = Field.getNameOfField(field);
                myWriter.write(name);
            }
        } catch (Exception e) {
            System.out.println("Fail");
        }

    }
}
