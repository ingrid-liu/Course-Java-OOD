
public class TNode {
    public String word;
    public SNode next;

    public SNode(String word) {
        this.word = word;
        this.next = null;
    }

    public SNode(String word, SNode next) {
        this.word = word;
        this.next = next;
    }

    public String toString() {
        return this.word + " ";
    }
}
