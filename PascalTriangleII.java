//use array and then convert it to arraylist
//notice the type of array must be consistent with the arraylist
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] array = new Integer[rowIndex+1];
        array[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i-1; j >= 1; j--) {
                array[j] += array[j-1];
            }
            array[0] = 1;
            array[i] = 1;
        }
        return new ArrayList<Integer>(Arrays.asList(array));
    }
}
