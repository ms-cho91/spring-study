package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    /**
     * @return
     */

    private int discountPercent = 10; // 할인율

    private int maxDiscountPrice = 2000; // 최대 할인금액


    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {

            int discountPrice = price * discountPercent / 100;

            if ( discountPrice > maxDiscountPrice ) {
                return maxDiscountPrice;
            } else {
                return discountPrice;
            }

        } else {
            return 0;
        }
    }
}
