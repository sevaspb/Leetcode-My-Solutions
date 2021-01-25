/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int left, int right){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(left > right) return res; 

        for(int i = left; i <= right; i++){
            List<TreeNode> leftList = generate(left, i - 1);
            List<TreeNode> rightList = generate(i + 1, right);

            for(TreeNode leftNode : leftList){
                for(TreeNode rightNode : rightList){
                    TreeNode cur = new TreeNode(i);
                    cur.left = leftNode;
                    cur.right = rightNode;
                    res.add(cur);
                }
            }
        }

        return res;
    }
}