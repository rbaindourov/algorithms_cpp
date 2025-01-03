#include <vector>
#include <algorithm>
#include <iostream>
#include <unordered_set>

using namespace std;

int mincostTickets(vector<int>& days, vector<int>& costs) {
    vector<int> dp(days.back()+1, 0);
    unordered_set<int> daySet(days.begin(), days.end());

    for (int day = 1; day <= days.back(); ++day) {
        if( daySet.find(day) != daySet.end() ) {

             dp[day] = min({
               dp[max(0,day-30)]+costs[2],
               dp[max(0,day-7)]+costs[1],
               dp[day-1]+costs[0]
             });

        } else
            dp[day] = dp[day-1];
    }
    return dp[days.back()];
}

int main() {
      vector<int> days = {1,4,6,7,8,20};
      vector<int> costs = {2,7,15};
      //vector<int> costs = {7,2,15};
      cout<<mincostTickets(days, costs);
}