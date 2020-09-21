package com.possumus.repeatsequence.service.impl;

import com.possumus.repeatsequence.domain.Sequence;
import com.possumus.repeatsequence.service.PalindromeService;
import com.possumus.repeatsequence.service.RepeatSequenceService;
import com.possumus.repeatsequence.util.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepeatSequenceServiceImpl implements RepeatSequenceService {

    @Autowired
    private PalindromeService palindromeService;

    @Override
    public String getSequence(Sequence sequenceInput) throws BusinessException {

        if(sequenceInput.getSequence() == null || sequenceInput.getSequence().isEmpty())
            throw new BusinessException("The sequence cannot be empty or null");

        if(!palindromeService.isPalindrome(sequenceInput))
            throw new BusinessException(sequenceInput.getSequence() + " is not a palindrome");

        String cadena = sequenceInput.getSequence();



        return sequenceInput.getSequence() + " is a palindrome";
    }

}
