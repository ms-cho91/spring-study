package repository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("ms91");
        repository.save(member);

        Member reseult = repository.findById(member.getId()).get();
        System.out.println("reseult = " + (reseult==member) );
//        Assertions.assertEquals(member, reseult); //org.junit.jupiter.api.Assertions
        assertThat(member).isEqualTo(reseult); //org.assertj.core.api.Assertions;

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("ms91");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("ms90");
        repository.save(member2);

        Member result = repository.findByName("ms91").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("ms91");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("ms90");
        repository.save(member2);
        //when
        List<Member> result = repository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
    }

}
