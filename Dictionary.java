import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 Dictionary プログラム
 
   実行方法： java Dictionary

 */
public class Dictionary {
    // ファイルパス … カレントディレクトリにあるファイル
    final static String INPUT_FILE_PATH = "dictionary.txt";

    // 単語を保持しておくArray
    private List<String> wordsArray;

    /**
      constructor
     */
    public Dictionary() {
        // arrayの初期化
        wordsArray = new ArrayList<String>();
    }

    /**
      出力関数
     */
    public void output() {
        // 出力するものがあるかチェック
        if(wordsArray.size() > 0) {
            // arrayにある単語をループで出力する
            for(int wordIndex = 0; wordIndex < wordsArray.size(); wordIndex++) {
                System.out.println(wordsArray.get(wordIndex));
            }
        }
        else {
            //TODO 出力なしの場合にどうするか、後で決定
            // System.out.println("なし");
        }
    }

    /**
     入力関数 
     @param filePath ファイルのパス
     */
    public void inputFromFile(String filePath) {
        // Fileオブジェクト作成
        File inputFile = new File(filePath );

        // テキストファイルを読み込む
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(inputFile);
            // BufferedReaderで1行ずつ読み込む
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                wordsArray.add(data);
            }
        } catch (FileNotFoundException e) {
            //TODO エラー処理は未実装
            e.printStackTrace();
        } catch (IOException e) {
            //TODO エラー処理は未実装
            e.printStackTrace();
        }
    }

    /**
      main関数
     */
    public static void main(String[] args) {
        // インスタンス作成
        Dictionary dictionary = new Dictionary();
        // ファイルから入力
        dictionary.inputFromFile(INPUT_FILE_PATH);
        // 出力
        dictionary.output();
    }
}
