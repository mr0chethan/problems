class leetcode_coin_change {
    public static int coinChange(int[] coins, int amount) {
        int[] minNum = {(int)1e9};
        int count = infSupTarSumComb( coins, 0, amount, minNum, 0);
        if( count == 0 ) return -1;
        return minNum[0];
    }
    private static int infSupTarSumComb( int[] arr, int si, int tar, int[] minNum, int num){
        if( tar == 0 ){
            if( num < minNum [0] ){
                minNum [0] = num;
            }
            return 1;
        }
        int count =0;
        for( int i = si; i < arr.length; i++){
            if( tar - arr[ i ] >= 0){
                count += infSupTarSumComb( arr, i, tar - arr[ i ], minNum, num + 1);
            }
        }
        return count;
    }
    public static void main( String[] args ){
        int[] coins={411,412,413,414,415,416,417,418,419,420,421,422};
        int amount=9864;
        System.out.println( coinChange( coins, amount ));
    }
}