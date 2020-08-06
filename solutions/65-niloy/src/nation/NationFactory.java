package nation;

public class NationFactory {

    public INation getNation(String nationType) {

        if (nationType == "Bangladeshi Farmers")
            return new BangladeshiFarmers();

        return null;
    }
}
