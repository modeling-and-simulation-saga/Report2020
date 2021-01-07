package samples;

import histogram.Histogram;
import java.awt.geom.Point2D;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import myLib.utils.FileIO;

/**
 *
 * @author tadaki
 */
public class GenerateSample {

    private final double min;
    private final double max;
    private final int numSamples;
    private final Histogram histogram;

    public GenerateSample(double min, double max, int numBin, int numSamples) {
        this.min = min;
        this.max = max;
        this.numSamples = numSamples;
        histogram = new Histogram(min, max, numBin);
    }

    public void generate(Random random) {
        for (int i = 0; i < numSamples; i++) {
            double x = random.nextDouble();
            histogram.put(x);
        }
    }

    public void outputHistogram(String filename) throws IOException {
        //ヒストグラムを出力
        List<Point2D.Double> plist = histogram.calculateFrequency();
        try (BufferedWriter out = FileIO.openWriter(filename)) {
            for (Point2D.Double p : plist) {
                FileIO.writeSSV(out, p.x, p.y);
            }
            out.close();
        }
    }

}
