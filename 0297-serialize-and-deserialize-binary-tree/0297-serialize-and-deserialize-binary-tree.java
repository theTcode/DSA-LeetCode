/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Created a utility class that is used to keep track of the 
    // current position in the array during the deserialization process.
    class Index {
        int val;
        Index() {
            this.val = 0;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        treeToString(root, str);
        return str.toString();
    }
    void treeToString(TreeNode root, StringBuilder list){
        if(root == null){
            list.append("n ");
            return;
        }

        list.append(root.val + " ");

        treeToString(root.left, list);
        treeToString(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }
        String[] str = data.split(" ");

        return stringToTree(str, new Index());
    }
    TreeNode stringToTree(String[] list, Index index){
        if(index.val >= list.length || list[index.val].equals("n")){
            index.val++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(list[index.val++]));

        node.left = stringToTree(list, index);
        node.right = stringToTree(list, index);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));