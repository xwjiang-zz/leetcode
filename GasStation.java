public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int min = 0;
        int index = 0;
        int netGas = 0;
        for (int i = 0; i < n; i++) {
            netGas += gas[i] - cost[i];
            if (netGas < min) {
                index = i+1;
                min = netGas;
            }
        }
        if (netGas < 0) {
            return -1;
        }
        return index;
    }
}
