package com.possumus.repeatsequence.service.impl;

import com.possumus.repeatsequence.domain.Sequence;
import com.possumus.repeatsequence.service.RepeatSequenceService;
import com.possumus.repeatsequence.util.BusinessException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertThrows;

@SpringBootTest
class RepeatSequenceServiceImplTest {

    @Autowired
    RepeatSequenceService repeatSequenceService;

    @Before
    public void setUp(){
    }

    @Test
    void testCompareStringWhenPalindrome() throws BusinessException {
        Sequence seq1 = new Sequence();
        seq1.setSequence("malayalam");
        Assert.assertEquals("mym", repeatSequenceService.getSequence(seq1));

        seq1.setSequence("rotomotor");
        Assert.assertEquals("rmr", repeatSequenceService.getSequence(seq1));

        seq1.setSequence("anana");
        Assert.assertEquals("a", repeatSequenceService.getSequence(seq1));
    }

    @Test()
    void testFailIsNotPalindrome() {
        Sequence seq1 = new Sequence();
        seq1.setSequence("jcabrera");

        Exception exception = assertThrows(BusinessException.class, () -> {
            repeatSequenceService.getSequence(seq1);
        });

        String expectedMessage = "jcabrera is not a palindrome";
        String actualMessage = exception.getMessage();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

}