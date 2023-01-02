package RubiksCube;

public class main {
    public static void main(String[] args) {
        RubiksCube rc = new RubiksCube();
    
        //rc.L();
        //rc.T();
        //System.out.println(rc.toString());
        //System.out.println(rc.orderOf("LTTT"));
        //System.out.println(rc.orderOfPeice("LTTT", 2, 2, 0));
        int[][][] ret = rc.orderOfEachPeice("LTTT");
        for(int z = 0; z < 3; ++z) {
            for(int y = 2; y >= 0; --y) {
                for(int x = 0; x < 3; ++x) {
                    System.out.print(ret[x][y][z] + ", ");
                }
                System.out.println();
            }
            System.out.println();
        }
        //System.out.println(rc.orderOfEachPeice("LTTT"));
        
        /**
        rc.F();
        System.out.println(rc.toString());
        
        rc.B();
        System.out.println(rc.toString());
        
        rc.L();
        System.out.println(rc.toString());
        
        rc.R();
        System.out.println(rc.toString());
        
        rc.T();
        System.out.println(rc.toString());
        
        rc.D();
        System.out.println(rc.toString());
        **/
    }
}
