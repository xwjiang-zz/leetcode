//1st solution uses a priority queue and graph traversal
//2nd Solution: dp. ref: https://github.com/leetcoders/LeetCode/blob/master/DungeonGame.h
public class Solution {
    public class QueueEntry{
        int x;
        int y;
        int hurt;
        int pathSum;
        QueueEntry(int _x, int _y, int _hurt, int _pathSum) {
            x = _x;
            y = _y;
            hurt = _hurt;
            pathSum = _pathSum;
        }
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        Queue<QueueEntry> queue = new PriorityQueue<QueueEntry>(new Comparator<QueueEntry>() {
            public int compare(QueueEntry a, QueueEntry b) {
                if (a.hurt < b.hurt) {
                    return 1;
                } else if (a.hurt == b.hurt) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        queue.add(new QueueEntry(0, 0, dungeon[0][0] >= 0 ? 0 : dungeon[0][0], dungeon[0][0]));
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, dungeon[0][0]);
        while (!queue.isEmpty()) {
            QueueEntry front = queue.poll();
            if (front.x == m-1 && front.y == n-1) {
                return -front.hurt + 1;
            }
            int num = front.x*n + front.y;
            if (map.containsKey(num) && map.get(num) > front.pathSum) {
                continue;
            }
            map.put(num, front.pathSum);
            if (front.x+1 < m) {
                int hurt = Math.min(front.pathSum + dungeon[front.x+1][front.y], front.hurt);
                int pathSum = front.pathSum + dungeon[front.x+1][front.y];
                queue.add(new QueueEntry(front.x+1, front.y, hurt, pathSum));
            }
            if (front.y+1 < n) {
                int hurt = Math.min(front.pathSum + dungeon[front.x][front.y+1], front.hurt);
                int pathSum = front.pathSum + dungeon[front.x][front.y+1];
                queue.add(new QueueEntry(front.x, front.y+1, hurt, pathSum));
            }
        }
        return 0;
    }
}

//4/10/2015
//the thought of trimming the tree using a hashmap
public class Solution {
    public class Path {
        int minSum;
        int sum;
        int x;
        int y;
        Path(int minSum, int sum, int i, int j) {
            this.minSum = minSum;
            this.sum = sum;
            this.x = i;
            this.y = j;
        }
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        PriorityQueue<Path> queue = new PriorityQueue<Path>(10, new Comparator<Path>() {
            public int compare(Path path1, Path path2) {
                return path1.minSum >= path2.minSum ? -1 : 1;
            }
        });
        queue.add(new Path(dungeon[0][0], dungeon[0][0], 0, 0));
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (true) {
            Path front = queue.poll();
            int i = front.x;
            int j = front.y;
            if (i == m-1 && j == n-1) {
                return front.minSum < 0 ? -front.minSum + 1 : 1;
            }
            int num = i * n + j;
            if (map.containsKey(num) && map.get(num) >= front.sum) {
                continue;
            }
            map.put(num, front.sum);
            if (i + 1 < m) {
                int sum = front.sum + dungeon[i+1][j];
                int minSum = Math.min(front.minSum, sum);
                queue.add(new Path(minSum, sum, i+1, j));
            }
            if (j + 1 < n) {
                int sum = front.sum + dungeon[i][j+1];
                int minSum = Math.min(front.minSum, sum);
                queue.add(new Path(minSum, sum, i, j+1));
            }
        }
    }
}

//dynamic programming
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = dungeon[m-1][n-1] > 0 ? 1 : -dungeon[m-1][n-1] + 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                int minExit = 10000;
                if (i < m - 1) {
                    minExit = Math.min(minExit, dp[i+1][j]);
                }
                if (j < n - 1) {
                    minExit = Math.min(minExit, dp[i][j+1]);
                }
                dp[i][j] = Math.max(1, minExit - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
