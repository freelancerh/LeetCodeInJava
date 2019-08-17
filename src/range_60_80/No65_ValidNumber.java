package range_60_80;

/**
 * 字符串,状态机,正则
 */
public class No65_ValidNumber {
    public boolean isNumber(String s) {
        return s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?");
    }
}
