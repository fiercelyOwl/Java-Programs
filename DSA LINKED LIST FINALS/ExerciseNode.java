// ExerciseNode.java

public class ExerciseNode {
    private String name;
    private String disease;
    private String description;
    private String instructions;
    private String repetitions;
    private String benefits;
    private String videoLink;
    private ExerciseNode next;

    public ExerciseNode(String name, String disease, String description, String instructions, String repetitions, String benefits, String videoLink) {
        this.name = name;
        this.disease = disease;
        this.description = description;
        this.instructions = instructions;
        this.repetitions = repetitions;
        this.benefits = benefits;
        this.videoLink = videoLink;
        this.next = null;
    }

    // Getters
    public String getName() { return name; }
    public String getDisease() { return disease; }
    public String getDescription() { return description; }
    public String getInstructions() { return instructions; }
    public String getRepetitions() { return repetitions; }
    public String getBenefits() { return benefits; }
    public String getVideoLink() { return videoLink; }
    public ExerciseNode getNext() { return next; }
    public void setNext(ExerciseNode next) { this.next = next; }
}