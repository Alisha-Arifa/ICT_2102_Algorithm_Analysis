package huffman_code;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Huffman {

    static Map<Character, String> huffmanCodes = new HashMap<>();

    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            huffmanCodes.put(root.c, s);
            System.out.println(root.c + ":" + s);
            return;
        }

        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
    
    

    public static void main(String[] args) {
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charfreq = {5, 9, 12, 13, 16, 45};

        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charfreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {
            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();

            HuffmanNode f = new HuffmanNode();

            f.data = x.data + y.data;

            f.c = '-';

            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }
        printCode(root, "");

        int oriBits = 0;
        int comBits = 0;

        for (int i = 0; i < n; i++) {
            oriBits += charfreq[i] * 8;
            comBits += charfreq[i] * huffmanCodes.get(charArray[i]).length();
        }

        System.out.println("Original Bits: " + oriBits);
        System.out.println("Compressed Bits: " + comBits);

        double comPer = ((double) (oriBits - comBits) / oriBits) * 100;
        System.out.printf("Compression Percentage: %.2f%%\n", comPer);

        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
