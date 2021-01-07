package observe;

import histogram.Histogram;
import java.awt.geom.Point2D;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import method.Uniform;
import myLib.utils.FileIO;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Uniform myRandom = new Uniform(0, 1);
        int sampleSize = 100;
        int numSamples = 100000;
        Histogram histogram = new Histogram(30, 70, 100);
        CentralLimitingTheorem sys = new CentralLimitingTheorem(myRandom, sampleSize);
        sys.generateHistogram(histogram, numSamples);
        List<Point2D.Double> plist = histogram.calculateFrequency();

        String filename = "histogram.txt";
        try ( BufferedWriter out = FileIO.openWriter(filename)) {
            for (Point2D.Double p : plist) {
                FileIO.writeSSV(out, p.x, p.y);
            }
        }
    }

}
