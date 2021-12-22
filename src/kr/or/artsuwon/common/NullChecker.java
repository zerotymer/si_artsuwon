package kr.or.artsuwon.common;

public class NullChecker {
    /**
     * 입력받은 문자열에 대하여 Null 체크를 한다.
     * @param str 입력받은 문자열
     * @return Null이면 "" 반환, 아니면 입력받은 문자열 반환
     * @author 신현진
     */
    public static String NullCheckString(String str) { return str == null ? "" : str; }

    /**
     * 입력받은 문자열에 대하여 Null 체크를 한다.
     * @param str 입력받은 문자열
     * @param defaultString 기본 문자열
     * @return Null이면 기본 문자열 반환, 아니면 입력받은 문자열 반환
     * @author 신현진
     */
    public static String NullCheckString(String str, String defaultString) { return str == null ? defaultString : str; }

    /**
     * 입력받은 문자열에 대하여 Null 체크를 한 뒤 정수형으로 변환한다.
     * @param str 입력받은 문자열
     * @return Null이면 0 반환, 아니면 입력받은 문자열 반환
     * @author 신현진
     */
    public static int NullCheckParseInt(String str) { return NullCheckParseInt(str, 0); }

    /**
     * 입력받은 문자열에 대하여 Null 체크를 한 뒤 정수형으로 변환한다.
     * @param str 입력받은 문자열
     * @param defaultValue 기본 값
     * @return Null이면 기본 값 반환, 아니면 입력받은 문자열 반환
     * @author 신현진
     */
    public static int NullCheckParseInt(String str, int defaultValue) { return str == null ? defaultValue : Integer.parseInt(str); }
}
