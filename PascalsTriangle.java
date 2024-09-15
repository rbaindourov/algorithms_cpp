import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> traingle = new ArrayList<List<Integer>>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>(i+1);
            for ( int j = 0; j < i+1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(traingle.get(i-1).get(j-1) + traingle.get(i-1).get(j));
                }
            }
            traingle.add(row);
        }
        return traingle;

    }

    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        System.out.println(pt.generate(5));
    }

}