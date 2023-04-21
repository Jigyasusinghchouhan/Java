class shape {
    String defcolor = "yellow";
}

class square extends shape {
    String defcolor = "red";

    void supertest() {
        System.out.println(defcolor);
        System.out.println(super.defcolor);
    }
}

class question5 {
    public static void main(String[] abs) {
        square sq = new square();
        sq.supertest();
    }
}
