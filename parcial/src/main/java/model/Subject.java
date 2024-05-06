package model;

public class Subject {
    import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

    @Entity
    public class Subject {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String professorName;

        public Subject() {
        }

        public Subject(String name, String professorName) {
            this.name = name;
            this.professorName = professorName;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProfessorName() {
            return professorName;
        }

        public void setProfessorName(String professorName) {
            this.professorName = professorName;
        }
    }

}
