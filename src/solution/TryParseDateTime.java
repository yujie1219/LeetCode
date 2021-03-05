package solution;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class TryParseDateTime {
    // 2021-03-01T14:21:29.4068596+08:00

    public static void main(String[] args) {
        String text = "2021-03-01T14:21:29.4068596+08:00";
        ZonedDateTime timeWithZone = ZonedDateTime.parse(text);
        System.out.println(timeWithZone);
        LocalDateTime timeWithOutZone = timeWithZone.toLocalDateTime();
        System.out.println(timeWithOutZone);
    }
}
