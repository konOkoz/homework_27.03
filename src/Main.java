import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
Получить и вывести на экран:
-текущую дату
-текущий год, месяц и день
Создать дату , например день рождения и вывести на экран
Создать две даты и проверить на равенство
Получить и вывести на экран текущее время
текущее время + 3 часа
Создать дату на неделю позже сегодняшней
Создать дату, которая была на год раньше сегодняшней используя метод minus
Создать дату на год позже сегодняшней используя plus метод
Создать даты tomorrow и yesterday и проверить находятся ли они до или после сегодняшней
*Написать метод, принимающий лист из нескольких дат типа LocalDate и возвращающий количество дней между самой ранней и поздней датами
     */
    public static void main(String[] args) {
        LocalDateTime dateAndTimeNow = LocalDateTime.now();
        System.out.println(dateAndTimeNow);

        LocalDate dateNow = LocalDate.now();
        System.out.println(dateNow);

        LocalDate birthday = LocalDate.of(1993,07,24);
        System.out.println(birthday);

        LocalDate birthday1 = LocalDate.parse("1997-01-20");
        System.out.println(birthday.isEqual(birthday1));

        LocalTime timeNow = LocalTime.now();
        System.out.println(timeNow);

        System.out.println(timeNow.plusHours(3));

        LocalDate nowPlusWeek = LocalDate.now().plusWeeks(1);
        System.out.println(nowPlusWeek);

        LocalDate nowMinusYear = LocalDate.now().minusYears(1);
        System.out.println(nowMinusYear);

        LocalDate nowPlusYear = LocalDate.now().plusYears(1);
        System.out.println(nowPlusYear);

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate yesterday = LocalDate.now().minusDays(1);

        boolean beforeTomorrow = dateNow.isBefore(tomorrow);
        boolean afterTomorrow = dateNow.isAfter(tomorrow);
        boolean beforeYesterday = dateNow.isBefore(yesterday);
        boolean afterYesterday = dateNow.isAfter(yesterday);
        System.out.println(beforeTomorrow);
        System.out.println(afterTomorrow);
        System.out.println(beforeYesterday);
        System.out.println(afterYesterday);

        List<LocalDate> dates = Arrays.asList(yesterday,dateNow,tomorrow,nowPlusWeek);

        System.out.println(Days(dates));
        System.out.println(yesterday.getDayOfYear());
        System.out.println(nowPlusWeek.getDayOfYear());

    }
    public static int Days(List<LocalDate> dates){
        LocalDate later = dates.get(0);
        LocalDate faster = dates.get(0);
        int result = 0;
        for(int i = 1; i < dates.size(); i++){
            if(later.isBefore(dates.get(i)))
                later=dates.get(i);
        }
        for(int i = 1; i< dates.size(); i++) {
            if(faster.isAfter(dates.get(i)))
                    faster = dates.get(i);
        }
        result = later.getDayOfYear()-faster.getDayOfYear();
     return result;
    }
}
/*OUTPUTS:
2023-03-28T00:14:21.001329700
2023-03-28
1993-07-24
false
00:14:21.007335200
03:14:21.007335200
2023-04-04
2022-03-28
2024-03-28
true
false
false
true
8
86
94
 */