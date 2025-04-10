class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String srt = Long.toString(start-1);
        String fnsh = Long.toString(finish);
        return calc(fnsh, s, limit) - calc(srt, s, limit);
    }

    private long calc(String x, String s, int limit){
        if(x.length() < s.length()){
            return 0;
        }
        if(x.length() == s.length()){
            return x.compareTo(s) >= 0 ? 1 : 0;
        }

        String suffix = x.substring(x.length() - s.length());
        long cnt = 0;
        int preLen = x.length() - s.length();

        for(int i=0;i<preLen;i++){
            int digit = x.charAt(i)-'0';
            if(limit < digit){
                cnt += (long)Math.pow(limit+1, preLen-i);
                return cnt;
            }
            cnt += (long)(digit) * (long)Math.pow(limit+1,preLen-1-i);
        }
        if(suffix.compareTo(s)>=0){
            cnt++;
        }
        return cnt;
    }
}