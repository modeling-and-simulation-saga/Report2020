package observe;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import method.*;
import myLib.utils.FileIO;
import myLib.utils.Utils;

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
        for(int i=0;i<numSamples;i++){
            double oneAverage = calculateAverage();
            average += oneAverage;
            sigma += Math.pow((oneAverage-mu), 2.);           
        }
        average /= numSamples;
        sigma /= numSamples;
        sigma = Math.sqrt(sigma);       
        return new Result(sampleSize, average, sigma);
    }
    
    /**
     * 標本の平均を計算
     * @return 
     */
    private double calculateAverage(){
        double average = 0;
        for(int i=0;i<sampleSize;i++){
            average += myRandom.nextDouble();
        }
        average /= sampleSize;
        return average;
    }

    public static void main(String args[]) throws IOException {
        int numSamples = 1000;//標本数
        int size = 16;//標本の初期値
        int maxSize = 1000000;
        List<Result> resultList = Utils.createList();
        Uniform myRandom = new Uniform(0, 1);
        double mu = 0.5;//母集団の平均
        while (size < maxSize) {//各標本サイズでシミュレーション
            LawOfLargeNumber sys = new LawOfLargeNumber(myRandom, mu, size);
            resultList.add(sys.calculate(numSamples));
            size *= 2;
        }

        //結果をファイルへ出力
        String filename = "output.txt";
        try ( BufferedWriter out = FileIO.openWriter(filename)) {
            for (Result p : resultList) {
                out.write(p.toString());
                out.newLine();
            }
        }

    }
}
