package com.mycompany.instrom;
import com.mycompany.instrom.Keyboard.Keyboard;
import com.mycompany.instrom.Percussion.Bells;
import com.mycompany.instrom.Stringed.Guitar;
import com.mycompany.instrom.Stringed.Guitar.GuitarType;
import com.mycompany.instrom.Stringed.Stringed.StringType;
import com.mycompany.instrom.app.App;
import java.io.IOException;
import java.util.ArrayList;

public class MusicalInstrument {
    public static final MusicalInstrument[] guitars = {
        new Guitar("BAT1M Tahoma", "Bromo", "inspired by the majestic reputation of the Tahoma volcano in the Pacific Ring of Fire", "/assets/images/guitars/Bromo_BAT1M_Tahoma_Dreadnought_Acoustic_Guitar_Natural.png", "1 Year", 9000.00, true, 88, StringType.STEEL, "Dreadnought", "Natural", 20, GuitarType.ACOUSTIC),
        new Guitar("BR-160E ", "Blueridge", "Historic Series Solid Top Dreadnought Electric Acoustic Guitar.", "/assets/images/keyboards/Blueridge BR-160E Historic Series Solid Top Dreadnought Electric Acoustic Guitar.png", "2 Year", 59415.00, true, 88, StringType.STEEL, "Dreadnought", "Natural", 20, GuitarType.ACOUSTIC),
        new Guitar("BR-40E", "Blueridge", "Solid Top Dreadnought Electric Acoustic Guitar", "/assets/images/keyboards/Blueridge BR-40E Solid Top Dreadnought Electric Acoustic Guitar.png", "2 Years", 37145.00, true, 88, StringType.STEEL, "Dreadnought", "Natural", 20, GuitarType.ACOUSTIC),
        new Guitar("CC-60S", "Fender", "Concert Solid Top Acoustic Guitar Pack - Mahogany", "/assets/images/keyboards/Fender CC-60S Concert Solid Top Acoustic Guitar Pack - Mahogany (970150422).png", "1 Year", 11857.50, true, 88, StringType.STEEL, "Auditorium", "Brown", 20, GuitarType.ACOUSTIC),
        new Guitar("AW-41C", "Fernando", "Acoustic Guitar with Cutaway", "/assets/images/keyboards/Fernando AW-41C Acoustic Guitar with Cutaway (Sunburst)", "1 Year", 3240.00, true, 88, StringType.STEEL, "Auditorium", "Brown", 20, GuitarType.ACOUSTIC),
        new Guitar("Ernie Ball Music Man Reflex Game Changer Electric Guitar (Black)", "Ernie", "Electric guitar lets you unlock your instrument's complete", "/assets/images/keyboards/Ernie Ball Music Man Reflex Game Changer Electric Guitar (Black).png", "Lifetime", 130720.00, true, 88, StringType.NICKEL, "VW Garadge Master", "Black", 22, GuitarType.ELECTRIC),
        new Guitar("G5421 Jet Club Rosewood Fingerboard", "Gretsch", "Gretsch Electromatic G5421 Jet Club electric guitar is just what you've been waiting for.", "/assets/images/keyboards/Gretsch G5421 Jet Club Rosewood Fingerboard (Firebird Red).png", "2 Years", 38547.50, true, 88, StringType.NICKEL, "Gretsch", "Red", 22, GuitarType.ELECTRIC),
        new Guitar("American Vintage II 1966", "Fender", "Remarkably accurate take on the revolutionary designs that altered the course of musical history.", "/assets/images/keyboards/Fender American Vintage II 1966 Jazz Bass Guitar with Rosewood Fretboard (3-Color Sunburst).png", "Lifetime ", 159300.00, true, 88, StringType.NICKEL, "Fender", "Sunburst", 20, GuitarType.BASS),
        new Guitar("Deluxe Active Jazz Bass Pau Ferro", "Fender", "Elegant and packed with versatile tones.", "/assets/images/keyboards/Fender Deluxe Active Jazz Bass Pau Ferro", "2 Year", 61950.00, true, 88, StringType.NICKEL, "Fender", "White", 20, GuitarType.BASS)
    };
    
    public static final MusicalInstrument[] keyboards = {
        new Keyboard("P-225 Black 88-Key Compact Digital Piano", "Yamaha", "A stylish digital piano that features a compact body equipped with useful features from practicing.", "/assets/images/keyboards/yamaha_88_key.png", "2 years", 43718.50, true, 88, false),
        new Keyboard("E-X20 Arranger Keyboard", "Roland", "The portable keyboard that sparks your child’s passion for music.", "/assets/images/keyboards/roland_keyboard.png", "1 year", 20852.00, false, 61, false),
        new Keyboard("GL-50 Grand Piano", "Kawai", "The grand piano that offers abundant tone quality, bass resonance, and versatile size that is perfect for professional teaching applications.", "/assets/images/keyboards/kawai_gl_50.png", "10 years", 2741147.50, true, 88, true),
        new Keyboard("CA701 Digital Piano", "Kawai", "A piano that will encourage enthusiastic players to become accomplished pianists, and transform living rooms into grand concert halls. ", "/assets/images/keyboards/kawai_ca701.png", "5 years", 285719.25, true, 88, false),
        new Keyboard("CHANSON 12 Bass Accordion", "Chanson", "It is lightweight and compact accordion, ideal as a beginners instrument and for children to learn on.", "/assets/images/keyboards/chanson_accordion.png", "No warranty", 21853.00, true, 25, false),
    };
    
    public static final MusicalInstrument[] bells = {
        new Bells("MUSSER Orchestra Bells M645", "Ludwig-Musser", "Orchestra bell made with high-carbon tempered steel that will  deliver unsurpassed tone, clarity and resonance", "/assets/images/bells/musser_bell_m645.png", "No warranty", 87165.25, true, "Steel", "32x3.5 inches"),
        new Bells("SCHULMERICH Individual Hand Bells", "1ST OCTAVE (C5-C6)", "A high-quality handbell set with a rich, resonant tone. ", "/assets/images/bells/schulmerich_bell_c5c6.png", "No warranty", 39000.00, true, "Bronze", "Not specified"),
        new Bells("Aluminum Handbell with Case", "None", "A bell made with aluminum that provides a strong fundamental tone and reduce the weight to about half of the bronze.", "/assets/images/bells/malmark_alum_bell.png", "Not specified", 160000.00, true, "Aluminum", "18.375x19.5 inches"),
        new Bells("YAMAHA YG-250D Glockenspiel", "Yamaha", "A high-carbon made glockenspiel that offers a pure, bright tone, and nodal point support string with single pin bar mounting.", "/assets/images/bells/yamaha_yg250d.png", "1 year", 72920.00, true, "High-carbon steel", "73x46cm"),
        new Bells("MUSSER M500 Marimba", "Musser", "This 5-octave marimba features select hand-tuned Honduras Rosewood bars, which provide a full and rich tone.", "/assets/images/bells/musser_m500.png", "Not specified", 1129847.50, true, "Rosewood", "107x41 inches"),
    };
    
    public static final MusicalInstrument[] whatsNew = {
        guitars[0],
        keyboards[2],
        bells[3],
        keyboards[4]
    };
    
    public static final MusicalInstrument[] onSale = {
        keyboards[1],
        keyboards[0]
    };
    
    public static ArrayList<MusicalInstrument> cart = new ArrayList<>();
    
    public MusicalInstrument(String name, String brand, String description, String image, InstrumentCategory category, String warrantyPeriod, double price, boolean available) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.image = image;
        this.category = category;
        this.warrantyPeriod = warrantyPeriod;
        this.price = price;
        this.available = available;
    }
    
    public enum InstrumentCategory {
        STRINGED,
        PERCUSSION,
        WIND,
        KEYBOARD
    };
    
    private final String name;
    private final String brand;
    private final String description;
    private final String image;
    private final InstrumentCategory category;
    private String warrantyPeriod;
    private double price;
    private boolean available;

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public InstrumentCategory getCategory() {
        return category;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public double getPrice() {
        return price;
    }

    public boolean getAvailability() {
        return available;
    }
    
    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailability(boolean available) {
        this.available = available;
    }
    
    public void addToCart() {
        
    }
    
    public static void displayItem(String itemName, String description, String brandName, String category, String warrantyPeriod, String price) throws IOException {
        App.changeStage("ItemView", "Item: " + itemName, 980, 588);
        
    }
}
