package LISTAS;


import java.util.NoSuchElementException;

/**
 *
 * @author Julio Arriaga
 */
public class StackUtils {

    public static void main(String[] args) {
        System.out.println(isBalanced("(9+1)")); // true
        System.out.println(isBalanced("[1*(2+3)")); // false
        System.out.println(isBalanced("[1*(2+3))")); // false
        System.out.println(isBalanced("[1*(2+3)]")); // true
    }

    public static boolean isBalanced(String expression) {
        ListStack<Character> s = new ListStack<>();
        for (int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    s.push(expression.charAt(i));
                    break;
                case ')':
                case ']':
                case '}':
                    try {
                        if (!match(s.pop(), expression.charAt(i))) {
                            return false;
                        }
                    } catch (NoSuchElementException e) {
                        return false;
                    }
            }
        }
        return s.isEmpty();
    }

    public static boolean match(char a, char b) {
        switch (a) {
            case '(':
                return b == ')';
            case '[':
                return b == ']';
            case '{':
                return b == '}';
            default:
                return false;
        }
    }
}