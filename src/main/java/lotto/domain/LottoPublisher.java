package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPublisher {

    private int purchaseAmount;
    private List<Lotto> publishLotto;

    public LottoPublisher(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.publishLotto = publishLottos(getBuyLottoCount());
    }

    public LottoPublisher(List<Lotto> publishLotto) {
        this.publishLotto = publishLotto;
    }

    public LottoPublisher(int purchaseAmount, List<Lotto> publishLotto) {
        this.purchaseAmount = purchaseAmount;
        this.publishLotto = publishLotto;
    }

    public LottoPublisher() {
    }

    void validatePurchaseAmount(int amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("투입금액은 0이하의 숫자를 입력할 수 없습니다.");
        }
        if (0 < amount%1000) {
            throw new IllegalArgumentException("투입금액은 1000으로 나누었을때 나머지가 없어야 합니다.");
        }
    }

    int getBuyLottoCount() {
        return purchaseAmount/Lotto.AMOUNT;
    }

    List<Rank> getPublishLottoRanks(WinnerLotto winnerLotto) {
        List<Rank> lottoRanks = new ArrayList<>();
        for (Lotto lotto : publishLotto) {
            lotto.setRank(winnerLotto.getNumbers());
            lottoRanks.add(lotto.getRank());
        }
        return lottoRanks;
    }

    double getRevenueRatio(int rewardWinningMoney) {
        double revenueRatio = (double)rewardWinningMoney / (double)purchaseAmount;
        revenueRatio = Double.parseDouble(String.format("%.2f", revenueRatio));

        return revenueRatio;
    }

    private List<Lotto> publishLottos(int buyCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < buyCount; count++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Lotto> getPublishLotto() {
        return publishLotto;
    }
}
