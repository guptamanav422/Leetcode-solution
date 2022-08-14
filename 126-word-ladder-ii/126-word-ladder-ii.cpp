class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        endWordIndex = findWordIndex(endWord, wordList);
        if (endWordIndex == -1) return {};
        // Add beginWord as the last node if it doesn't exist in wordList
        beginWordIndex = findWordIndex(beginWord, wordList);
        if (beginWordIndex == -1) {
            wordList.push_back(beginWord);
            beginWordIndex = wordList.size() - 1;
        }
        distances.assign(wordList.size(), -1);
        
        buildGraph(wordList);
        const int shortestDist = findShortestDistFromBeginToEndWord();
        if (shortestDist == -1) return {};
        
        findAllPaths(shortestDist, wordList);
        return results;
    }
    
    void buildGraph(const vector<string> &wordList) {
        nodeToNeighbors.assign(wordList.size(), {});
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.size(); j++) {
                if (i == j) continue;
                if (isConnected(wordList[i], wordList[j])) {
                    nodeToNeighbors[i].push_back(j);
                }
            }
        }
    }
    
    int findShortestDistFromBeginToEndWord() {
        vector<int> visited(nodeToNeighbors.size(), false);
        visited[beginWordIndex] = true;
        deque<int> pending = {beginWordIndex};
        int distance = 0;
        while (!pending.empty()) {
            const int pendingSize = pending.size();
            for (int i = 0; i < pendingSize; i++) {
                const int node = pending.front();
                pending.pop_front();
                
                distances[node] = distance;
                if (node == endWordIndex) {
                    return distance;
                }
                
                const auto &neighbors = nodeToNeighbors[node];
                for (const int neighbor : neighbors) {
                    if (visited[neighbor]) continue;
                    
                    visited[neighbor] = true;
                    pending.push_back(neighbor);
                }
            }
            distance++;
        }
        return -1;
    }
    
    void findAllPaths(const int shortestDist, const vector<string> &wordList) {
        vector<bool> visited(wordList.size(), false);
        vector<string> curPath(shortestDist + 1);
        findAllPathsRecursive(endWordIndex, shortestDist, shortestDist, wordList, curPath, visited);
    }
    
    void findAllPathsRecursive(const int node, const int curDist, const int shortestDist, const vector<string> &wordList, vector<string> &curPath, vector<bool> &visited) {
        curPath[curDist] = wordList[node];
        if (curDist <= 0) {
            if (node == beginWordIndex) {
                results.push_back(curPath);
            }
            return;
        }
        
        visited[node] = true;
        
        const auto &neighbors = nodeToNeighbors[node];
        for (const int neighbor : neighbors) {
            if (visited[neighbor]) continue;
            if (distances[neighbor] != curDist - 1) continue;
            
            findAllPathsRecursive(neighbor, curDist - 1, shortestDist, wordList, curPath, visited);
        }
        
        visited[node] = false;
    }
    
    int findWordIndex(const string &findWord, const vector<string> &wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList[i] == findWord) return i;
        }
        return -1;
    }
    
    bool isConnected(const string &s1, const string &s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1[i] != s2[i]) diffCount++;
            if (diffCount >= 2) return false;
        }
        return diffCount == 1;
    }
    
    int beginWordIndex = -1;
    int endWordIndex = -1;
    vector<vector<int>> nodeToNeighbors;
    vector<int> distances;
    vector<vector<string>> results;
};