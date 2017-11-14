package me.dolia.ads.string;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class StringsTest {

  @Test
  void shouldCheckForBalancedParenthesesBalancedExpression() {
    String exp = "[()]{}{[()()]()}";

    boolean result = Strings.isBalancedParentheses(exp);

    assertTrue(result, "The balanced string is considered as not-balanced");
  }

  @Test
  void shouldCheckForBalancedParenthesesBalancedExpressionWithWords() {
    String exp = "[(Hello) some  date]{}{[()here()]()}";

    boolean result = Strings.isBalancedParentheses(exp);

    assertTrue(result, "The balanced string is considered as not-balanced");
  }

  @Test
  void shouldCheckForBalancedParenthesesNotBalancedExpression() {
    String exp = "[(])";

    boolean result = Strings.isBalancedParentheses(exp);

    assertFalse(result, "The not-balanced string is considered as balanced");
  }

  @Test
  void shouldCheckForBalancedParenthesesNotBalancedExpressionWithCloseParenthesisAtTheBeginning() {
    String exp = "}[()]{}{[()()]()}{";

    boolean result = Strings.isBalancedParentheses(exp);

    assertFalse(result, "The not-balanced string is considered as balanced");
  }

  @Test
  void shouldCheckForBalancedParenthesesNotBalancedExpressionWithOpenParenthesisAtTheEnd() {
    String exp = "[()]{}{[()()]()}{";

    boolean result = Strings.isBalancedParentheses(exp);

    assertFalse(result, "The not-balanced string is considered as balanced");
  }

  @Test
  void shouldThrowExceptionOnCheckForBalancedParenthesesIfExpressionIsNull() {
    Executable executable = () -> Strings.isBalancedParentheses(null);

    assertThrows(NullPointerException.class, executable);
  }
}
