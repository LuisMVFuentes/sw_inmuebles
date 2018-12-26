package utiles;

public class generador {

    public int getId() {
        Double m = Math.random() * 900 + 100;
        return m.intValue();
    }

    public String getCodigo() {
        String s = "";
        for (int i = 0; i < 3; i++) {
            Double m = Math.random() * 26 + 65;
            int orden = m.intValue();
            s += (char) orden;
        }
        s += getId();
        return s;
    }
}
