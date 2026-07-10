class Solution {
    public String maskPII(String s) {

        if (s.contains("@")) {
            return maskEmail(s);
        } else {
            return maskPhone(s);
        }
    }

    private String maskEmail(String email) {

        email = email.toLowerCase();

        int at = email.indexOf('@');

        return email.charAt(0)
                + "*****"
                + email.charAt(at - 1)
                + email.substring(at);
    }

    private String maskPhone(String phone) {

        StringBuilder digits = new StringBuilder();

        for (char ch : phone.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.append(ch);
            }
        }

        String num = digits.toString();

        String local = "***-***-" + num.substring(num.length() - 4);

        int country = num.length() - 10;

        if (country == 0)
            return local;

        StringBuilder ans = new StringBuilder("+");

        for (int i = 0; i < country; i++) {
            ans.append("*");
        }

        ans.append("-").append(local);

        return ans.toString();
    }
}