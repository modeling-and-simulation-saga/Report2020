package observe;

import java.util.Random;

/**
 *
 * @author tadaki
 */
public class LawOfLargeNumber {

    private final Random myRandom;
    private final int sampleSize;
    private final double mu;

    /**
     * コンストラクタ
     *
     * @param myRandom 母集団に従う乱数生成器
     * @param mu 母集団の平均
     * @param sampleSize 標本サイズ
     */
    public LawOfLargeNumber(Random myRandom, double mu, int sampleSize) {
        this.myRandom = myRandom;
        this.sampleSize = sampleSize;
        this.mu = mu;
    }

    /**
     * 標本平均の平均と標準偏差
     *
     * @param numSamples 標本数
     * @return
     */
    public Result calculate(int numSamples) {
        double average = 0.;
        double sigma = 0.;

        
        
        
        
        return new Result(sampleSize, average, sigma);
    }
    
    /**
     * 標本の平均を計算
     * @return 
     */
    private double calculateAverage(){
        double average = 0;

        
        
        
        return average;
    }

}
