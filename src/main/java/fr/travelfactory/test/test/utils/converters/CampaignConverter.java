package fr.travelfactory.test.test.utils.converters;

import fr.travelfactory.test.test.controller.dto.CampaignDto;
import fr.travelfactory.test.test.model.domain.Campaign;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class CampaignConverter implements Converter<CampaignDto, Campaign> {

    @Override
    public Campaign convert(CampaignDto source) {
        Campaign campaign = new Campaign();
        campaign.setId(source.getId());
        campaign.setCampaignName(source.getCampaignName());
        campaign.setPhone(source.getPhone());
        campaign.setMail(source.getMail());
        return campaign;
    }
}
