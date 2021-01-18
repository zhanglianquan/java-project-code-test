package src.optional;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author zhanglianquan
 * 产考：https://blog.csdn.net/zjhred/article/details/84976734s
 * @date 2020/12/4
 **/
public class TestOptional {

    public static long str2TimeStamp(String dateTimeStr) {
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(dateTimeStr, ftf);
        return LocalDateTime.from(parse).atZone(ZoneId.of("Asia/Shanghai")).toInstant().getEpochSecond();
    }

    public static Long getTimeStampByDate(String dateStr, String format, String timeZone) {
//        if (StringUtils.isBlank(dateStr)) {
//            return 0L;
//        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
            Date date = dateFormat.parse(dateStr);
            return date.getTime() / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }

    @Test
    public void testOptional(){
        System.out.println(TestOptional.str2TimeStamp("2020-09-21 21:51:53"));
        System.out.println(TestOptional.getTimeStampByDate("2020-09-21 21:51:53", "yyyy-MM-dd HH:mm:ss", "Asia/Shanghai"));
        System.out.println(TestOptional.getTimeStampByDate("2020-09-21 21:51:53", "yyyy-MM-dd HH:mm:ss", "Asia/Shanghai"));

        // mock 些原始数据：比如有一批分数数据scoreDataList
        List<Integer> scoreDataList = new ArrayList<Integer>(9){
            {
                add(60);
                add(70);
                add(75);
                add(79);
                add(80);
                add(81);
                add(90);
                add(94);
                add(99);
            }
        };
        // 需求要求： 输出不大于80， 也就是小于80的分数
        Predicate<Integer> predicate = (item)-> {
            if (item<80){
                return true;
            }
            return false;
        };
        List<Integer> newList =scoreDataList.stream().filter(predicate).collect(Collectors.toList());
        // 输出验证结果
        newList.forEach(System.out::println);




//        Student std = null;
        Student std = new Student();
        std.setName("qq");
//        Student stdNew= Optional.ofNullable(std).orElseGet(()->createStudent());
//        Student stdNew2= Optional.ofNullable(std).orElse(createStudent());
//        System.out.println(stdNew);
//        System.out.println(stdNew2);

        Student stdNew3= Optional.ofNullable(std).filter(s-> "zlq".equals(s.getName())).orElseGet(
            ()->createStudent()
        );
        System.out.println(stdNew3);
    }

    private Student createStudent(){
        Student std= new Student();
        std.setName("zlq");
        return std;
    }

}
