import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 Dictionary プログラム
 
   実行方法： java Dictionary

 */
public class Dictionary {

    private final String filePath;
    private final Integer lineNum;
    // 単語を保持しておくArray
    private final List<String> wordsArray;

    /**
      constructor
     */
    public Dictionary(String filePath, Integer lineNum) {
        // arrayの初期化
        this.wordsArray = new ArrayList<String>();
        this.filePath = filePath;
        this.lineNum = lineNum;
        this.inputFromFile(filePath);
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
    private void inputFromFile(String filePath) {
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
     * プログラム実行時の引数から、ユーザーが指定した値「ファイルパス」を取得
     * @param args プログラム実行時引数
     */
    public static String getFilepath(String[] args){
        return args[0];
    }

    /**
     * プログラム実行時の引数からユーザーが指定した値を取得
     * @param args プログラム実行時引数
     */
    public static Integer getLineNo(String[] args){
        return Integer.valueOf(args[1]);
    }

    /**
      main関数
     */
    public static void main(String[] args) {
        String filepath = getFilepath(args);
        Integer lineNo = getLineNo(args);
        // インスタンス作成
        Dictionary dictionary = new Dictionary(filepath, lineNo);
        // 出力
        dictionary.output();
    }
}
