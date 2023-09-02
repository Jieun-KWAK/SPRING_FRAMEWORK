package com.example.SpringJDBC;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo"})
public class SpringJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args)
				.getBean(SpringJdbcApplication.class).execute();
	}

	@Autowired
	MemberCrudRepository repository;

	private void execute() {
		executeInsert();
		executeSelect();
	}
	private void executeInsert() {
		Member member = new Member(null, "곽징응");
		member=repository.save(member);
		System.out.println("등록 데이터 :"+ member);
	}

	private void executeSelect() {
		System.out.println(" --- 전체 데이터를 취득합니다. --- " );
		// 리포지토리를 이용해 전체 데이터를 취득
		Iterable<Member> members = repository.findAll();
		for (Member member : members) {
			System.out.println(member);
		}
	}
}
