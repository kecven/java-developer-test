package fr.travelfactory.test.test.controller.rest.marketing.ws.partner;


import fr.travelfactory.test.test.controller.dto.CampaignDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
}
