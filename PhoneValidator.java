public class PhoneValidator implements Validator {

    @Override
    public boolean isValid(String str) {
        String regex = "\\d{11}";
        return str.matches(regex);
    }
    
}
