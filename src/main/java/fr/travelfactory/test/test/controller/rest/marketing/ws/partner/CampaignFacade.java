package fr.travelfactory.test.test.controller.rest.marketing.ws.partner;

import fr.travelfactory.test.test.controller.dto.CampaignDto;
import fr.travelfactory.test.test.model.domain.Campaign;
import fr.travelfactory.test.test.model.service.CampaignService;
import fr.travelfactory.test.test.utils.converters.CampaignConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CampaignFacade {

    @Autowired
    private CampaignConverter campaignConverter;
    @Autowired
    private CampaignService campaignService;


    public ResponseEntity<Object> updateCampaign(Long campaignId, CampaignDto campaignDto) {
        campaignDto.setId(campaignId);
        Campaign campaign = campaignConverter.convert(campaignDto);
        campaignService.save(campaign);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Object> registrationCampaign(Long campaignId, CampaignDto campaignDto) {
        campaignDto.setId(campaignId);

        Optional<Campaign> campaignOptional = campaignService.findById(campaignId);

        if (campaignOptional.isEmpty()){
            return ResponseEntity.ok().body("ok");
        }
        return ResponseEntity.status(409).body("ko");

    }
}
