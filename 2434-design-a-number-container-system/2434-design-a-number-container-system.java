class NumberContainers {

    public NumberContainers() {
        num = new HashMap<>();
        ind = new HashMap<>();
    }
    
    public void change(int index, int number) {
        ind.put(index, number);

        num.computeIfAbsent(number, k -> new PriorityQueue<>()).add(index);
    }
    
    public int find(int number) {
        if(!num.containsKey(number)){
            return -1;
        }

        PriorityQueue<Integer> minHeap = num.get(number);

        while(!minHeap.isEmpty()){
            int index = minHeap.peek();

            if(ind.get(index) == number){
                return index;
            }

            minHeap.poll();
        }

        return -1;
    }

    private Map<Integer, PriorityQueue<Integer>> num;
    private Map<Integer, Integer> ind;
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */