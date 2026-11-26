class Solution {
    public boolean canAliceWin(int n) {
        int take=10, turn = 0;
        while(n>=take){
            n -= take;
            take--;
            turn++;
        }
        return turn%2==1;
    }
}