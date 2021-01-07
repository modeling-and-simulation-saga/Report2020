package method;

import java.util.function.DoubleFunction;

/**
 * 変換法による乱数生成
 *
 * @author tadaki
 */
public class Transform extends java.util.Random {

    //確率分布の逆関数
    private final DoubleFunction<Double> invProDist;

    /**
     * コンストラクタ
     *
     * @param invProDist 確率分布の逆関数
     */
    public Transform(DoubleFunction<Double> invProDist) {
        super();
        this.invProDist = invProDist;
    }

    public Transform(DoubleFunction<Double> invProDist, long seed) {
        super(seed);
        this.invProDist = invProDist;
    }

    /**
     * 乱数を一つ生成
     *
     * @return 生成された乱数
     */
    @Override
    public double nextDouble() {
        double x = super.nextDouble();
        return invProDist.apply(x);
    }

}
