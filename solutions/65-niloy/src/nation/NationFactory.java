package nation;

public class NationFactory {

    public INation getNation(String nationType) {

        if (nationType == "Bangladeshi Farmers")
            return new BangladeshiFarmers();
        else if(nationType == "Arab Bedouin")
            return new ArabBedouin();
        else if(nationType == "Egyptian Kings")
            return new EgyptianKings();
        else if(nationType == "Inuit Hunters")
            return new EgyptianKings();

        return null;
    }
}
