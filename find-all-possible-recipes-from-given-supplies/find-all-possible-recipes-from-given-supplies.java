class Solution {
   public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    Set<String> supple=new HashSet<>(Arrays.asList(supplies));
    Set<String>ans=new HashSet<>();
    
    for(int i=0;i<ingredients.size();i++){
        outer:
        for(int j=0;j<ingredients.size();j++){
            if(ans.contains(recipes[j]))continue;//recipe has already been made
            for(String ingre:ingredients.get(j)){
                if(!supple.contains(ingre))continue outer;//As all ingredients are not present in supplies
            }
            ans.add(recipes[j]);// add it to the answer
            supple.add(recipes[j]); //add it to the supplies list so that another recipe can use this recipe
        }

    }
    return new ArrayList<>(ans);
}
}