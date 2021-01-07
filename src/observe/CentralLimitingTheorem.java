package observe;

import histogram.Histogram;
import java.util.Random;

/**
 *
 * @author tadaki
 */
public class CentralLimitingTheorem {

    private final Random myRandom;
    private final int sampleSize;

    public CentralLimitingTheorem(Random myRandom, int sampleSize) {
        this.myRandom = myRandom;
        this.sampleSize = sampleSize;
    }

    public void generateHistogram(Histogram histogram, int numSamples) {

    
    
    }

    /**
     * 標本の和を計算
     *
     * @return
     */
    private double calculateSum() {
        double sum = 0;

        
        
        return sum;
    }

}
