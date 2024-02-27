package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulService() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

//        //Thread ms91: ms91사용자 10000원 주문
//        statefulService1.order("ms91", 10000);
//        //Thread ms92: ms92사용자 10000원 주문
//        statefulService2.order("ms92", 20000);

        //Thread ms91: ms91사용자 10000원 주문
        int ms91Pirce = statefulService1.order("ms91", 10000);
        //Thread ms92: ms92사용자 10000원 주문
        int ms92Pirce =statefulService2.order("ms92", 20000);

        //Thread ms91: ms91사용자 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + ms91Pirce);

        Assertions.assertThat(ms91Pirce).isNotEqualTo(ms92Pirce);

    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService () {
            return new StatefulService();
        }

    }
}