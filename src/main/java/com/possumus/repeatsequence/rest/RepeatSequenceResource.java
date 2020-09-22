package com.possumus.repeatsequence.rest;

import com.possumus.repeatsequence.domain.Sequence;
import com.possumus.repeatsequence.dto.ResponseDTO;
import com.possumus.repeatsequence.service.RepeatSequenceService;
import com.possumus.repeatsequence.util.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

/**
 * REST controller for managing repeat sequence alphanumeric.
 * @author jcabrera
 */
@RestController
@RequestMapping("/api")
public class RepeatSequenceResource {

    private final Logger log = LoggerFactory.getLogger(RepeatSequenceResource.class);

    private final RepeatSequenceService repeatSequenceController;

    @Autowired
    public RepeatSequenceResource(RepeatSequenceService repeatSequenceController) {
        this.repeatSequenceController = repeatSequenceController;
    }

    /**
     * Rest Method that return a sequence without repeated subsequences.
     * @param sequence Sequence: general string sequence
     * @return ResponseDTO object.
     */
    @PostMapping("/remove-seq-repeat")
    public ResponseDTO removeSeqRepeat(@RequestBody Sequence sequence){
        try{
            return new ResponseDTO(
                    true,
                    repeatSequenceController.getSequence(sequence),
                    null,
                    null
            );
        }catch (BusinessException be){
            log.error("BusinessException: ", be.getMessage());
            return new ResponseDTO(
                    false,
                    null,
                    be.getMessage(),
                    be
            );
        }
        catch (Exception ex){
            log.error("Exception: ", ex.getMessage());
            return new ResponseDTO(
                    false,
                    null,
                    ex.getMessage(),
                    ex
            );
        }
    }

    /**
     * Rest Method that verifies status of the api.
     * @return ResponseEntity object.
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String,String>> checkStatus(){
        Map<String,String> map = new LinkedHashMap<>();
        map.put("Estado","OK");
        map.put("DateTime", LocalDateTime.now().toString());
        log.info("Check status: ", map.get("Estado"));
        return ResponseEntity.ok().body(map);
    }

}
