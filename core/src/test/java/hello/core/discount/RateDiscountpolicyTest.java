package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountpolicyTest {

    RateDiscountpolicy discountpolicy = new RateDiscountpolicy();

    @Test
    @DisplayName("VIP는 10% 할인 적용 최대 할인금액은 2000원")
    void vip_o() {

        //given

        Member member = new Member(1L, "ms91", Grade.VIP);

        //when
        int discount = discountpolicy.discount(member, 30000);

        //then
        assertThat(discount).isEqualTo(2000);

    }

    @Test
    @DisplayName("VIP가 아니면 할인 적용 x")
    void vip_x() {

        //given

        Member member = new Member(2L, "ms91", Grade.BASIC);

        //when
        int discount = discountpolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);

    }

}