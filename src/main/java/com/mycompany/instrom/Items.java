package com.mycompany.instrom;

import com.mycompany.instrom.Stringed.Guitar;
import com.mycompany.instrom.Stringed.Guitar.GuitarType;
import com.mycompany.instrom.Stringed.Stringed.StringType;

public class Items {
    // TODO: Where and how will I call this?
    public static void initializeItems() {
        Guitar g1 = new Guitar("BAT1M Tahoma", "Bromo", "inspired by the majestic reputation of the Tahoma volcano in the Pacific Ring of Fire", "/assets/images/guitars/Bromo_BAT1M_Tahoma_Dreadnought_Acoustic_Guitar_(Natural).png", "1 Year", 9000.00, true, 88, StringType.STEEL, "Dreadnought", "Natural", 20, GuitarType.ACOUSTIC);
    }
}
