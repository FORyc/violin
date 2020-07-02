package top.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

/**
 * @author 9527
 * 时间操作类
 */
public class DateUtils {

    public static LocalDateTime ofTime(Date date){
        if(Objects.isNull(date)){
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static LocalDate ofDate(Date date){
        if(Objects.isNull(date)){
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
    }

    public static Date toTime(LocalDateTime localDateTime){
        if(Objects.isNull(localDateTime)){
            return null;
        }
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static Date toDate(LocalDate localDate){
        if(Objects.isNull(localDate)){
            return null;
        }
        Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }



}
