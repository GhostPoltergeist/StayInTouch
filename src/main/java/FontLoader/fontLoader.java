package FontLoader;

import java.awt.*;
import java.io.InputStream;

public class fontLoader {
    public static Font jetBrainsMono, pressStart, quantico, electrolize, babelStones, agdasimaBold, agdasimaRegular, aleo = null;

    public static void loadFonts() {
        try {
            InputStream stream = ClassLoader.getSystemResourceAsStream("fonts/JetBrainsMono-Bold.ttf");
            jetBrainsMono = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(15f);

            InputStream streamTwo = ClassLoader.getSystemResourceAsStream("fonts/PressStart2P-Regular.ttf");
            pressStart = Font.createFont(Font.TRUETYPE_FONT, streamTwo).deriveFont(15f);

            InputStream streamThree = ClassLoader.getSystemResourceAsStream("fonts/Quantico-Bold.ttf");
            quantico = Font.createFont(Font.TRUETYPE_FONT, streamThree).deriveFont(15f);

            InputStream streamFour = ClassLoader.getSystemResourceAsStream("fonts/Electrolize-Regular.ttf");
            electrolize = Font.createFont(Font.TRUETYPE_FONT, streamFour).deriveFont(15f);

            InputStream streamFive = ClassLoader.getSystemResourceAsStream("fonts/BabelStoneShapes.ttf");
            babelStones = Font.createFont(Font.TRUETYPE_FONT, streamFive).deriveFont(15f);

            InputStream streamSix = ClassLoader.getSystemResourceAsStream("fonts/Agdasima-Bold.ttf");
            agdasimaBold = Font.createFont(Font.TRUETYPE_FONT, streamSix).deriveFont(15f);

            InputStream streamSeven = ClassLoader.getSystemResourceAsStream("fonts/Agdasima-Regular.ttf");
            agdasimaRegular = Font.createFont(Font.TRUETYPE_FONT, streamSeven).deriveFont(15f);

            InputStream streamEight = ClassLoader.getSystemResourceAsStream("fonts/Aleo-VariableFont_wght.ttf");
            aleo = Font.createFont(Font.TRUETYPE_FONT, streamEight).deriveFont(15f);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
