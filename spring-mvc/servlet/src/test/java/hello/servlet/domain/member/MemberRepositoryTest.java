package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {

        //given
        Member member = new Member("ms91", 33);

        //when
        Member savedMember = memberRepository.save(member);
        System.out.println("savedMember = " + savedMember.toString());

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        System.out.println("findMember = " + findMember.toString());
        assertThat(findMember).isEqualTo(savedMember);

    }

    @Test
    void findAll() {

        //given
        Member member1 = new Member("ms91", 33);
        Member member2 = new Member("ms90", 34);

        Member savedMember1 = memberRepository.save(member1);
        Member savedMember2 = memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(savedMember1, savedMember2);
    }


}