package largeNumberSamples;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import method.Uniform;
import myLib.utils.FileIO;
import myLib.utils.Utils;
import observe.LawOfLargeNumber;
import observe.Result;

/**
 *
 * @author tadaki
 */
public class SimpleUniform {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
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
