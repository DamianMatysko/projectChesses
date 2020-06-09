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
        if ((item.charAt(0) >= 49 || item.charAt(0) <= 56) && (item.charAt(1) >= 65 || item.charAt(1) <= 72)) {
            item = String.valueOf(item.charAt(1) + item.charAt(0));//swap chars
        }
        if (item.charAt(0) < 65 || item.charAt(0) > 72) {
            return null;//first position must be A-H
        }
        if (item.charAt(1) < 49 || item.charAt(1) > 56) {
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
        if (pos.equals(dest)){
            return false;
        }
        if (!((Math.abs(pos.charAt(0)-dest.charAt(0))<8)&&(Math.abs(pos.charAt(1)-dest.charAt(1))<8))){
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
        if (pos.equals(dest)){
            return false;
        }//Queen can move everywhere
        return true;
    }
    public boolean checkKing(String pos, String dest) {
        pos = normalize(pos);
        dest = normalize(dest);
        if (pos == null || dest == null) {
            return false;
        }
        if (pos.equals(dest)){
            return false;//same position
        }
        if (!((Math.abs(pos.charAt(0)-dest.charAt(0))<=1)&&(Math.abs(pos.charAt(1)-dest.charAt(1))<=1))){
            return false;//cant move on this position
        }
        return true;
    }
    public boolean checkKnight(String pos, String dest) {
        pos = normalize(pos);
        dest = normalize(dest);
        if (pos == null || dest == null) {
            return false;
        }
        if (pos.equals(dest)){
            return false;
        }
        return true;
    }
    public boolean checkRook(String pos, String dest) {
        pos = normalize(pos);
        dest = normalize(dest);
        if (pos == null || dest == null) {
            return false;
        }
        if (pos.equals(dest)){
            return false;
        }
        if (!((pos.charAt(0)==dest.charAt(0))||(pos.charAt(0)==dest.charAt(1)))){
            return false;//cant move on this position
        }
        return true;
    }
    public boolean checkPawn(String pos, String dest) {//todo
        pos = normalize(pos);
        dest = normalize(dest);
        if (pos == null || dest == null) {
            return false;
        }
        if (pos.equals(dest)){
            return false;
        }
        return true;
    }
}