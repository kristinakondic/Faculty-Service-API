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
import ftn.FacultyService.entity.Payment;
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
		u0.setEmail("a@a.a");
		u0.setIdentityNo("1231231231231");
		u0.setName("Kristina");
		u0.setPassword("$2a$10$GCAW1cxizCNL8QoQwZzH1OCVhayIkz0LRKfivQMkIsFkzKgUGoAqC");
		u0.setRole(Role.ADMIN);
		u0.setSurname("Kondic");
		userRepo.save(u0);
		
		//User1Student
		User u1 = new User();
		u1.setAddress("Jovana Cvijica 1");
		u1.setCreationDate(new Date());
		u1.setEmail("s@s.s");
		u1.setIdentityNo("2385728457382");
		u1.setName("Janko");
		u1.setPassword("$2a$10$GCAW1cxizCNL8QoQwZzH1OCVhayIkz0LRKfivQMkIsFkzKgUGoAqC");
		u1.setRole(Role.STUDENT);
		u1.setSurname("Rakic");
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
		u2.setEmail("p@p.p");
		u2.setIdentityNo("54367435438931");
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
		//ExamPeriod2
		ExamPeriod ep2 = new ExamPeriod();
		ep2.setEndDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20190228" ));
		ep2.setStartDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20190220" ));
		ep2.setName("Februarski");
		examPeriodRepo.save(ep2);
		//ExamPeriod3
		ExamPeriod ep3 = new ExamPeriod();
		ep3.setEndDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20190628" ));
		ep3.setStartDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20190620" ));
		ep3.setName("Junski");
		examPeriodRepo.save(ep3);
		//ExamPeriod4
		ExamPeriod ep4 = new ExamPeriod();
		ep4.setEndDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20190728" ));
		ep4.setStartDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20190720" ));
		ep4.setName("Julski");
		examPeriodRepo.save(ep4);
		//ExamPeriod5
		ExamPeriod ep5 = new ExamPeriod();
		ep5.setEndDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20190928" ));
		ep5.setStartDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20190920" ));
		ep5.setName("Septembarski");
		examPeriodRepo.save(ep5);
		
		//FieldsOfStudy1
		FieldsOfStudy f1 = new FieldsOfStudy();
		f1.setName("Elektrotehnika i racunarstvo");
		fieldsOfStudyRepo.save(f1);
		//FieldsOfStudy2
		FieldsOfStudy f2 = new FieldsOfStudy();
		f2.setName("Arhitektura");
		fieldsOfStudyRepo.save(f2);
		//FieldsOfStudy3
		FieldsOfStudy f3 = new FieldsOfStudy();
		f3.setName("Graficko inzenjerstvo i dizajn");
		fieldsOfStudyRepo.save(f3);
		//FieldsOfStudy4
		FieldsOfStudy f4 = new FieldsOfStudy();
		f4.setName("Industrijsko inzenjerstvo i menadzment");
		fieldsOfStudyRepo.save(f4);
		
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
		//Subject4
		Subject sub4 = new Subject();
		sub4.setEspb("5");
		sub4.setFieldsOfStudy(f3);
		sub4.setName("Graficki dizajn");
		sub4.setSubjectNo("323");
		sub4.setYear(2019);
		subjectRepo.save(sub4);
		//Subject5
		Subject sub5 = new Subject();
		sub5.setEspb("8");
		sub5.setFieldsOfStudy(f4);
		sub5.setName("Menadzment");
		sub5.setSubjectNo("313");
		sub5.setYear(2019);
		subjectRepo.save(sub5);
		
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
		exam2.setDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20200927" ));
		exam2.setExamPeriod(ep5);
		exam2.setSubject(sub2);
		exam2.setType(TypeOfExam.Ispit);
		examRepo.save(exam2);
		//Exam3
		Exam exam3 = new Exam();
		exam3.setClassroom("A1");
		exam3.setDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20200626" ));
		exam3.setExamPeriod(ep3);
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
		
		//Payment1
		Payment py1 = new Payment();
		py1.setDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20190126" ));
		py1.setStudent(s1);
		py1.setValue(5000);
		paymentRepo.save(py1);
		//Payment2
		Payment py2 = new Payment();
		py2.setDate(new SimpleDateFormat( "yyyyMMdd" ).parse( "20190126" ));
		py2.setStudent(s1);
		py2.setValue(5000);
		paymentRepo.save(py2);
	}
}
