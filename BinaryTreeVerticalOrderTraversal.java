// TC: O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Queue;

public List<List<Integer>> verticalOrder(TreeNode root) {
    List<Integer<Integer>> result = new ArrayList<>();;
    if(root == null) return result;
    Queue<TreeNode> q = new LinkedList<>();
    Queue<Integer> cols = new LinkedList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    int minCol = 0, maxCol = 0;
    q.add(root);
    cols.add(0);
    while(!q.isEmpty()) {
        TreeNode curr = q.poll();
        int col = cols.poll();
        if(!map.containsKey(col)) {
            map.put(col, new ArrayList<>());
        }
        map.get(col).add(curr.val);
        if(curr.left != null) {
            q.add(curr.left);
            cols.add(col - 1);
            minCol = Math.min(minCol, col - 1);
        }
        if(curr.right != null) {
            q.add(curr.right);
            cols.add(col + 1);
            maxCol = Math.max(maxCol, col + 1);
        }
    }
    for(int i = minCol; i <= maxCol; i++) {
        result.add(map.get(i));
    }
    return result;
}