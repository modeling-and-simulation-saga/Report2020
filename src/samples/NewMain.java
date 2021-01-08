package samples;

import java.io.IOException;
import method.Uniform;
/**
 *
 * @author tadaki
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) throws IOException {
        double min = 0.;//下限
        double max = 1.;//上限
        Uniform sys = new Uniform(min,max);
        int numBin = 100;//binの数
        int numSamples = 100000;//乱数の総数
        GenerateSample sample = new GenerateSample(min,max,numBin,numSamples);
        //乱数生成
        sample.generate(sys);
        //出力
        sample.outputHistogram("uniform.txt");

    }
    
}
