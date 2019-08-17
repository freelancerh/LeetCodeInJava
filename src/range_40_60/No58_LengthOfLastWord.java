package range_40_60;

/**
 * 字符串
 */
public class No58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        return s.trim().length()-1-s.trim().lastIndexOf(' ');
    }
}
