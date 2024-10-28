package zl.readCloud;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

@Slf4j
@SpringBootTest
class ReadCloudApplicationTests {

    @Test
    void contextLoads() {

        // addAll末尾添加所有
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(2);
//        list1.add(3);
//        list1.add(4);
//        list.addAll(list1);
//
//        for (Integer integer : list) {
//            System.out.println(integer);
//        }

        //         获取时间
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        Date afterDate = new Date(1635330737);
//        Map<Integer,String> map = new HashMap<>();
//
//        System.out.println(map.size());
//
//         获取当前的后5分钟
//        Date nextDay = new Date();
//        log.info("路径为: "+ nextDay+ "/\n" + "sadfasdf");
//        Date afterDate = new Date(nextDay.getTime() + 1000*60*5);
//        log.info("路径为: "+ afterDate);
//        System.out.println(sdf.format(afterDate));

        // 获取项目根路径
//        String path3 = System.getProperty("user.dir");
//        System.out.println(path3);
//
//         获取现在时间
//        Date sameDay = Date.from(Instant.now());
//        System.out.println(sameDay);


        // 定时任务计算时间
//        LocalDate BurstToday = LocalDate.now();
//        LocalDate BurstMonday = BurstToday.with(TemporalAdjusters.previousOrSame( DayOfWeek.MONDAY));
//        long BurstTimestamp = BurstMonday.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
//        System.out.println(BurstTimestamp +"");
//        long BurstRankGiftTaskInitDelay  = BurstTimestamp + 1000*60*60*2*24+1000*60*60*14+1000*60*29 - System.currentTimeMillis();
//        System.out.println(BurstRankGiftTaskInitDelay +"");
//        BurstRankGiftTaskInitDelay = BurstRankGiftTaskInitDelay > 0 ? BurstRankGiftTaskInitDelay : 1000*60*60*24*7 + BurstRankGiftTaskInitDelay;
//        System.out.println(BurstRankGiftTaskInitDelay +"");

        // 获取现在的时间戳
        // System.out.println(new Date().getTime());
        // System.out.println(System.currentTimeMillis());


        // DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // LocalDate BurstToday = LocalDate.now();
        // LocalDateTime toDay = LocalDateTime.now();
        // System.out.println(toDay);
        // System.out.println(BurstToday);


        LocalDate to = LocalDate.now();
        System.out.println(to.plusDays(-1));

    }

}
