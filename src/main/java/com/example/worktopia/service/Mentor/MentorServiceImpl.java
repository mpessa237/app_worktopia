import com.example.worktopia.entity.Mentor;
import com.example.worktopia.exception.ResourceNotFoundException;
import com.example.worktopia.repository.MentorRepo;
import com.example.worktopia.service.Mentor.MentorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class MentorServiceImpl implements MentorService {

    private final MentorRepo mentorRepo;

    public MentorServiceImpl(MentorRepo mentorRepo) {
        this.mentorRepo = mentorRepo;
    }

    @Override
    public Mentor addMentor(Mentor mentor) {
        return this.mentorRepo.save(mentor);
    }

    @Override
    public List<Mentor> getAllMentor() {
        return this.mentorRepo.findAll();
    }

    @Override
    public Mentor getMentorByNom(String nom) {

        Optional<Mentor> mentor = this.mentorRepo.findByNom(nom);
        if (mentor.isEmpty())
            throw new ResourceNotFoundException("mentor not found");
        return mentor.get();
    }
    @Override
    public Page<Mentor> getMentor(int offset, int pageSize) {
        Pageable pageable = PageRequest.of(offset,pageSize);
        return this.mentorRepo.findAll(pageable);
    }

    @Override
    public Mentor getMentorById(Integer mentorId) {
        Optional<Mentor>mentor = this.mentorRepo.findById(mentorId);
        if (mentor .isEmpty())
            throw new RuntimeException("le mentor avec cette id n'existe pas");

        return mentor.get();
    }

    @Override
    public Mentor updateMentor(Mentor mentor, Integer mentorId) {

        Optional<Mentor> mentorToEdit = this.mentorRepo.findById(mentorId);
        if(mentorToEdit.isEmpty())
            throw new ResourceNotFoundException("mentor not found");
        if (mentor.getNom()!=null)
            mentorToEdit.get().setNom(mentor.getNom());
        if (mentor.getPrenom()!=null)
            mentorToEdit.get().setPrenom(mentor.getPrenom());
        return this.mentorRepo.saveAndFlush(mentorToEdit.get());

    }

    @Override
    public void deleteMentor(Integer mentorId) {
        this.mentorRepo.delete(this.mentorRepo.findById(mentorId)
                .orElseThrow(()-> new ResourceNotFoundException("mentor not found")));
    }
}
