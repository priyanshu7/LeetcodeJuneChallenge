package june2020;

public class ValidateIPAddress {
	
	public String isIPv4(String IP){
        String[] chunks = IP.split("\\." , -1);
        for(String chunk : chunks){
            if(chunk.length() == 0 || chunk.length() > 3)
                return "Neither";
            if(chunk.charAt(0) == '0' && chunk.length() != 1)
                return "Neither";
            for(char c : chunk.toCharArray()){
                if(!Character.isDigit(c))
                    return "Neither";
            }
            if(Integer.parseInt(chunk) > 255)
                return "Neither";
        }
        return "IPv4";
    }
    
    public String isIPv6(String IP){
        String[] chunks = IP.split(":" , -1);
        String hex = "0123456789abcdefABCDEF";
        for(String chunk : chunks){
            if(chunk.length() == 0 || chunk.length() > 4)
                return "Neither";
            for(char c : chunk.toCharArray()){
                if( hex.indexOf(c) == -1)
                    return "Neither";
            }
        }
        return "IPv6";
    }
    
    
    public String validIPAddress(String IP) {
        int countDot = 0, countColon = 0;
        for(char c : IP.toCharArray()){
            if(c == '.')
                countDot++;
            else if(c == ':')
                countColon++;
        }
        if(countDot == 3)
            return isIPv4(IP);
        else if(countColon == 7)
            return isIPv6(IP);
        return "Neither";
    }

}
