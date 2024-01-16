package com.hero.SchoolHub.service.student;

import com.hero.SchoolHub.bo.student.CreateStudentRequest;
import com.hero.SchoolHub.bo.student.StudentResponse;
import com.hero.SchoolHub.entity.GradeEntity;
import com.hero.SchoolHub.entity.StudentEntity;
import com.hero.SchoolHub.repository.GradeRepository;
import com.hero.SchoolHub.repository.StudentRepository;
import com.hero.SchoolHub.util.exceptions.BodyGuardException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.hero.SchoolHub.util.validators.validators.CompositeValidator.hasValue;
import static com.hero.SchoolHub.util.validators.validators.ValidationUtils.validate;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final GradeRepository gradeRepository;

    public StudentServiceImpl(StudentRepository studentRepository, GradeRepository gradeRepository) {
        this.studentRepository = studentRepository;
        this.gradeRepository = gradeRepository;
    }

    @Override
    public void save(List<CreateStudentRequest> request, String gradeName, String schoolName, String cityName) {
        createPreValidation(request, gradeName);
        GradeEntity grade = gradeRepository.findByGradeNameAndSchoolSchoolNameAndSchoolCityEntityCityName(gradeName, schoolName, cityName)
                .orElseThrow(() -> new BodyGuardException("No grade found with name: " + gradeName));

        List<StudentEntity> students = request.stream()
                .map(name -> StudentEntity.builder()
                        .studentName(name.getStudentName())
                        .grade(grade)
                        .build())
                .collect(Collectors.toList());

        studentRepository.saveAll(students);
    }

    @Override
    public List<StudentResponse> getAllStudents(String gradeName, String schoolName, String cityName) {
        List<StudentEntity> studentEntities = studentRepository.findAllByGradeGradeNameAndGradeSchoolSchoolNameAndGradeSchoolCityEntityCityName(
                gradeName, schoolName, cityName);
        return studentEntities.stream()
                .map(this::convertToStudentResponse)
                .collect(Collectors.toList());
    }


    private StudentResponse convertToStudentResponse(StudentEntity student) {
        StudentResponse response = new StudentResponse();
        response.setStudentName(student.getStudentName());
        return response;
    }

    public void createPreValidation(List<CreateStudentRequest> createDto, String gradeName) {
        Set<String> uniqueStudentNames = new HashSet<>();

        List<String> violations = createDto.stream()
                .flatMap(request -> Stream.of(validateStudentRequest(request, uniqueStudentNames, gradeName)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        validate(violations);
    }

    private Optional<String> validateStudentRequest(CreateStudentRequest request, Set<String> uniqueStudentNames, String gradeName) {
        String studentName = request.getStudentName();
        return !hasValue(studentName) ? Optional.of("Student name field cannot be empty") :
                uniqueStudentNames.contains(studentName) ? Optional.of("Duplicate student names are not allowed") :
                        addUniqueStudentName(uniqueStudentNames, studentName);
    }

    private Optional<String> addUniqueStudentName(Set<String> uniqueStudentNames, String studentName) {
        uniqueStudentNames.add(studentName);
        return Optional.empty();
    }
}
