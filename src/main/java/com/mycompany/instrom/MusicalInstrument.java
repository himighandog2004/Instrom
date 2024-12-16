package com.mycompany.instrom;
import com.mycompany.instrom.Keyboard.Keyboard;
import com.mycompany.instrom.Percussion.Bells;
import com.mycompany.instrom.Percussion.Drums;
import com.mycompany.instrom.Percussion.Drums.DrumType;
import com.mycompany.instrom.Stringed.Bowed;
import com.mycompany.instrom.Stringed.Bowed.BowType;
import com.mycompany.instrom.Stringed.Guitar;
import com.mycompany.instrom.Stringed.Guitar.GuitarType;
import com.mycompany.instrom.Stringed.Harp;
import com.mycompany.instrom.Stringed.Stringed.StringType;
import com.mycompany.instrom.Wind.Brass;
import com.mycompany.instrom.Wind.Brass.ValveType;
import com.mycompany.instrom.Wind.Woodwind;
import com.mycompany.instrom.app.App;
import com.mycompany.instrom.app.ItemViewController;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MusicalInstrument {
    public static final MusicalInstrument[] instruments = {
        // Guitars (0-8)
        new Guitar("BAT1M Tahoma", "Bromo", "G01", "A guitar inspired by the majestic reputation of the Tahoma volcano in the Pacific Ring of Fire", "/assets/images/guitars/Bromo_BAT1M_Tahoma_Dreadnought_Acoustic_Guitar_Natural.png", "1 Year", 9000.00, true, 12, 6, StringType.STEEL, "Dreadnought", "Natural", 20, GuitarType.ACOUSTIC),
        new Guitar("BR-160E ", "Blueridge", "G02", "Historic Series Solid Top Dreadnought Electric Acoustic Guitar.", "/assets/images/guitars/Blueridge BR-160E Historic Series Solid Top Dreadnought Electric Acoustic Guitar.png", "2 Year", 59415.00, true, 2, 6, StringType.STEEL, "Dreadnought", "Natural", 20, GuitarType.ACOUSTIC),
        new Guitar("BR-40E", "Blueridge", "G03", "Solid Top Dreadnought Electric Acoustic Guitar", "/assets/images/guitars/Blueridge BR-40E Solid Top Dreadnought Electric Acoustic Guitar.png", "2 Years", 37145.00, true, 2, 6, StringType.STEEL, "Dreadnought", "Natural", 20, GuitarType.ACOUSTIC),
        new Guitar("CC-60S", "Fender", "G04", "Concert Solid Top Acoustic Guitar Pack - Mahogany", "/assets/images/guitars/Fender CC-60S Concert Solid Top Acoustic Guitar Pack - Mahogany (970150422).png", "1 Year", 11857.50, true, 5, 6, StringType.STEEL, "Auditorium", "Brown", 20, GuitarType.ACOUSTIC),
        new Guitar("AW-41C", "Fernando", "G05", "Acoustic Guitar with Cutaway", "/assets/images/guitars/Fernando AW-41C Acoustic Guitar with Cutaway (Sunburst).png", "1 Year", 3240.00, true, 20, 6, StringType.STEEL, "Auditorium", "Brown", 20, GuitarType.ACOUSTIC),
        new Guitar("Ernie Music Man Reflex Game Changer Electric Guitar", "G06", "Ernie", "Ernie Music Man Electric guitar lets you unlock your instrument's complete power", "/assets/images/guitars/Ernie Ball Music Man Reflex Game Changer Electric Guitar (Black).png", "Lifetime", 130720.00, true, 1, 6, StringType.NICKEL, "VW Garadge Master", "Black", 22, GuitarType.ELECTRIC),
        new Guitar("G5421 Jet Club Rosewood Fingerboard", "G07", "Gretsch", "Gretsch Electromatic G5421 Jet Club electric guitar is just what you've been waiting for.", "/assets/images/guitars/Gretsch G5421 Jet Club Rosewood Fingerboard (Firebird Red).png", "2 Years", 38547.50, true, 2, 6, StringType.NICKEL, "Gretsch", "Red", 22, GuitarType.ELECTRIC),
        new Guitar("American Vintage II 1966", "Fender", "G08", "Remarkably accurate take on the revolutionary designs that altered the course of musical history.", "/assets/images/guitars/Fender American Vintage II 1966 Jazz Bass Guitar with Rosewood Fretboard (3-Color Sunburst).png", "Lifetime ", 159300.00, true, 1, 4, StringType.NICKEL, "Fender", "Sunburst", 20, GuitarType.BASS),
        new Guitar("Deluxe Active Jazz Bass Pau Ferro", "Fender", "G09", "Elegant and packed with versatile tones.", "/assets/images/guitars/Fender Deluxe Active Jazz Bass Pau Ferro.png", "2 Year", 61950.00, true, 1, 4, StringType.NICKEL, "Fender", "White", 20, GuitarType.BASS),
        // Keyboards (9-13)
        new Keyboard("P-225 Black 88-Key Compact Digital Piano", "K01", "Yamaha", "A stylish digital piano that features a compact body equipped with useful features from practicing.", "/assets/images/keyboards/yamaha_88_key.png", "2 years", 43718.50, true, 1, 88, false),
        new Keyboard("E-X20 Arranger Keyboard", "K02", "Roland", "The portable keyboard that sparks your child’s passion for music.", "/assets/images/keyboards/roland_keyboard.png", "1 year", 20852.00, false, 1, 61, false),
        new Keyboard("GL-50 Grand Piano", "Kawai", "K03", "The grand piano that offers abundant tone quality, bass resonance, and versatile size that is perfect for professional teaching applications.", "/assets/images/keyboards/kawai_gl_50.png", "10 years", 2741147.50, true, 1, 88, true),
        new Keyboard("CA701 Digital Piano", "Kawai", "K04", "A piano that will encourage enthusiastic players to become accomplished pianists, and transform living rooms into grand concert halls. ", "/assets/images/keyboards/kawai_ca701.png", "5 years", 285719.25, true, 1, 88, false),
        new Keyboard("CHANSON 12 Bass Accordion", "Chanson", "K05", "It is lightweight and compact accordion, ideal as a beginners instrument and for children to learn on.", "/assets/images/keyboards/chanson_accordion.png", "No warranty", 21853.00, true, 1, 25, false),
        // Bells (14-18)
        new Bells("MUSSER Orchestra Bells M645", "Ludwig-Musser", "BE01", "Orchestra bell made with high-carbon tempered steel that will deliver unsurpassed tone, clarity and resonance", "/assets/images/bells/musser_bell_m645.png", "No warranty", 87165.25, true, 7, "Steel", "32x3.5 inches"),
        new Bells("SCHULMERICH Individual Hand Bells", "BE02", "1ST OCTAVE (C5-C6)", "A high-quality handbell set with a rich, resonant tone. ", "/assets/images/bells/schulmerich_bell_c5c6.png", "No warranty", 39000.00, true, 13, "Bronze", "Not specified"),
        new Bells("Aluminum Handbell with Case", "N/A", "BE03", "A bell made with aluminum that provides a strong fundamental tone and reduce the weight to about half of the bronze.", "/assets/images/bells/malmark_alum_bell.png", "Not specified", 160000.00, true, 5, "Aluminum", "18.375x19.5 inches"),
        new Bells("YAMAHA YG-250D Glockenspiel", "Yamaha", "BE04", "A high-carbon made glockenspiel that offers a pure, bright tone, and nodal point support string with single pin bar mounting.", "/assets/images/bells/yamaha_yg250d.png", "1 year", 72920.00, true, 6, "High-carbon steel", "73x46cm"),
        new Bells("MUSSER M500 Marimba", "Musser", "BE05", "This 5-octave marimba features select hand-tuned Honduras Rosewood bars, which provide a full and rich tone.", "/assets/images/bells/musser_m500.png", "Not specified", 1129847.50, true, 1, "Rosewood", "107x41 inches"),
        // Harp (19-20)
        new Harp("Heritage 22-String Heather Harp", "SKU", "H01", "Offers a rich, resonant tone perfect for beginners and experienced harpists alike.", "/assets/images/harp/Silver Harp Bundle - Heritage 22 String Heather Harp.png", "2 Years", 48227.03, true, 22, 1, StringType.NYLON, "Traditional Celtic", "Light Brown"),
        new Harp("Mia 34-string harp", "SKU", "H02", "enhanced durability and environmental sustainability thanks to the advanced BioCarbon strings.", "/assets/images/harp/Mia 34 string harp (BioCarbon strings) in cherry finish by Salvi.png", "5 Years", 181783.14, true, 2, 22, StringType.NYLON, "Classic Triangular Body", "Natural Grain"),
        // Bowed (21-22)
        new Bowed("Tower Strings Midnight Violin Outfit", "Tower Strings", "BO01", "Offers excellent value and quality for aspiring musicians", "/assets/images/bowed/Tower Strings Midnight Violin Outfit.png", "1 Year", 14083.09, true, 2, 4, StringType.STEEL, "Traditional", "Midnight Black", BowType.VIOLIN),
        new Bowed("Fiddlerman Concert Violin Outfit", "Fiddlerman", "BO02", "High-quality violin package designed for intermediate players.", "/assets/images/bowed/Fiddlerman Concert Violin Outfit.png", "1 Year", 27410.36, true, 1, 4, StringType.STEEL, "Traditional", "Rice Brown", BowType.VIOLIN),
        // Drums (23-27)
        new Drums("DW Collector's Maple Piano Black Super Solid Snare Drum", "Drum Workshop (DW)", "D01", "One of the most important snare drum innovations in recent years.", "/assets/images/drums/dw_snare_drum.png", "1 year", 107809.50, true, 4, "Wood", "5.5x14", "Bright/Dry/Tight", DrumType.ACOUSTIC),
        new Drums("Roland TD-25KV Electronic Drum Set", "Roland", "D02", "A Dynamic, Expressive Playability and Quick Customization Drum Kit that makes it a choice for pro players everywhere.", "/assets/images/drums/roland_td25kv_drumset.png", "2 years", 156702.50, true, 2, "Rubber", "4.4'x2.4'", "Dark/Wet/Blended", DrumType.ELECTRONIC),
        new Drums("Classic Heartwood Djembe Drums", "Africa Heartwood Project", "D03", "This djembe crafted in Ghana, offers top-quality solid-wood drum in perfect for intermediate drummers and students.", "/assets/images/drums/classic_djembre_drum.png", "No warranty", 14660.00, true, 2, "Wood", "14x25 inches", "Articulate/Warm", DrumType.ACOUSTIC),
        new Drums("LP Aspire 10 & 11 Inches Conga Set", "Latin Percussion", "D04", "A set that includes quinto and conga drum and an adjustable double conga stand to make playing fun and easy.", "/assets/images/drums/lp_aspire_conga_set.png", "No warranty", 70387.25, true, 3, "Wood", "10 and 11 inches", "Warm/Tight", DrumType.ACOUSTIC),
        new Drums("Eastar EBO-21 Bongo Drum", "Eastar", "D05", "High-quality bongo drums that has rich sound, ideal for beginners and advanced players, with a great timbre and safe design for children.", "/assets/images/drums/eastar_bongo_drum.png", "3 years", 6464.00, true, 5, "Wood", "6 and 7 inches", "Bright/Tight", DrumType.ACOUSTIC),
        // Brass (28-30)
        new Brass("Yamaha YEP-321", "Yamaha", "BR01", "4-valve Intermediate Euphonium - Clear Lacquer", "/assets/images/brass/Yamaha YEP-321 4-valve Intermediate Euphonium - Clear Lacquer.png", "1 Year", 171826.33, true, 5, "B-flat1", "Cylindrical", ValveType.BALL_VALVE),
        new Brass("Jupiter JEP1101M", "Jupiter", "BR02", "3-valve Professional Marching Euphonium - Clear Lacquer", "/assets/images/brass/Jupiter JEP1101M 3-valve Professional Marching Euphonium - Clear Lacquer.png", "1 Year", 180271.66, true, 3, "B-flat4", "Cylindrical", ValveType.GLOBE_VALVE),
        new Brass("Yamaha YEP-211 Student", "Yamaha", "BR03", "Euphonium with Front-facing Bell - Lacquer", "/assets/images/brass/Yamaha YEP-211 Student Euphonium with Front-facing Bell - Lacquer.png", "2 Years", 182558.19, true, 1, "B-flat1", "Cylindrical", ValveType.GATE_VALVE),
        // Woodwind (31-33)
        new Woodwind("SWO10", "Yanagisawa WO Series", "W01", "This SWO10 brass model is an instrument for the accomplished player.", "/assets/images/woodwind/Yanagisawa WO Series Soprano Saxophone - Straight and Curved NecksHigh G Key.png", "Lifetime", 351805.36, true, 1, "Bb3 to G6", "Tapered Conical Bore", Woodwind.ReedType.SINGLE),
        new Woodwind("Buffet Professional Tradition A Clarinet - Silver Keys", "Buffet Crampon", "W02", "Sound at its purest level, best describes this new instrument. ", "/assets/images/woodwind/Buffet Professional Tradition A Clarinet - Silver Keys.png", "Lifetime", 415668.67, true, 1, "E3 to C7", "Poly-Cylindrical Bore", Woodwind.ReedType.SINGLE),
        new Woodwind("YPC-62 Professional", "Yamaha", "W03", "The YPC-62 has a pleasant and responsive feel that adapts to every nuance of your playing.", "/assets/images/woodwind/Yamaha YPC-62 Professional Piccolo with Silver-plated Keys.png", "5 years", 152942.97, true, 10, "D5 to C8", "Conical Bore", Woodwind.ReedType.SINGLE)        
    };
    
    public static final MusicalInstrument[] whatsNew = {
        instruments[0],
        instruments[14],
        instruments[9],
        instruments[19]
    };
    
    public static final MusicalInstrument[] onSale = {
        instruments[1],
        instruments[0],
        instruments[18],
        instruments[10]
    };
 
    //public static ArrayList<CartItem> cart = new ArrayList<>();
    public static ArrayList<MusicalInstrument> cart = new ArrayList<>();
    
    
    public MusicalInstrument(String name, String brand, String id, String description, String image, InstrumentCategory category, String warrantyPeriod, double price, boolean available, int quantity) {
        this.name = name;
        this.brand = brand;
        this.id = id;
        this.description = description;
        this.image = image;
        this.category = category;
        this.warrantyPeriod = warrantyPeriod;
        this.price = price;
        this.available = available;
        this.quantity = quantity;
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
    private final String id;
    private final InstrumentCategory category;
    private String warrantyPeriod;
    private final double price;
    private int quantity;
    private boolean available;
    public int cartQuantity = 0;
      
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
    
    public String getId() {
        return id;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int qty) {
        this.quantity = qty;
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


    public void setAvailability(boolean available) {
        this.available = available;
    }
    
    public static void addToCart(MusicalInstrument instr, int qty) {
        int currentItemQuantity = instr.getQuantity();
        // Validate
        if (qty > currentItemQuantity) {
            JOptionPane.showMessageDialog(null, "Unable to add item! There's " + currentItemQuantity + " item(s) remaining in stock.");
            return;
        }
        
        // Proceed to add the item to the cart
        if (!MusicalInstrument.cart.contains(instr)) {
            MusicalInstrument.cart.add(instr);
        }
        
        instr.setQuantity(currentItemQuantity - qty);
        instr.cartQuantity += qty;
        
        System.out.println("The item now has: " + instr.getQuantity() + " while cart quantity is: " + instr.cartQuantity);
        JOptionPane.showMessageDialog(null, "Successfully added the item to the cart!");
    }
    
    private static MusicalInstrument getItemBasedOnID(String instrumentId) {
        for (MusicalInstrument instrument : instruments) {
            if (instrument.getId().equals(instrumentId)) {
                return instrument;
            }
        }
        return null;
    }
    
    public static MusicalInstrument[] getItemBasedOnName(String name) {
        // TODO: Implement this for search functionality
        return null;
    };
    
    public static void displayItem(String id) throws IOException {
        MusicalInstrument chosenInstrument = getItemBasedOnID(id);

        ItemViewController.instrument = chosenInstrument;
        
        //Stringed
            //Plucked
                if (chosenInstrument instanceof Guitar) {
                    Guitar g = (Guitar) chosenInstrument;
                    ItemViewController.setAdditionalDetails(
                        "Type: " + g.typeOfGuitar.name() + " - " +
                        "Body Shape: " + g.getBodyShape() + " - " +
                        "Color: " + g.getColor() + " - " +
                        "Number of Strings: " + g.getNumberOfStrings()
                    );
                }
                
                if (chosenInstrument instanceof Harp) {
                    Harp h = (Harp) chosenInstrument;
                    ItemViewController.setAdditionalDetails(
                        "Body Shape: " + h.getBodyShape() + " - " +
                        "Color: " + h.getColor() + " - " +
                        "Harp has Pedal: " + h.getHarpPedal() + " - " +
                        "Number of Strings: " + h.getNumberOfStrings()
                    );
                }
                
            //Bowed
            if (chosenInstrument instanceof Bowed) {
                Bowed b = (Bowed) chosenInstrument;
                ItemViewController.setAdditionalDetails(
                    "Type: " + b.typeOfBow.name() + " - " +
                    "Body Shape: " + b.getBodyShape() + " - " +
                    "Color: " + b.getColor() + " - " +
                    "Number of Strings: " + b.getNumberOfStrings() + " - " +
                    "Playing Position: " + b.getPlayingPosition()
                );
            }
            
        //Keyboard
            if (chosenInstrument instanceof Keyboard) {
                Keyboard k = (Keyboard) chosenInstrument;
                ItemViewController.setAdditionalDetails(
                    "Number of Keys: " + k.getNumberOfKeys() + " - " +
                    "Keyboard is Acoustic: " + k.getAcoustic()
                );
            }
        
        //Percussion
            if (chosenInstrument instanceof Bells) {
                Bells b = (Bells) chosenInstrument;
                ItemViewController.setAdditionalDetails(
                    "Material: " + b.getMaterial() + " - " +
                    "Size: " + b.getSize() + " - " +
                    "Tone: " + b.getTone() + " - " +
                    "Shape: " + b.getShape() + " - " +
                    "Pitch Range" + b.getPitchRange()
                );
            }
            
            if (chosenInstrument instanceof Drums){
                Drums d = (Drums) chosenInstrument;
                ItemViewController.setAdditionalDetails(
                    "Type: " + d.typeOfDrum + " - " +
                    "Material: " + d.getMaterial() + " - " +
                    "Size: " + d.getSize() + " - " +
                    "Tone: " + d.getTone() + " - " +
                    "Configuration: " + d.getDrumsetConfiguration()
                );
            }
        
        //Wind
            if (chosenInstrument instanceof Brass){
                Brass br = (Brass) chosenInstrument;
                ItemViewController.setAdditionalDetails(
                    "Bore Shape: " + br.getBoreShape() + " - " +
                    "Pitch Range: " + br.getPitchRange() + " - " +
                    "Valve Type: " + br.typeOfValve + " - " +
                    "Number of Valves: " + br.getValves() + " - " +
                    "Mouthpiece: " + br.getMouthpiece()
                );
            }
            
            if (chosenInstrument instanceof Woodwind){
                Woodwind ww = (Woodwind) chosenInstrument;
                ItemViewController.setAdditionalDetails(
                    "Bore Shape: " + ww.getBoreShape() + " - " +
                    "Pitch Range: " + ww.getPitchRange() + " - " +
                    "Reed Type: " + ww.typeOfReed + " - " +
                    "Number of Keys: " + ww.getNumberOfKeys() + " - " +
                    "Ligature Type: " + ww.getLigatureType()
                );
            }
           
    
        App.changeStage("ItemView", "Item: " + chosenInstrument.getName(), 980, 588);
    };
}
