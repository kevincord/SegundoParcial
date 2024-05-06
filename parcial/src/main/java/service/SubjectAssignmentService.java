import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubjectAssignmentService {

    @Autowired
    private SubjectAssignmentRepository subjectAssignmentRepository;

    public List<SubjectAssignment> getAllSubjectAssignments() {
        return subjectAssignmentRepository.findAll();
    }

    public SubjectAssignment getSubjectAssignmentById(Long id) {
        return subjectAssignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject Assignment no encontrada con el id: " + id));
    }

    public SubjectAssignment createSubjectAssignment(SubjectAssignment subjectAssignment) {
        return subjectAssignmentRepository.save(subjectAssignment);
    }

    public SubjectAssignment updateSubjectAssignment(Long id, SubjectAssignment updatedSubjectAssignment) {
        SubjectAssignment existingSubjectAssignment = getSubjectAssignmentById(id);
        existingSubjectAssignment.setSubjectId(updatedSubjectAssignment.getSubjectId());
        existingSubjectAssignment.setStudentId(updatedSubjectAssignment.getStudentId());
        return subjectAssignmentRepository.save(existingSubjectAssignment);
    }

    public void deleteSubjectAssignment(Long id) {
        subjectAssignmentRepository.deleteById(id);
    }
}
