package com.example.worktopia.service.Mentore;

import com.example.worktopia.dto.Mentore.MentoreReqDTO;
import com.example.worktopia.dto.Mentore.MentoreRespDTO;
import com.example.worktopia.entity.Location;
import com.example.worktopia.entity.Mentore;
import com.example.worktopia.exeption.ResourceExistException;
import com.example.worktopia.exeption.ResourceNotFoundException;
import com.example.worktopia.mapper.MentoreMapper;
import com.example.worktopia.repository.LocationRepo;
import com.example.worktopia.repository.MentoreRepo;
import com.example.worktopia.service.Location.LocationService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MentoreServiceImpl implements MentoreService {
    private final MentoreRepo mentoreRepo;
    private final MentoreMapper mentoreMapper;
    private final LocationService locationService;
    private final LocationRepo locationRepo;

    public MentoreServiceImpl(MentoreRepo mentoreRepo, MentoreMapper mentoreMapper, LocationService locationService, LocationRepo locationRepo) {
        this.mentoreRepo = mentoreRepo;
        this.mentoreMapper = mentoreMapper;
        this.locationService = locationService;
        this.locationRepo = locationRepo;
    }

    @Override
    public MentoreRespDTO addMentore(@Valid MentoreReqDTO mentoreReqDTO) {
        Optional<Mentore> mentoreExist = this.mentoreRepo
                .fetchByEmail(mentoreReqDTO.email());
        if(mentoreExist.isPresent())
            throw new ResourceExistException("This email already exist !");
        //DTOS
        Mentore mentore = this.mentoreMapper.fromMentoreReqDTO(mentoreReqDTO);
        mentore.setCreatedAt(new Date());
        mentore.setStatus(true);
        //LIAISON DES DONNES
        Location location= this.mentoreMapper
                .fromLocationReqDTO(mentoreReqDTO.getLocationReqDTO());

        mentore.setLocation(this.locationService.addLocation(location));
        

        return this.mentoreMapper.fromMentore(this.mentoreRepo.save(mentore)) ;

    }

    @Override
    public List<Mentore> getMentores() {
        return this.mentoreRepo.findAll();
    }

    @Override
    public Page<MentoreRespDTO> getMentores(int offset, int pageSize) {

        return this.mentoreRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC, "createdAt")))
                .map(this.mentoreMapper::fromMentore);

    }

    @Override
    public Mentore getMentoreById(Integer mentoreId) {

        return this.mentoreRepo.findById(mentoreId).orElseThrow(
                ()-> new ResourceNotFoundException("Mentoré not found !")
        );
    }

    @Override
    public Mentore getMentoreByEmail(String email) {
        return this.mentoreRepo.findByEmail(email).orElseThrow(
                ()-> new ResourceNotFoundException("Mentoré not found !")
        );
    }

    @Override
    public Mentore getMentoreByFirstnameAndLastname(String firstname, String lastname) {
        return  this.mentoreRepo.rechercher(firstname,lastname).orElseThrow(
                ()-> new ResourceNotFoundException("Mentoré not found !")
        );

    }


    @Override
    public Mentore updateMentore(Mentore mentore, Integer mentoreId) {

        //Rechercher le client
        Optional<Mentore> mentoreToEdit = this.mentoreRepo.findById(mentoreId);
        if(mentoreToEdit.isEmpty())
            throw new ResourceNotFoundException("Mentoré not found !");
        //Modidier les informations du clients
        if(mentore.getFirstname()!=null)
            mentoreToEdit.get().setFirstname(mentore.getFirstname());
        if(mentore.getLastname()!=null)
            mentoreToEdit.get().setLastname(mentore.getLastname());
        if(mentore.getPhone()!=null)
            mentoreToEdit.get().setPhone(mentore.getPhone());
        if(mentore.getEmail()!=null)
            mentoreToEdit.get().setEmail(mentore.getEmail());
        mentoreToEdit.get().setUpdatedAt( new Date());
        //Sauvegarder les modifications
        return this.mentoreRepo.saveAndFlush(mentoreToEdit.get());
    }

    @Override
    public void deleteMentore(Integer mentoreId) {
        Mentore mentore = this.mentoreRepo.findById(mentoreId)
                .orElseThrow(()->new ResourceNotFoundException("Mentoré not found"));
        this.mentoreRepo.delete(mentore);
    }
}