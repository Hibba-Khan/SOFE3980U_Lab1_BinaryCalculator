package com.ontariotechu.sofe3980U;

public class Binary {
    private String number = "0";

    public Binary(String number) {
        if (number == null || number.isEmpty()) {
            this.number = "0";
            return;
        }
        // check if string is valid binary
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch != '0' && ch != '1') {
                this.number = "0";
                return;
            }
        }
        int beg;
        for (beg = 0; beg < number.length(); beg++) {
            if (number.charAt(beg) != '0') {
                break;
            }
        }
        this.number = (beg == number.length()) ? "0" : number.substring(beg);
        if (this.number.isEmpty()) {
            this.number = "0";
        }
    }

    public String getValue() {
        return this.number;
    }

    public static Binary add(Binary num1, Binary num2) {
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;
        int carry = 0;
        String num3 = "";
        while (ind1 >= 0 || ind2 >= 0 || carry != 0) {
            int sum = carry;
            if (ind1 >= 0) {
                sum += (num1.number.charAt(ind1) == '1') ? 1 : 0;
                ind1--;
            }
            if (ind2 >= 0) {
                sum += (num2.number.charAt(ind2) == '1') ? 1 : 0;
                ind2--;
            }
            carry = sum / 2;
            sum = sum % 2;
            num3 = ((sum == 0) ? "0" : "1") + num3;
        }
        return new Binary(num3);
    }

    // Bitwise OR logic
    public static Binary or(Binary num1, Binary num2) {
        StringBuilder result = new StringBuilder();
        int n1 = num1.number.length();
        int n2 = num2.number.length();
        int maxLen = Math.max(n1, n2);

        for (int i = 0; i < maxLen; i++) {
            char c1 = (i < n1) ? num1.number.charAt(n1 - 1 - i) : '0';
            char c2 = (i < n2) ? num2.number.charAt(n2 - 1 - i) : '0';
            result.insert(0, (c1 == '1' || c2 == '1') ? "1" : "0");
        }
        return new Binary(result.toString());
    }

    // Bitwise AND logic
    public static Binary and(Binary num1, Binary num2) {
        StringBuilder result = new StringBuilder();
        int n1 = num1.number.length();
        int n2 = num2.number.length();
        int maxLen = Math.max(n1, n2);

        for (int i = 0; i < maxLen; i++) {
            char c1 = (i < n1) ? num1.number.charAt(n1 - 1 - i) : '0';
            char c2 = (i < n2) ? num2.number.charAt(n2 - 1 - i) : '0';
            result.insert(0, (c1 == '1' && c2 == '1') ? "1" : "0");
        }
        return new Binary(result.toString());
    }

    // Multiplication with shift and add
    public static Binary multiply(Binary num1, Binary num2) {
        Binary result = new Binary("0");
        String multiplier = num2.number;

        for (int i = 0; i < multiplier.length(); i++) {
            if (multiplier.charAt(multiplier.length() - 1 - i) == '1') {
                String shifted = num1.number + "0".repeat(i);
                result = add(result, new Binary(shifted));
            }
        }
        return result;
    }
}
