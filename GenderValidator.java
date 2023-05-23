public class GenderValidator implements Validator {

    @Override
    public boolean isValid(String str) {
        return str.matches("m") || str.matches("f");
    }
        
}
