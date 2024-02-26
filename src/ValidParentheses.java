import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class ValidParentheses {

    public static boolean isValid(String s) {
        HashMap<Character, Character> charPairs = new HashMap<>();
        charPairs.put(')', '(');
        charPairs.put('}', '{');
        charPairs.put(']', '[');

        Stack<Character> open = new Stack<>();
        for (int c = 0; c < s.length(); c++) {
            char currentChar = s.charAt(c);
            if (charPairs.containsKey(currentChar)) {
                if (open.empty() || open.pop() != charPairs.get(currentChar)) {
                    return false;
                }
            } else {
                open.push(currentChar);
            }
        }

        return open.empty();
    }


    public static void main(String[] args) {
        String test = "{[]}";
        System.out.println(isValid(test));
    }
}
