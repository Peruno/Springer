import java.util.ArrayList;
import java.util.List;

public class Node {
    Field field;
    Node parent;
    List<Node> children;
    int depth;
    boolean isDead;

    List<Field> alreadyUsedInThisBranch = new ArrayList<>();

    public Node(Field field, List<Field> alreadyUsedInThisBranch) {
        this.field = field;
        this.alreadyUsedInThisBranch = alreadyUsedInThisBranch;
        this.alreadyUsedInThisBranch.add(field);

    }

//    public void addChild(KnightPosition position, List<KnightPosition> alreadyUsedInThisBranch) {
//        Node child = new Node(position, alreadyUsedInThisBranch);
//        child.setParent(this);
//        this.children.add(child);
//    }

//    public void setParent(Node parent) {
//        parent.addChild(this);
//        this.parent = parent;
//    }

}
