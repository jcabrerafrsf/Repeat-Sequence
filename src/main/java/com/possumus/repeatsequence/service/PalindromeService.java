package com.possumus.repeatsequence.service;

import com.possumus.repeatsequence.domain.Sequence;

/**
 * Interface for managing the service of palindrome.
 * @author jcabrera
 */
@FunctionalInterface
public interface PalindromeService {
    boolean isPalindrome(Sequence sequence);
}
