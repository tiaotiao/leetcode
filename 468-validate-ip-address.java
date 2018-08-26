

class Solution {
    public String validIPAddress(String IP) {
        IP = IP.trim();
        if (checkIPv4(IP)) return "IPv4";
        if (checkIPv6(IP)) return "IPv6";
        return "Neither";
    }

    boolean checkIPv4(String IP) {
        String[] ss = IP.split("\\.", -1);
        if (ss.length != 4) return false;
        for (String s : ss) {
            s = s.trim();
            if (s.length() > 3 || s.length() == 0) return false;
            if (s.charAt(0) == '0' && s.length() != 1) return false;
            if (s.charAt(0) == '-') return false;
            try {
                int val = Integer.parseInt(s);
                if (val < 0 || 256 <= val) return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    boolean checkIPv6(String IP) {
        String[] ss = IP.split(":", -1);
        if (ss.length != 8) return false;
        for (String s : ss) {
            s = s.trim();
            if (s.length() > 4 || s.length() == 0) return false;
            if (s.charAt(0) == '-') return false;
            try {
                int val = Integer.parseInt(s, 16);
                if (val < 0 || 1 << 16 <= val) return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}