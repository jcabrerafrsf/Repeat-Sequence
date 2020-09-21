package com.possumus.repeatsequence.service.impl;

import com.possumus.repeatsequence.domain.Sequence;
import com.possumus.repeatsequence.service.PalindromeService;
import org.springframework.stereotype.Service;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    @Override
    public boolean isPalindrome(Sequence sequence) {
        return sequence.getSequence().equalsIgnoreCase(new StringBuilder(sequence.getSequence()).reverse().toString());
    }

}
