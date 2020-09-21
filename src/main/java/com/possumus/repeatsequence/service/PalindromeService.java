package com.possumus.repeatsequence.service;

import com.possumus.repeatsequence.domain.Sequence;

@FunctionalInterface
public interface PalindromeService {
    boolean isPalindrome(Sequence sequence);
}
