class NumArray {
    private static class TreeNode{
        int data;
        int startInterval;
        int endInterval;
        TreeNode left;
        TreeNode right;

        public TreeNode(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private TreeNode root;

    public NumArray(int[] nums) {
        this.root = constructTree(nums, 0, nums.length-1);
    }
    private TreeNode constructTree(int[] nums, int start, int end){
        if(start == end){
            TreeNode leaf = new TreeNode(start, end);
            leaf.data = nums[start];
            return leaf;
        }

        TreeNode node = new TreeNode(start, end);
        int mid = (start+end)/2;

        node.left = this.constructTree(nums, start, mid);
        node.right = this.constructTree(nums, mid+1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }
    
    public int sumRange(int left, int right) {
        return this.query(this.root, left, right);
    }
    private int query(TreeNode node, int left, int right){
        if(node.startInterval >= left && node.endInterval <= right){
            return node.data;
        }
        else if(node.startInterval > right || node.endInterval < left){
            return 0;
        }
        else{
            return this.query(node.left, left, right) + this.query(node.right, left, right);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */