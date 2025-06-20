class Solution {
    public int maxDistance(String s, int k) {
        int ans = 0;
        int south=0, north=0, east=0, west=0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'N') north++;
            else if (ch == 'S') south++;
            else if (ch == 'E') east++;
            else if (ch == 'W') west++;

            int x = Math.abs(north - south);
            int y = Math.abs(east - west);
            int manDis = x + y;
            int dis = manDis + Math.min(2*k, i+1-manDis);
            ans = Math.max(ans, dis);
        }
        return ans;
    }
}