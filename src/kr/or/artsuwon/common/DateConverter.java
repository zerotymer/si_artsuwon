package kr.or.artsuwon.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    /**
     * 문자열을 Date 객체로 변환한다.
     * @param date 변환할 문자열
     * @param format 변환할 문자열의 포맷
     * @return 변환된 Date 객체
     * @author 신현진
     */
    public static Date convertStringToDate(String date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date newDate = null;

        try {
            newDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return newDate;
    }
}
