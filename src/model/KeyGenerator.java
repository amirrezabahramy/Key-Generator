package model;
/*

This file is part of Key-Generator.

    Key-Generator is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Key-Generator is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Key-Generator.  If not, see <https://www.gnu.org/licenses/>.

 */

import java.util.Random;

public class KeyGenerator {

    // This function generates 12-digit keys.
    public static long generateKey() {

        final long KEY = 322787489; // This is the base key that we use to generate other keys.
        final int F = 310; // First valid 12-digit number is the 310th multiple of KEY.
        final int L = 3098; // Last valid 12-digit number is the 3098th multiple of KEY.
        int range = L - F + 1;
        Random random = new Random();
        int i = random.nextInt(range) + F; // Variable i is going to be a number between F & L.
        return KEY * i + 467; // 467 is used to make the key more complicated.

    }

    /* This function converts a key to a string so it can be shown inside a textfield. It also adds
    a '-' character between every 3 digits so the key becomes more readable */
    public static String formatKey(long key) {

        StringBuilder formattedKey = new StringBuilder();
        String[] split = String.valueOf(key).split("");

        for (int i = 0, j = 1; i < split.length; j++) {
            if (j % 4 != 0) {
                formattedKey.append(split[i]);
                i++;
            } else {
                formattedKey.append('-');
            }
        }
        return formattedKey.toString();

    }

}