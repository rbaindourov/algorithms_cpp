#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
using namespace std;

double maxAverageRatio(vector<vector<int>>& classes, int extraStudents) {
    // Define max-heap as a priority queue with tuples storing (-delta, passi, totali)
    auto getDelta = [](int passi, int totali) {
        double currentRatio = (double) passi / totali;
        double newRatio = (double) (passi + 1) / (totali + 1);
        return newRatio - currentRatio;
    };

    priority_queue<tuple<double, int, int>> maxHeap;

    // Push every class into the maxHeap
    for (auto& cls : classes) {
        int passi = cls[0], totali = cls[1];
        double delta = getDelta(passi, totali);
        maxHeap.push({delta, passi, totali});
    }

    // Assign all extra students to maximize the average pass ratio
    while (extraStudents > 0) {
        auto [delta, passi, totali] = maxHeap.top();
        maxHeap.pop();

        // Add a brilliant student to this class
        passi++;
        totali++;

        // Recalculate delta and push back into the heap
        double newDelta = getDelta(passi, totali);
        maxHeap.push({newDelta, passi, totali});

        // Decrement extraStudents
        extraStudents--;
    }

    // Calculate the final average pass ratio
    double totalRatio = 0.0;
    while (!maxHeap.empty()) {
        auto [delta, passi, totali] = maxHeap.top();
        maxHeap.pop();

        totalRatio += (double) passi / totali;
    }

    return totalRatio / classes.size();
}

int main() {
    vector<vector<int>> classes = {{1, 2}, {3, 5}, {2, 2}};
    int extraStudents = 2;

    double result = maxAverageRatio(classes, extraStudents);
    cout.precision(5);
    cout << fixed << "Maximum Average Pass Ratio: " << result << endl;


    classes = {{2,4}, {3, 9}, {4, 5}, {2, 10}};
    extraStudents = 4;
    result = maxAverageRatio(classes, extraStudents);
    cout.precision(5);
    cout << fixed << "Maximum Average Pass Ratio: " << result << endl;


    return 0;
}