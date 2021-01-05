package fr.travelfactory.test.test.model.service;

import fr.travelfactory.test.test.model.domain.Campaign;
import fr.travelfactory.test.test.model.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;


    public Campaign save(Campaign campaign){
        return campaignRepository.save(campaign);
    }

    public Optional<Campaign> findById(Long id){
        return campaignRepository.findById(id);
    }


}
