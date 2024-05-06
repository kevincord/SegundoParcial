package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/subjectAssignments")
public class SubjectAssignmentController {

    @Autowired
    private SubjectAssignmentService subjectAssignmentService;

    @GetMapping
    public List<SubjectAssignment> getAllSubjectAssignments() {
        return subjectAssignmentService.getAllSubjectAssignments();
    }

    @GetMapping("/{id}")
    public SubjectAssignment getSubjectAssignmentById(@PathVariable Long id) {
        return subjectAssignmentService.getSubjectAssignmentById(id);
    }

    @PostMapping
    public SubjectAssignment createSubjectAssignment(@RequestBody SubjectAssignment subjectAssignment) {
        return subjectAssignmentService.createSubjectAssignment(subjectAssignment);
    }

    @PutMapping("/{id}")
    public SubjectAssignment updateSubjectAssignment(@PathVariable Long id, @RequestBody SubjectAssignment updatedSubjectAssignment) {
        return subjectAssignmentService.updateSubjectAssignment(id, updatedSubjectAssignment);
    }

    @DeleteMapping("/{id}")
    public void deleteSubjectAssignment(@PathVariable Long id) {
        subjectAssignmentService.deleteSubjectAssignment(id);
    }
}
