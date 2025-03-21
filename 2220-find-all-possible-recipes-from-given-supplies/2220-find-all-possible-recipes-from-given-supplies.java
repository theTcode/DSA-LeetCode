class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> available = new HashSet<>();
        for(String supply : supplies){
            available.add(supply);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<recipes.length;i++){
            queue.offer(i);
        }

        List<String> crtdRecipes = new ArrayList<>();
        int lastSize = -1;

        while(available.size() > lastSize){
            lastSize = available.size();
            int qSize = queue.size();

            while(qSize-- > 0){
                int recipeIdx = queue.poll();
                boolean canCreate = true;

                for(String ing : ingredients.get(recipeIdx)){
                    if(!available.contains(ing)){
                        canCreate = false;
                        break;
                    }
                }
                if(canCreate == false){
                    queue.offer(recipeIdx);
                }
                else{
                    available.add(recipes[recipeIdx]);
                    crtdRecipes.add(recipes[recipeIdx]);
                }
            }
        }

        return crtdRecipes;
    }
}