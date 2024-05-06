package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con el siguiente id: " + id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = getStudentById(id);
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setDateOfBirth(updatedStudent.getDateOfBirth());
        existingStudent.setCreatedAt(updatedStudent.getCreatedAt());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
