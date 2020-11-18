import java.util.ArrayList;
import java.util.List;

public class Tree {
}
class Node{
  String key;
  List<Node> children;

  public Node(String key){
    this.key = key;
    children = new ArrayList<>();
  }
}
