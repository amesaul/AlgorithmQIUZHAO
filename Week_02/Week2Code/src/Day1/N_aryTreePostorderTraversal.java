package Day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N_aryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return Collections.emptyList();
        naryIter(root, list);
        list.add(root.val);
        return list;
    }

    private void naryIter(Node root, List<Integer> list) {
        if (root != null) {
            for (Node child : root.children) {
                naryIter(child, list);
                list.add(child.val);
            }
        }
    }
}
