package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		int pair = 0;
		Stack<Character> brackets = new Stack<Character>();
		
		for(int i = 0; i < b.length(); i++) {
			brackets.push(b.charAt(i));
		}
		
		for(int i = brackets.size() - 1; i >= 0 ; i--) {
			char popped = brackets.pop();
			if(popped == '}') {
				pair++;
			} else if(popped == '{') {
				pair--;
				if(pair < 0) {
					break;
				}
			}
		}
		
		if(pair == 0) {
			return true;
		} else {
			return false;
		}
	}

}