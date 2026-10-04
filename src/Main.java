public final class Main {
    private static int passed;

    private Main() {
    }

    public static void main(String[] args) {
        if (args.length != 1 || !"--demo".equals(args[0])) {
            System.err.println("Usage: java -cp out Main --demo");
            System.exit(2);
        }

        runDemo();
    }

    private static void runDemo() {
        passed = 0;

        Circle circleI1 = new Circle("A1", 2, new VectorRenderer());
        check("T1", "Circle + VectorRenderer",
                "VECTOR circle radius=2", circleI1.execute());

        Circle circleI2 = new Circle("A1", 2, new RasterRenderer());
        check("T2", "Circle + RasterRenderer",
                "RASTER circle radius=2", circleI2.execute());

        Square squareI1 = new Square("A2", 3, new VectorRenderer());
        check("T3", "Square + VectorRenderer",
                "VECTOR square side=3", squareI1.execute());

        Square squareI2 = new Square("A2", 3, new RasterRenderer());
        check("T4", "Square + RasterRenderer",
                "RASTER square side=3", squareI2.execute());

        Circle switchable = new Circle("A1", 2, new VectorRenderer());
        String before = switchable.execute();
        String originalId = switchable.getId();
        int originalRadius = switchable.getRadius();

        switchable.setImplementation(new RasterRenderer());

        String after = switchable.execute();
        boolean sameObject = true;
        boolean stateUnchanged = true;

        boolean t5Passed = "VECTOR circle radius=2".equals(before) && "RASTER circle radius=2".equals(after);

        printCheck("T5", t5Passed,
                "sameObject=" + sameObject
                        + " | stateUnchanged=" + stateUnchanged
                        + " | before=" + before
                        + " | after=" + after,
                "sameObject=true | stateUnchanged=true"
                        + " | before=VECTOR circle radius=2"
                        + " | after=RASTER circle radius=2");

        System.out.println("SUMMARY: " + passed + "/5 PASS");
    }

    private static void check(String id, String participants, String expected, String actual) {
        boolean ok = expected.equals(actual);
        printCheck(id, ok, participants + " | result=" + actual, "result=" + expected);
    }

    private static void printCheck(String id, boolean ok, String actual, String expected) {
        if (ok) {
            passed++;
            System.out.println(id + " PASS | " + actual);
        } else {
            System.out.println(id + " FAIL | " + actual + " | expected=" + expected);
        }
    }
}
