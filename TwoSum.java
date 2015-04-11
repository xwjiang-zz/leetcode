//only one "for" is needed!!
public class Solution {
  public int[] twoSum(int[] array, int target){
      int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                result[0] = map.get(target - array[i]) + 1;
                result[1] = i + 1;
                return result;
            }
            map.put(array[i], i);
        }
        return result;
  }
}
