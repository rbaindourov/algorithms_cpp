#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <iostream>

class Solution {
public:
    std::vector<std::string> findRelativeRanks(std::vector<int>& score) {
        int n = score.size();
        
        int maxScore = *std::max_element(score.begin(), score.end());
        
        // Create a vector to hold the indices based on scores
        std::vector<int> score2Index(maxScore + 1, 0);
        
        for (int i = 0; i < n; ++i) {
            score2Index[score[i]] = i + 1; // Store index (+1 to handle 0 index)
        }
        
        std::vector<std::string> ans(n);
        int place = 1;

        // Assign medals or rank numbers based on places
        for (int i = maxScore; i >= 0; --i) {
            if (score2Index[i] == 0) continue;

            int actualIndex = score2Index[i] - 1;
            if (place == 1) {
                ans[actualIndex] = "Gold Medal";
            } else if (place == 2) {
                ans[actualIndex] = "Silver Medal";
            } else if (place == 3) {
                ans[actualIndex] = "Bronze Medal";
            } else {
                ans[actualIndex] = std::to_string(place);
            }
            place++; 
        }

        return ans;
    }
};

//generate main
int main() {
    std::vector<int> score = {5, 4, 3, 2, 1};
    Solution obj;
    std::vector<std::string> ans = obj.findRelativeRanks(score);
    for (int i = 0; i < ans.size(); i++) {
        std::cout << ans[i] << std::endl;
    }
}



// best solution
// class Solution {
// public:
//     using int2=pair<int, int>;
//     vector<string> findRelativeRanks(vector<int>& score) {
//         int n=score.size();
//         vector<int2> sIdx(n);
//         for(int i=0; i<n; i++)
//             sIdx[i]={score[i], i};
//         sort(sIdx.rbegin(), sIdx.rend());
//         vector<string> ans(n);
//         ans[sIdx[0].second]="Gold Medal";
//         if( n>1) ans[sIdx[1].second]="Silver Medal";
//         if (n>2) ans[sIdx[2].second]="Bronze Medal";
//         for(int i=3; i<n; i++)
//             ans[sIdx[i].second]=to_string(i+1);
//         return ans;
//     }
// };