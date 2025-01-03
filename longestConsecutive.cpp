    // Function to return length of longest subsequence of consecutive integers.
    int longestConsecutive(vector<int>& arr) {
        // Your code here
        int mx = INT_MIN;
        int previous = NULL;
        int count = 1;
        
        sort( arr.begin(), arr.end() );
        
        for( int current : arr ){
            if( previous == current ) continue;
            count = ( previous == current-1) ? count+1 : 1;
            previous = current;
            mx = max(mx, count);
        }
        
        
        return mx;
    }

    int main(){
        
        return longestConsecutive({2,6,1,9,4,5,3});
    }