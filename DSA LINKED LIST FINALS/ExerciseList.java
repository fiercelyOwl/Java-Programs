
import java.util.ArrayList;

public class ExerciseList {
    private ExerciseNode head;

    public void addExercise(String name, String disease, String description, String instructions, String repetitions, String benefits, String videoLink) {
        ExerciseNode newNode = new ExerciseNode(name, disease, description, instructions, repetitions, benefits, videoLink);
        if (head == null) {
            head = newNode;
        } else {
            ExerciseNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public ArrayList<ExerciseNode> getExercisesByDisease(String disease) {
        ArrayList<ExerciseNode> list = new ArrayList<>();
        ExerciseNode current = head;
        while (current != null) {
            if (current.getDisease().equalsIgnoreCase(disease)) {
                list.add(current);
            }
            current = current.getNext();
        }
        return list;
    }
}