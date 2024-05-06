import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject no encontrada con el id: " + id));
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(Long id, Subject updatedSubject) {
        Subject existingSubject = getSubjectById(id);
        existingSubject.setName(updatedSubject.getName());
        existingSubject.setProfessorName(updatedSubject.getProfessorName());
        return subjectRepository.save(existingSubject);
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
