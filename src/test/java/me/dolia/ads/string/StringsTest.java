package me.dolia.ads.string;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
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

  @Test
  void shouldReverseStringOfEvenLength() {
    String str = "test";
    String expected = "tset";

    String result = Strings.reverse(str);

    assertThat(result, notNullValue());
    assertThat(result, equalTo(expected));
  }

  @Test
  void shouldReverseStringOfOddLength() {
    String str = "final";
    String expected = "lanif";

    String result = Strings.reverse(str);

    assertThat(result, notNullValue());
    assertThat(result, equalTo(expected));
  }

  @Test
  void shouldThrowExceptionIfStringIsNull() {
    Executable executable = () -> Strings.reverse(null);

    assertThrows(NullPointerException.class, executable);
  }
}
