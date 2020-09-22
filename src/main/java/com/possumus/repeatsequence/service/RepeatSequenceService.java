package com.possumus.repeatsequence.service;

import com.possumus.repeatsequence.domain.Sequence;
import com.possumus.repeatsequence.util.BusinessException;

/**
 * Interface for managing the service of repeat sequence.
 * @author jcabrera
 */
@FunctionalInterface
public interface RepeatSequenceService {
    String getSequence(Sequence sequenceInput) throws BusinessException;
}
