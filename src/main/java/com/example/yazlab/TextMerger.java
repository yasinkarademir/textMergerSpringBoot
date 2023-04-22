package com.example.yazlab;

import java.util.*;

public class TextMerger {






    public static String mergeTexts(String... inputlar) {
        List<String> sonuc = new ArrayList<>();


        for (String input : inputlar) {
            String[] kelimeler = input.split(" ");
            for (String kelime : kelimeler) {

                boolean eklendiMi = false;
                for (int j = 0; j < sonuc.size(); j++) {

                    if (kelime.startsWith(sonuc.get(j))) {
                        sonuc.set(j, kelime);
                        eklendiMi = true;
                        break;
                    } else if (sonuc.get(j).startsWith(kelime)) {
                        eklendiMi = true;
                        break;
                    }
                }
                if (!eklendiMi) {
                    sonuc.add(kelime);
                }
            }
        }

        return String.join(" ", sonuc);
    }


}
