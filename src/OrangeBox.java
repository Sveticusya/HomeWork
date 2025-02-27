public class OrangeBox extends Box<Orange> {
    @Override
    public boolean sprinkleFruits(Box box) {
        if(box instanceof OrangeBox)
            return super.sprinkleFruits(box);

        return false;
    }
}
