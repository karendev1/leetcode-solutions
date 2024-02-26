import java.util.HashMap;
import java.util.Map;

class SolutionRoman {

    public static int romanToInt(String s) {
        if (s.length() < 1 || s.length() > 15) {
            throw new IllegalArgumentException("Invalid string length"); // Handle invalid input
        }

        Map<Character, Integer> mapRoman = new HashMap<Character, Integer>(); // Use HashMap for better performance
        mapRoman.put('I', 1);
        mapRoman.put('V', 5);
        mapRoman.put('X', 10);
        mapRoman.put('L', 50);
        mapRoman.put('C', 100);
        mapRoman.put('D', 500);
        mapRoman.put('M', 1000);

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); //obtem o caracter atual a partir da posição i
            int value = mapRoman.get(ch); // pega o valor equivalente no map
            if (value == 0) {
                throw new IllegalArgumentException("Invalid Roman numeral character: " + ch);
            }

            if (i < s.length() - 1 && value < mapRoman.get(s.charAt(i + 1))) {
                num -= value;
            } else {
                num += value;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        String romanNumeral = "MCMXCIV";
        int num = romanToInt(romanNumeral);
        System.out.println("Roman numeral " + romanNumeral + " is equivalent to " + num);
    }
}
