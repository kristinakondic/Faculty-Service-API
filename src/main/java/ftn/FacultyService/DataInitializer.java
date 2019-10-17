package ftn.FacultyService;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ftn.FacultyService.entity.Exam;
import ftn.FacultyService.entity.ExamParticipation;
import ftn.FacultyService.entity.ExamPeriod;
import ftn.FacultyService.entity.FieldsOfStudy;
import ftn.FacultyService.entity.Professor;
import ftn.FacultyService.entity.Role;
import ftn.FacultyService.entity.Student;
import ftn.FacultyService.entity.Subject;
import ftn.FacultyService.entity.TypeOfExam;
import ftn.FacultyService.entity.User;
import ftn.FacultyService.repository.ExamParticipationRepository;
import ftn.FacultyService.repository.ExamPeriodRepository;
import ftn.FacultyService.repository.ExamRepository;
import ftn.FacultyService.repository.FieldsOfStudyRepository;
import ftn.FacultyService.repository.PaymentRepository;
import ftn.FacultyService.repository.ProfessorRepository;
import ftn.FacultyService.repository.StudentRepository;
import ftn.FacultyService.repository.SubjectRepository;
import ftn.FacultyService.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationRunner {

	@Autowired
	UserRepository userRepo;
	@Autowired
	SubjectRepository subjectRepo;
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	ProfessorRepository professorRepo;
	@Autowired
	PaymentRepository paymentRepo;
	@Autowired
	ExamRepository examRepo;
	@Autowired
	FieldsOfStudyRepository fieldsOfStudyRepo;
	@Autowired
	ExamPeriodRepository examPeriodRepo;
	@Autowired
	ExamParticipationRepository examParticipationRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//UserAdmin
		User u0 = new User();
		u0.setAddress("Mise Dimitrijevica 12");
		u0.setCreationDate(new Date());
		u0.setEmail("aa@a.a");
		u0.setIdentityNo("1231231231231");
		u0.setName("Kristina");
		u0.setPassword("$2a$10$GCAW1cxizCNL8QoQwZzH1OCVhayIkz0LRKfivQMkIsFkzKgUGoAqC");
		u0.setRole(Role.ADMIN);
		u0.setSurname("Kondic");
		userRepo.save(u0);
		
		//User1Student
		User u1 = new User();
		u1.setAddress("Mise Dimitrijevica 1");
		u1.setCreationDate(new Date());
		u1.setEmail("a@a.a");
		u1.setIdentityNo("1231231231231");
		u1.setName("Tina");
		u1.setPassword("$2a$10$GCAW1cxizCNL8QoQwZzH1OCVhayIkz0LRKfivQMkIsFkzKgUGoAqC");
		u1.setRole(Role.STUDENT);
		u1.setSurname("Kondic");
		userRepo.save(u1);
		
		//Student 1
		Student s1 = new Student();
		s1.setIndexNo("SF54/2016");
		s1.setYearOfStudy(2016);
		u1.setStudent(s1);
		studentRepo.save(s1);
		userRepo.save(u1);
		
		//User2Professor
		User u2 = new User();
		u2.setAddress("Zmaj Jovina 12");
		u2.setCreationDate(new Date());
		u2.setEmail("b@b.b");
		u2.setIdentityNo("1231231231231");
		u2.setName("Marko");
		u2.setPassword("$2a$10$GCAW1cxizCNL8QoQwZzH1OCVhayIkz0LRKfivQMkIsFkzKgUGoAqC");
		u2.setRole(Role.PROFESSOR);
		u2.setSurname("Markovic");
		userRepo.save(u2);
		
		//Professor1
		Professor p1 = new Professor();
		p1.setType("professor");
		u2.setProfessor(p1);
		professorRepo.save(p1);
		userRepo.save(u2);
		
		//ExamPeriod1
		ExamPeriod ep1 = new ExamPeriod();
		ep1.setEndDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20190128" ));
		ep1.setStartDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20190120" ));
		ep1.setName("Januarski");
		examPeriodRepo.save(ep1);
		
		//FieldsOfStudy1
		FieldsOfStudy f1 = new FieldsOfStudy();
		f1.setName("Elektrotehnika i racunarstvo");
		fieldsOfStudyRepo.save(f1);
		
		//Subject1
		Subject sub1 = new Subject();
		sub1.setEspb("8");
		sub1.setFieldsOfStudy(f1);
		sub1.setName("Programiranje 1");
		sub1.setSubjectNo("123");
		sub1.setYear(2019);
		subjectRepo.save(sub1);
		
		//Subject2
		Subject sub2 = new Subject();
		sub2.setEspb("8");
		sub2.setFieldsOfStudy(f1);
		sub2.setName("Programiranje 2");
		sub2.setSubjectNo("124");
		sub2.setYear(2019);
		subjectRepo.save(sub2);
		
		//Subject3
		Subject sub3 = new Subject();
		sub3.setEspb("6");
		sub3.setFieldsOfStudy(f1);
		sub3.setName("Matematika 2");
		sub3.setSubjectNo("121");
		sub3.setYear(2019);
		subjectRepo.save(sub3);
		s1.getStudentSubjects().add(sub3);
		s1.getStudentSubjects().add(sub2);
		s1.getStudentSubjects().add(sub1);
		studentRepo.save(s1);
		p1.getSubjects().add(sub1);
		p1.getSubjects().add(sub2);
		p1.getSubjects().add(sub3);
		professorRepo.save(p1);
		
		//Exam1
		Exam exam1 = new Exam();
		exam1.setClassroom("A1");
		exam1.setDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20180128" ));
		exam1.setExamPeriod(ep1);
		exam1.setSubject(sub1);
		exam1.setType(TypeOfExam.Ispit);
		examRepo.save(exam1);
		
		//Exam2
		Exam exam2 = new Exam();
		exam2.setClassroom("A1");
		exam2.setDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20200127" ));
		exam2.setExamPeriod(ep1);
		exam2.setSubject(sub2);
		exam2.setType(TypeOfExam.Ispit);
		examRepo.save(exam2);
		
		//Exam3
		Exam exam3 = new Exam();
		exam3.setClassroom("A1");
		exam3.setDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20200126" ));
		exam3.setExamPeriod(ep1);
		exam3.setSubject(sub3);
		exam3.setType(TypeOfExam.Kolokvijum);
		examRepo.save(exam3);
		
		//ExamParticipation1
		ExamParticipation exp1 = new ExamParticipation();
		exp1.setExam(exam1);
		exp1.setGrade(10);
		exp1.setPassed(true);
		exp1.setPoints(100);
		exp1.setStudent(s1);
		examParticipationRepo.save(exp1);
		
		//ExamParticipation2
		ExamParticipation exp2 = new ExamParticipation();
		exp2.setExam(exam2);
		exp2.setGrade(5);
		exp2.setPassed(false);
		exp2.setPoints(43);
		exp2.setStudent(s1);
		examParticipationRepo.save(exp2);
		
		//ExamParticipation2
		ExamParticipation exp3 = new ExamParticipation();
		exp3.setExam(exam3);
		exp3.setGrade(5);
		exp3.setPassed(false);
		exp3.setPoints(50);
		exp3.setStudent(s1);
		examParticipationRepo.save(exp3);
		
	}
}
