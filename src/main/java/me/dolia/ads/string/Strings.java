package me.dolia.ads.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class Strings {

  /* Suppresses default constructor, ensuring non-instantiability. */
  private Strings() {
  }

  /**
   * Examines whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in a given
   * expression.
   *
   * For example, the method returns {@code true} for exp = “[()]{}{[()()]()}” and {@code false} for
   * exp = “[(])”
   *
   * Complexity: O(N), S(N)
   *
   * @param exp expression to check
   * @return {@code true} if the expression is balanced, {@code false} otherwise
   * @throws NullPointerException if the {@code exp} is {@code null}
   */
  public static boolean isBalancedParentheses(String exp) {
    Deque<Character> stack = new ArrayDeque<>();
    char[] chars = exp.toCharArray();
    for (char c : chars) {
      if (isOpenParenthesis(c)) {
        stack.push(c);
      } else if (isClosedParenthesis(c)) {
        if (stack.isEmpty()) {
          return false;
        }
        char openParenthesis = stack.poll();
        if (!isCorrespondentParenthesis(openParenthesis, c)) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  private static boolean isOpenParenthesis(char c) {
    return c == '(' || c == '{' || c == '[';
  }

  private static boolean isClosedParenthesis(char c) {
    return c == ')' || c == '}' || c == ']';
  }

  private static boolean isCorrespondentParenthesis(char open, char closed) {
    return (open == '(' && closed == ')') || (open == '{' && closed == '}') || (open == '['
        && closed == ']');
  }
}
