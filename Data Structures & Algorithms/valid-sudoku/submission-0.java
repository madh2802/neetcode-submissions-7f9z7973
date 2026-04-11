class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, List<List<Integer>>> map = new HashMap();

        for (int i = 0; i<9; i++) {
            for (int j = 0; j<9; j++) {
                int boxNumber = findBoxNumber(i, j);
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (!addValue(map, boxNumber-1, 2, num) ||
                        !addValue(map, i, 0, num) || 
                        !addValue(map, j, 1, num)) {
                            return false;
                        }
                }
            }
        }
        return true;
    }

    public boolean addValue(Map<Integer, List<List<Integer>>> map,
                     int key, int listIndex, int num) {
        map.computeIfAbsent(key, k -> {
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                lists.add(new ArrayList<>());
            }
            return lists;
        });

        List<Integer> targetList = map.get(key).get(listIndex);

        if (!targetList.contains(num)) {
            targetList.add(num);
            return true;
        }
        else return false;
    }

    private int findBoxNumber(int row, int column) {
        if (row < 3) {
            if (column < 3){
                return 1;
            }
            else if (column < 6 && column > 2) {
                return 2;
            }
            else {
                return 3;
            }
        }
        if (row < 6) {
            if (column < 3){
                return 4;
            }
            else if (column < 6 && column > 2) {
                return 5;
            }
            else {
                return 6;
            }
        }
        else {
            if (column < 3){
                return 7;
            }
            else if (column < 6 && column > 2) {
                return 8;
            }
            else {
                return 9;
            }
        }
    }
}
