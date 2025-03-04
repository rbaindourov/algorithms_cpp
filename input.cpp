#include <iostream>
#include <string>
#include <vector>
#include <array>

using namespace std;

vector<array<char, 4>> splitIntoChunks(const string& input) {
    vector<array<char, 4>> chunks;

    // Process the string in chunks of 4 characters at a time
    for (size_t i = 0; i < input.size(); i += 4) {
        array<char, 4> chunk = {0, 0, 0, 0}; // Initialize with 0s

        // Fill the chunk with characters from the string
        for (size_t j = 0; j < 4 && (i + j) < input.size(); ++j) {
            chunk[j] = input[i + j];
        }

        chunks.push_back(chunk);
    }

    return chunks;
}

void displayChunks(const vector<array<char, 4>>& chunks) {
    // Display the chunks
    for (const auto& chunk : chunks) {
        cout << "{ ";
        for (char c : chunk) {
            if (c == 0) {
                cout << "'\\0'"
                     << " "; // Display null characters as \0
            } else {
                cout << "'" << c << "' ";
            }
        }
        cout << "}" << endl;
    }
}

int main() {
    // Example input string
    string input = "HelloWorld!";

    // Split the string into chunks of 4
    vector<array<char, 4>> chunks = splitIntoChunks(input);

    // Display the chunks
    cout << "Chunks of 4 characters (padded with 0):" << endl;
    displayChunks(chunks);

    return 0;
}