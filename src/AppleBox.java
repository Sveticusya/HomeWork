public class AppleBox extends Box<Apple> {

    @Override
    public boolean sprinkleFruits(Box box) {
        if(box instanceof AppleBox)
            return super.sprinkleFruits(box);

        return false;
    }
}
