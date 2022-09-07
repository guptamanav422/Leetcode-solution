class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return Collections.emptyList();
        Map<String, List<String>> directedAcyclicGraph = new HashMap<>();

        // 1. Apply BFS to create DAG from endWord to beginWord
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        words.remove(beginWord);
        Set<String> enqueued = new HashSet<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<String> nextLevelEnqueuedWords = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String word = queue.poll();
                for (String neighbour : getNeighbours(word, words)) {
                    directedAcyclicGraph.putIfAbsent(neighbour, new ArrayList<>());
                    directedAcyclicGraph.get(neighbour).add(word);
                    if (!enqueued.contains(neighbour)) {
                        enqueued.add(neighbour);
                        nextLevelEnqueuedWords.add(neighbour);
                        queue.offer(neighbour);
                    }
                }
            }

            // Remove enqueued nodes of next level to avoid cycle (as we are creating DAG)
            for (String enqueuedWord : nextLevelEnqueuedWords)
                words.remove(enqueuedWord);
        }

        // 2. Apply DFS to get the shortest paths using DAG
        List<List<String>> result = new ArrayList<>();
        List<String> currPath = new ArrayList<>();
        dfs(endWord, beginWord, directedAcyclicGraph, currPath, result);
        return result;
    }

    private void dfs(String end, String start, Map<String, List<String>> directedAcyclicGraph, List<String> currPath, List<List<String>> result) {
        currPath.add(end);
        if (end.equals(start)) {
            List<String> path = new ArrayList<>(currPath);
            Collections.reverse(path);// Reverse as currPath is from end to start word.
            result.add(path);
        }
        else {
            for (String neighbour : directedAcyclicGraph.getOrDefault(end, Collections.emptyList()))
                dfs(neighbour, start, directedAcyclicGraph, currPath, result);
        }
        currPath.remove(currPath.size() - 1);
    }

    // Helper
    private List<String> getNeighbours(String word, Set<String> words) {
        List<String> neighbours = new ArrayList<>();
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                sb.setCharAt(i, c);
                String neighbour = sb.toString();
                if (words.contains(neighbour)) neighbours.add(neighbour);
                sb.setCharAt(i, word.charAt(i));
            }
        }
        return neighbours;
    }
}