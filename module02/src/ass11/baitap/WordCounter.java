package ass11.baitap;

import java.util.Map;
import java.util.TreeMap;

public class WordCounter {
    public static void countWords(String text) {
        // Sử dụng TreeMap để lưu trữ từ và số lượng của chúng theo thứ tự trong bảng chữ cái
        Map<String, Integer> wordCountMap = new TreeMap<>();

        // Tách các từ từ chuỗi và đếm số lần xuất hiện của từ
        String[] words = text.split("\\s+");
        for (String word : words) {
            // Chuyển đổi từ thành chữ hoa hoặc chữ thường để tránh phân biệt chữ hoa chữ thường
            String formattedWord = word.toLowerCase();

            // Kiểm tra xem từ có tồn tại trong map hay không
            if (wordCountMap.containsKey(formattedWord)) {
                // Nếu từ đã tồn tại, tăng số lượng lên 1
                int count = wordCountMap.get(formattedWord);
                wordCountMap.put(formattedWord, count + 1);
            } else {
                // Nếu từ chưa tồn tại, thêm từ vào map với số lượng mặc định là 1
                wordCountMap.put(formattedWord, 1);
            }
        }

        // Hiển thị từ và số lượng của chúng
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String text = "This is a sample text sample to demonstrate word counting program";
        countWords(text);
    }
}
