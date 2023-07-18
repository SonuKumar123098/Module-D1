//https://practice.geeksforgeeks.org/problems/alien-dictionary/1
// https://course.acciojob.com/idle?question=4e10f131-e0bd-49a2-baa5-3111ed5e0f3b
// topological sort used in this question


//User function Template for Java

class Solution
{
    void topologicalSort(HashSet<Integer>[] graph,boolean []visited,int i,StringBuilder sb){
        visited[i]=true;
        for(int node:graph[i]){
            if(!visited[node]){
                topologicalSort(graph,visited,node,sb);
            }
        }
        int c='a'+i;
        char c1=(char)c;
        sb.append(c1);
    }
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        HashSet<Integer>[] graph = new HashSet[K];
        for(int i = 0; i < K; i++) {
            graph[i] = new HashSet<>();
        }
        for(int i = 0; i < N - 1; i++) {
            for(int j = 0; j < Math.min(dict[i].length(), dict[i + 1].length()); j++) {
                if(dict[i].charAt(j) != dict[i + 1].charAt(j)) {
                    graph[dict[i].charAt(j)-'a'].add(dict[i+1].charAt(j)-'a');
                    break;
                }
            }
        }
        boolean []visited=new boolean[K];
        StringBuilder sb=new StringBuilder();
        for( int i=0;i<K;i++){
            if(!visited[i]){
                topologicalSort(graph,visited,i,sb);
            }
        }
        sb.reverse();
        return sb.toString();
        
    }
}
//2nd implementation


//User function Template for Java

class Solution
{
    private static void topologicalSort(Stack<Character>st,HashSet<Character> visited,HashMap<Character,HashSet<Character>>graph,char c){
		visited.add(c);
		 HashSet<Character>edge=graph.get(c);
		if(edge!=null){
			for(char node:edge){
			if(!visited.contains(node)){
				topologicalSort(st,visited,graph,node);
			}
		}}
		st.push(c);
	}
    public String findOrder(String [] words, int n, int K)
    {
        // Write your code here
        HashMap<Character,HashSet<Character>>graph=new HashMap<>();
		for(int i=0;i<n-1;i++){
			int j=0;
			while(j<words[i].length() && j<words[i+1].length()){
				char c1=words[i].charAt(j);
				char c2=words[i+1].charAt(j);
				if(c1!=c2){
					if(graph.containsKey(c1)){
						graph.get(c1).add(c2);
					}else{
						HashSet<Character> edge=new HashSet<>();
					    edge.add(c2);
					    graph.put(c1,edge);
				    }
					break;
				}
				j++;
			}
		}
		HashSet<Character> visited=new HashSet<>();
		Stack<Character>st=new Stack<>();
		for(char c:graph.keySet()){
			if(!visited.contains(c)){
				topologicalSort(st,visited,graph,c);
			}
		}
		StringBuilder sb=new StringBuilder();
		while(st.size()>0){
			sb.append(st.pop());
		}
		return sb.toString();
        
    }
}
