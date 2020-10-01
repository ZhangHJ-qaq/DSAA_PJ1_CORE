package com.company.utilities;

public class Utility {
    /**
     * 将一个byte类型的数据转换成八位字符串
     *
     * @param b byte类型数据
     * @return 对应的八位字符串
     */
    public static String to8DigitBinaryString(byte b) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toBinaryString(b));
        if (stringBuilder.length() == 8) {
            return stringBuilder.toString();
        } else if (stringBuilder.length() < 8) {
            while (stringBuilder.length() < 8) {
                stringBuilder.insert(0, 0);
            }
            return stringBuilder.toString();
        } else {
            stringBuilder.delete(0, 24);
            return stringBuilder.toString();
        }
    }


}
