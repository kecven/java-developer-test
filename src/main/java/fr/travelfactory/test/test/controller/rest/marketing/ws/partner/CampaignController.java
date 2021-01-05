package fr.travelfactory.test.test.controller.rest.marketing.ws.partner;


import fr.travelfactory.test.test.controller.dto.CampaignDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/marketing/ws/partner/campaign")
@Validated
public class CampaignController {

    @Autowired
    private CampaignFacade campaignFacade;

    @PostMapping("/{campaignId}")
    public ResponseEntity<Object> updateCampaignById(   @PathVariable final Long campaignId,
                                                        @RequestBody @Valid final CampaignDto campaignDto) {

        return campaignFacade.updateCampaign(campaignId, campaignDto);
    }

    @PostMapping("/{campaignId}/registration")
    public ResponseEntity<Object> registrationCampaign( @PathVariable Long campaignId,
                                                        @RequestBody CampaignDto campaignDto) {
        return campaignFacade.registrationCampaign(campaignId, campaignDto);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
