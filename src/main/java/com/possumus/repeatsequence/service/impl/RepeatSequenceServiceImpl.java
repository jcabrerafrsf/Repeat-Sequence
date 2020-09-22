package com.possumus.repeatsequence.service.impl;

import com.possumus.repeatsequence.domain.Sequence;
import com.possumus.repeatsequence.service.PalindromeService;
import com.possumus.repeatsequence.service.RepeatSequenceService;
import com.possumus.repeatsequence.util.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service that find a sequence repeated into another sequence
 * @author jcabrera
 */
@Service
public class RepeatSequenceServiceImpl implements RepeatSequenceService {

    private final PalindromeService palindromeService;

    @Autowired
    public RepeatSequenceServiceImpl(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    /**
     * Method that return a sequence without repeated subsequences and verify notnull or empty and palindrome.
     * @param sequenceInput string: general string sequence
     * @return sequence without repeated subsequences
     * @throws BusinessException if sequenceInput not is a palindrome
     */
    @Override
    public String getSequence(Sequence sequenceInput) throws BusinessException {

        if(sequenceInput.getSequence() == null || sequenceInput.getSequence().isEmpty())
            throw new BusinessException("The sequence cannot be empty or null");

        if(!palindromeService.isPalindrome(sequenceInput))
            throw new BusinessException(sequenceInput.getSequence() + " is not a palindrome");

        String stringSeq = sequenceInput.getSequence().toLowerCase();

        String result = constainString(
                stringSeq.substring(0, (int) Math.ceil(stringSeq.length()/2)),
                stringSeq.substring((int) Math.ceil(stringSeq.length()/2))
        );

        return result;
    }

    /**
     * Method that return a sequence without repeated subsequences.
     * @param st1 string: first subsequence of the general string sequence
     * @param st2 string: secondary subsequence of the general string sequence
     * @return sequence without repeated subsequences
     */
    private String constainString(String st1, String st2){
        if(st2.contains(st1)){
            return st2.replace(st1, "");
        }else{
            return st1.charAt(0) + constainString(st1.substring(1), st2);
        }
    }

}
