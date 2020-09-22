package com.possumus.repeatsequence.domain;

import lombok.*;
import org.springframework.validation.annotation.Validated;

/**
 * Domain input
 * @author jcabrera
 */

@Getter
@Setter
@NoArgsConstructor
@Validated
public class Sequence {

    private String sequence;

}
