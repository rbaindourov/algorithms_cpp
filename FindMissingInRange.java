class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        return new MyList(nums);
    }

    private static class MyList extends ArrayList<Integer> {
        int[] nums;

        public MyList(int[] nums) {
            this.nums = nums;
        }

        public int size() {
            method();
            return super.size();
        }

        private void method() {
            int n = nums.length;
            boolean[] present = new boolean[n + 1];
            for (int i : this.nums) {
                present[i] = true;
            }
            for (int i = 1; i <= n; i++) {
                if (!present[i]) {
                    super.add(i);
                }
            }
            this.nums = null;
        }
    }
}
