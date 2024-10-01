class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort( arr );
        int diff =  arr[0] - arr[1];
        for(int i = 2; i < arr.length; ++i ){
            if( arr[i-1] - arr[i] != diff )
                return false;
        }
         
        return true;
    }
}


class Solution {
    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }

        public void addValue(int num){
            if(num > value) {
                if(right == null){
                    right = new Node(num);
                    return;
                }
                right.addValue(num); 
                return;
            } 
            
            if(num <= value){
                if(left == null) {
                    left = new Node(num);
                    return;
                }
                left.addValue(num);
                return;
            } 
        }

        public int orderList(int[] arr, int index){
            if(left != null){
                index = left.orderList(arr, index);
            }
            arr[index] = value;
            index++;
            if(right != null) {
                index = right.orderList(arr, index);
            }
            return index;
        }
    }
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 2){
            return true;
        }

        Node root = new Node(arr[0]);
        for(int i = 1; i< arr.length; i++){
            root.addValue(arr[i]);
        }

        root.orderList(arr, 0);

        int diff = arr[1] - arr[0];
        for(int i=1; i < arr.length; i++){
            if(diff != arr[i]-arr[i-1]){
                return false;
            }
        }

        return true;
    }
}



class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min = 0;
        int max = 0;
        int n = arr.length-1;
        for(int i = 0; i <= n; i++){
            if(arr[min] > arr[i]){
                min = i;
            }

            if(arr[max] < arr[i]){
                max = i;
            }
        }

        if(arr[max] == arr[min]){
            return true;
        }

        if((arr[max]-arr[min]) % n != 0){
            return false;
        }

        int diff = (arr[max] - arr[min]) / n;
        boolean[] values = new boolean[n+1];
        int diffFromMin;
        for(int i=0; i<=n; i++){
            diffFromMin = arr[i] - arr[min];
            if((diffFromMin) % diff != 0){
                return false;
            }
            
            if(values[diffFromMin/diff]){
                return false;
            }

            values[diffFromMin/diff] = true;
        }

        return true;
    }
}
