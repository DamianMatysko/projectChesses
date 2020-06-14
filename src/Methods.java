import java.util.HashSet;
import java.util.Set;

public class Methods {
    public String[][] board = {
            {"1", "2", "3", "4", "5", "6", "7", "8"},
            {"A", "B", "C", "D", "E", "F", "G", "H"}
    };

    public String normalize(String item) {
        if (item == null || item.length() != 2) {
            return null;
        }
        item = item.toUpperCase();
        if (((int) item.charAt(0) >= 49 && (int) item.charAt(0) <= 56) && ((int) item.charAt(1) >= 65 && (int) item.charAt(1) <= 72)) {
            String string = String.valueOf(item.charAt(1));
            string += String.valueOf(item.charAt(0));
            item = string;//swap chars
        }
        if ((int) item.charAt(0) < 65 || (int) item.charAt(0) > 72) {
            return null;//first position must be A-H
        }
        if ((int) item.charAt(1) < 49 || (int) item.charAt(1) > 56) {
            return null;//second position must be 1-8
        }
        return item;
        // A3 -> A3
        // 8a -> A8
        // null -> null
        // C18 -> null
        // AF ->null
        // T5 -> null
        // 6h -> H6
    }

    public boolean checkBishop(String pos, String dest) {
        pos = normalize(pos);
        dest = normalize(dest);
        if (pos == null || dest == null) {
            return false;
        }
        if (pos.equals(dest)) {
            return false;
        }

        if (((Math.abs((int) pos.charAt(0) - (int) dest.charAt(0))) != (Math.abs((int) pos.charAt(1) - (int) dest.charAt(1))))) {
            return false;//cant move on this position
        }
        return true;
    }

    public boolean checkQueen(String pos, String dest) {
        pos = normalize(pos);
        dest = normalize(dest);
        if (pos == null || dest == null) {
            return false;
        }
        if (pos.equals(dest)) {
            return false;
        }//bishop and rook movements


        if (((Math.abs((int) pos.charAt(0) - (int) dest.charAt(0))) != (Math.abs((int) pos.charAt(1) - (int) dest.charAt(1))))) {

            if (!((pos.charAt(0) == dest.charAt(0)) || (pos.charAt(1) == dest.charAt(1)))) {
                return false;//cant move on this position
            }
        }
        return true;
    }

    public boolean checkKing(String pos, String dest) {
        pos = normalize(pos);
        dest = normalize(dest);
        if (pos == null || dest == null) {
            return false;
        }
        if (pos.equals(dest)) {
            return false;//same position
        }
        if (!((Math.abs((int) pos.charAt(0) - (int) dest.charAt(0)) <= 1) && (Math.abs((int) pos.charAt(1) - (int) dest.charAt(1)) <= 1))) {
            return false;//cant move on this position
        }
        return true;
    }

    public Set possibleMovementsKnight(String pos) {
        Set<String> movements = new HashSet<>();
        pos = normalize(pos);
        if (pos == null) {
            return null;
        }
//        //manual add
//        movements.add(Character.toString((char)((int) pos.charAt(0)+2)) + (char) ((int) pos.charAt(1) + 1));
//        movements.add(Character.toString((char)((int) pos.charAt(0)+2)) + (char) ((int) pos.charAt(1) - 1));
//
//        movements.add(Character.toString((char)((int) pos.charAt(0)-2)) + (char) ((int) pos.charAt(1) + 1));
//        movements.add(Character.toString((char)((int) pos.charAt(0)-2)) + (char) ((int) pos.charAt(1) - 1));
//
//        movements.add(Character.toString((char)((int) pos.charAt(0)+1)) + (char) ((int) pos.charAt(1) + 2));
//        movements.add(Character.toString((char)((int) pos.charAt(0)+1)) + (char) ((int) pos.charAt(1) - 2));
//
//        movements.add(Character.toString((char)((int) pos.charAt(0)-1)) + (char) ((int) pos.charAt(1) + 2));
//        movements.add(Character.toString((char)((int) pos.charAt(0)-1)) + (char) ((int) pos.charAt(1) - 2));

//        if add
        String dest = "";
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                dest = Character.toString((char) i + 64) + Character.toString((char) j + 48);
                if (((Math.abs((int) pos.charAt(0) - (int) dest.charAt(0)) == 2) && (Math.abs((int) pos.charAt(1) - (int) dest.charAt(1)) == 1))
                        || ((Math.abs((int) pos.charAt(0) - (int) dest.charAt(0)) == 1) && (Math.abs((int) pos.charAt(1) - (int) dest.charAt(1)) == 2))) {
                    if (normalize(dest) != null) {// out of board
                        movements.add(dest);
                    }
                }
            }
        }
        return movements;
    }

    public boolean checkKnight(String pos, String dest) {
        pos = normalize(pos);
        dest = normalize(dest);
        if (pos == null || dest == null) {
            return false;
        }
        if (pos.equals(dest)) {
            return false;
        }
        if (!((Math.abs((int) pos.charAt(0) - (int) dest.charAt(0)) == 2) && (Math.abs((int) pos.charAt(1) - (int) dest.charAt(1)) == 1))) {
            if (!((Math.abs((int) pos.charAt(0) - (int) dest.charAt(0)) == 1) && (Math.abs((int) pos.charAt(1) - (int) dest.charAt(1)) == 2))) {
                return false;//cant move on this position
            }
        }
        return true;
    }

    public boolean checkRook(String pos, String dest) {
        pos = normalize(pos);
        dest = normalize(dest);
        if (pos == null || dest == null) {
            return false;
        }
        if (pos.equals(dest)) {
            return false;
        }
        if (!((pos.charAt(0) == dest.charAt(0)) || (pos.charAt(1) == dest.charAt(1)))) {
            return false;//cant move on this position
        }
        return true;
    }

    public boolean checkPawn(String pos, String dest) {
        pos = normalize(pos);
        dest = normalize(dest);
        if (pos == null || dest == null) {
            return false;
        }
        if (pos.equals(dest)) {
            return false;
        }
        return true;
    }
}
