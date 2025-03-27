package lotto.global;

public enum LottoRank {
    FIRST(6,false,2000000000),
    SECOND(5,true,30000000),
    THIRD(5,false,1500000),
    FOURTH(4,false,50000),
    FIFTH(3,false,5000);
    
    private final int count;
    private final boolean bonus;
    private final int prize;

    
    LottoRank(int count, boolean bonus,int prize) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
    }
    
    public static LottoRank valueOf(int count, boolean bonus) {
        for(LottoRank rank : values()) {
            if(rank.count == count && rank.bonus == bonus) {
                return rank;
            }
        }
        return null;
    }

    public int getCount() {
        return count;
    }
    
    public int getPrize() {
        return prize;
    }
}