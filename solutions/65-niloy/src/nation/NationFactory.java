package nation;

public class NationFactory {

    public INation getNation(String nationType) {

        if (nationType == "Bangladeshi Farmers")
            return new BangladeshiFarmers();
        else if(nationType == "Arab Bedouin")
            return new ArabBedouin();

        return null;
    }
}
