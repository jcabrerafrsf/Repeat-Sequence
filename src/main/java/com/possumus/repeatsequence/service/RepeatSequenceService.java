package com.possumus.repeatsequence.service;

import com.possumus.repeatsequence.domain.Sequence;
import com.possumus.repeatsequence.util.BusinessException;

@FunctionalInterface
public interface RepeatSequenceService {
    String getSequence(Sequence sequenceInput) throws BusinessException;
}
