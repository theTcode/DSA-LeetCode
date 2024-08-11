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
    
    public void update(int index, int val) {
        this.root.data = update(this.root, index, val);
    }
    private int update(TreeNode node, int index, int value){
        if(index >= node.startInterval && index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval){
                node.data = value;
                return node.data;
            }
            else{
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
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
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */