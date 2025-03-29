package lotto.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.LottoRank;
import lotto.model.Lotto;

public class View {

    public void showMessage(String message){
        System.out.println(message);
    }
    public void showError(String message){
        System.err.println(message);
    }

    public void printResult(int gold, HashMap<LottoRank, Integer> lottoResult) {
        float sum = 0;
        System.out.println("당첨 통계");
        System.out.println("---------");
        for(LottoRank rank : LottoRank.values()){
            System.out.println(rank.getPrizeText()+" - "+lottoResult.get(rank)+"개");
            sum += rank.getPrize()*lottoResult.get(rank);
        }
        System.out.println("총 수익률은 "+ (float)Math.round(sum/gold*1000)/10+"%입니다.");
    }

    public void printLotto(ArrayList<Lotto> lottos) {
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for(int i=0; i<lottos.size(); i++){
            System.out.println(lottos.get(i).getNumbers());
        }
    }
    public String inputString(String str) {
        showMessage(str);
        return Console.readLine();
    }
    
}
