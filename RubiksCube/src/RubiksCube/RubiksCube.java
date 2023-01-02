package RubiksCube;

public class RubiksCube {
    
    
    //white
    private String[][] front;
    //yellow
    private String[][] back;
    //blue
    private String[][] top;
    //green
    private String[][] bottom;
    //orange
    private String[][] left;
    //red
    private String[][] right;
    
    
    
    String temp[];
    
    RubiksCube(){
        front = new String[3][3];
        back = new String[3][3];
        top = new String[3][3];
        bottom = new String[3][3];
        left = new String[3][3];
        right = new String[3][3];
        
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                front[i][j] = "white";
            }
        }
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                back[i][j] = "yellow";
            }
        }
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                top[i][j] = "blue";
            }
        }
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                bottom[i][j] = "green";
            }
        }
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                left[i][j] = "orange";
            }
        }
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                right[i][j] = "red";
            }
        }
        
        temp = new String[12];
    }
    
    /**
     * rotates a given face, ignores sides
     * @param face
     */
    private void rotateFace(String[][] face) {
        String[][] temp = new String[3][3];
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                temp[i][j] = face[i][j];
            }
        }
        
        face[0][0] = temp[2][0];
        face[1][0] = temp[2][1];
        face[2][0] = temp[2][2];
        
        face[0][1] = temp[1][0];
        face[2][1] = temp[1][2];
        
        face[0][2] = temp[0][0];
        face[1][2] = temp[0][1];
        face[2][2] = temp[0][2];
    }
    
    /**
     * 
     * @param side1
     * @param side2
     * @param side3
     * @param side4
     */
    private String[] rotateSides(String[] temp) {
        String[] ret = new String[12];
        for(int i = 0; i < 12; ++i) {
            ret[(i+3)%12] = temp[i];
        }
        return ret;
    }
    
    /**
     * F turns the front clockwise 
     */
    public void F() {
        rotateFace(front);
        
        temp[0] = left[2][0];
        temp[1] = left[2][1];
        temp[2] = left[2][2];
        temp[3] = top[0][0];
        temp[4] = top[1][0];
        temp[5] = top[2][0];
        temp[6] = right[0][2];
        temp[7] = right[0][1];
        temp[8] = right[0][0];
        temp[9] = bottom[2][2];
        temp[10] = bottom[1][2];
        temp[11] = bottom[0][2];
        
        temp = rotateSides(temp);
        
        left[2][0] = temp[0];
        left[2][1] = temp[1];
        left[2][2] = temp[2];
        top[0][0] = temp[3];
        top[1][0] = temp[4];
        top[2][0] = temp[5];
        right[0][2] = temp[6];
        right[0][1] = temp[7];
        right[0][0] = temp[8];
        bottom[2][2] = temp[9];
        bottom[1][2] = temp[10];
        bottom[0][2] = temp[11];
    }
    
    /**
     * F turns the right clockwise 
     */
    public void R() {
        rotateFace(right);
        
        temp[0] = front[2][0];
        temp[1] = front[2][1];
        temp[2] = front[2][2];
        temp[3] = top[2][0];
        temp[4] = top[2][1];
        temp[5] = top[2][2];
        temp[6] = back[0][2];
        temp[7] = back[0][1];
        temp[8] = back[0][0];
        temp[9] = bottom[2][0];
        temp[10] = bottom[2][1];
        temp[11] = bottom[2][2];
        
        temp = rotateSides(temp);
        
        front[2][0] = temp[0];
        front[2][1] = temp[1];
        front[2][2] = temp[2];
        top[2][0] = temp[3];
        top[2][1] = temp[4];
        top[2][2] = temp[5];
        back[0][2] = temp[6];
        back[0][1] = temp[7];
        back[0][0] = temp[8];
        bottom[2][0] = temp[9];
        bottom[2][1] = temp[10];
        bottom[2][2] = temp[11];
    }
    
    /**
     * turns the left face clockwise
     */
    public void L() {
        rotateFace(left);
        
        temp[0] = back[2][0];
        temp[1] = back[2][1];
        temp[2] = back[2][2];
        temp[3] = top[0][2];
        temp[4] = top[0][1];
        temp[5] = top[0][0];
        temp[6] = front[0][2];
        temp[7] = front[0][1];
        temp[8] = front[0][0];
        temp[9] = bottom[0][2];
        temp[10] = bottom[0][1];
        temp[11] = bottom[0][0];
        
        temp = rotateSides(temp);
        
        back[2][0] = temp[0];
        back[2][1] = temp[1];
        back[2][2] = temp[2];
        top[0][2] = temp[3];
        top[0][1] = temp[4];
        top[0][0] = temp[5];
        front[0][2] = temp[6];
        front[0][1] = temp[7];
        front[0][0] = temp[8];
        bottom[0][2] = temp[9];
        bottom[0][1] = temp[10];
        bottom[0][0] = temp[11];
    }
    
     /**
     * turns the top face clockwise
     */
    public void T() {
        rotateFace(top);
        
        temp[0] = left[2][2];
        temp[1] = left[1][2];
        temp[2] = left[0][2];
        temp[3] = back[2][2];
        temp[4] = back[1][2];
        temp[5] = back[0][2];
        temp[6] = right[2][2];
        temp[7] = right[1][2];
        temp[8] = right[0][2];
        temp[9] = front[2][2];
        temp[10] = front[1][2];
        temp[11] = front[0][2];
        
        temp = rotateSides(temp);
        
        left[2][2] = temp[0];
        left[1][2] = temp[1];
        left[0][2] = temp[2];
        back[2][2] = temp[3];
        back[1][2] = temp[4];
        back[0][2] = temp[5];
        right[2][2] = temp[6];
        right[1][2] = temp[7];
        right[0][2] = temp[8];
        front[2][2] = temp[9];
        front[1][2] = temp[10];
        front[0][2] = temp[11];
    }
    
    /**
     * rotates the bottom face clockwise
     */
    public void D() {
        rotateFace(bottom);
        
        temp[0] = left[0][0];
        temp[1] = left[1][0];
        temp[2] = left[2][0];
        temp[3] = front[0][0];
        temp[4] = front[1][0];
        temp[5] = front[2][0];
        temp[6] = right[0][0];
        temp[7] = right[1][0];
        temp[8] = right[2][0];
        temp[9] = back[0][0];
        temp[10] = back[1][0];
        temp[11] = back[2][0];
        
        
        
        temp = rotateSides(temp);
        
        left[0][0] = temp[0];
        left[1][0] = temp[1];
        left[2][0] = temp[2];
        front[0][0] = temp[3];
        front[1][0] = temp[4];
        front[2][0] = temp[5];
        right[0][0] = temp[6];
        right[1][0] = temp[7];
        right[2][0] = temp[8];
        back[0][0] = temp[9];
        back[1][0] = temp[10];
        back[2][0] = temp[11];
    }
    
    /**
     * rotates the back face clockwise
     */
    public void B() {
        rotateFace(back);
        
        temp[0] = right[2][0];
        temp[1] = right[2][1];
        temp[2] = right[2][2];
        temp[3] = top[2][2];
        temp[4] = top[1][2];
        temp[5] = top[0][2];
        temp[6] = left[0][2];
        temp[7] = left[0][1];
        temp[8] = left[0][0];
        temp[9] = bottom[0][0];
        temp[10] = bottom[1][0];
        temp[11] = bottom[2][0];
        
        
        
        temp = rotateSides(temp);
        
        right[2][0] = temp[0];
        right[2][1] = temp[1];
        right[2][2] = temp[2];
        top[2][2] = temp[3];
        top[1][2] = temp[4];
        top[0][2] = temp[5];
        left[0][2] = temp[6];
        left[0][1] = temp[7];
        left[0][0] = temp[8];
        bottom[0][0] = temp[9];
        bottom[1][0] = temp[10];
        bottom[2][0] = temp[11];
    }
    

    /**
     * Checks if the one subcube on the cube is solved is solved
     * @param x, y, z cords of subcube
     * @return is i solved?
     */
    public boolean isPeiceSolved(int x, int y, int z) {
        if(x == 0) {
            if(y == 0) {
                if(z == 0) {
                    if(front[0][0].equals("white") && left[2][0].equals("orange") && bottom[0][2].equals("green")) {
                        return true;
                    }
                    return false;
                }
                if(z == 1) {
                    if(left[1][0].equals("orange") && bottom[0][1].equals("green")) {
                        return true;
                    }
                    return false;
                }
                if(z == 2) {
                    if(back[2][0].equals("yellow") && left[0][0].equals("orange") && bottom[0][0].equals("green")) {
                        return true;
                    }
                    return false;
                }
            }
            if(y == 1) {
                if(z == 0) {
                    if(front[0][1].equals("white") && left[2][1].equals("orange")) {
                        return true;
                    }
                    return false;
                }
                if(z == 1) {
                   return true;
                }
                if(z == 2) {
                    if(back[2][1].equals("yellow") && left[0][1].equals("orange")) {
                        return true;
                    }
                    return false;
                }
            }
            if(y == 2) {
                if(z == 0) {
                    if(front[0][2].equals("white") && left[2][2].equals("orange") && top[0][0].equals("blue")) {
                        return true;
                    }
                    return false;
                }
                if(z == 1) {
                    if(left[1][2].equals("orange") && top[0][1].equals("blue")) {
                        return true;
                    }
                    return false;
                }
                if(z == 2) {
                    if(back[2][2].equals("yellow") && left[0][2].equals("orange") && top[0][2].equals("blue")) {
                        return true;
                    }
                    return false;
                }
            }
        }
        if(x == 1) {
            if(y == 0) {
                if(z == 0) {
                    if(front[1][0].equals("white") && bottom[1][2].equals("green")) {
                        return true;
                    }
                    return false;
                }
                if(z == 1) {
                    return true;
                }
                if(z == 2) {
                    if(back[1][0].equals("yellow") && bottom[1][0].equals("green")) {
                        return true;
                    }
                    return false;
                }
            }
            if(y == 1) {
                if(z == 0) {
                    return true;
                }
                if(z == 1) {
                    return true;
                }
                if(z == 2) {
                    return true;
                }
            }
            if(y == 2) {
                if(z == 0) {
                    if(front[1][2].equals("white") && top[1][0].equals("blue")) {
                        return true;
                    }
                    return false;
                }
                if(z == 1) {
                    return true;
                }
                if(z == 2) {
                    if(back[1][2].equals("yellow") && top[1][2].equals("blue")) {
                        return true;
                    }
                    return false;
                }
            }
        }
        if(x == 2) {
            if(y == 0) {
                if(z == 0) {
                    if(front[2][0].equals("white") && right[0][0].equals("red") && bottom[2][2].equals("green")) {
                        return true;
                    }
                    return false;
                }
                if(z == 1) {
                    if(right[1][0].equals("red") && bottom[2][1].equals("green")) {
                        return true;
                    }
                    return false;
                }
                if(z == 2) {
                    if(back[0][0].equals("yellow") && right[2][0].equals("red") && bottom[2][0].equals("green")) {
                        return true;
                    }
                    return false;
                }
            }
            if(y == 1) {
                if(z == 0) {
                    if(front[2][1].equals("white") && right[2][1].equals("orange")) {
                        return true;
                    }
                    return false;
                }
                if(z == 1) {
                   return true;
                }
                if(z == 2) {
                    if(back[0][1].equals("yellow") && right[2][1].equals("red")) {
                        return true;
                    }
                    return false;
                }
            }
            if(y == 2) {
                if(z == 0) {
                    if(front[2][2].equals("white") && right[0][2].equals("red") && top[2][0].equals("blue")) {
                        return true;
                    }
                    return false;
                }
                if(z == 1) {
                    if(right[1][2].equals("red") && top[2][1].equals("blue")) {
                        return true;
                    }
                    return false;
                }
                if(z == 2) {
                    if(back[0][2].equals("yellow") && right[2][2].equals("red") && top[2][2].equals("blue")) {
                        return true;
                    }
                    return false;
                }
            }
        }   
        return true;
    }
    
    /**
     * Checks if the cube is solved
     * @return is i solved?
     */
    public boolean isSolved() {
        boolean solved = true;
        int i = 0;
        
        while(solved == true && i < 9) {
            if(!front[i%3][i/3].equals("white")) {
                return false;
            }
            ++i;
        }
        i = 0;
        
        while(solved == true && i < 9) {
            if(!left[i%3][i/3].equals("orange")) {
                return false;
            }
            ++i;
        }
        i = 0;
        
        while(solved == true && i < 9) {
            if(!top[i%3][i/3].equals("blue")) {
                return false;
            }
            ++i;
        }
        i = 0;
        
        while(solved == true && i < 9) {
            if(!right[i%3][i/3].equals("red")) {
                return false;
            }
            ++i;
        }
        i = 0;
        
        while(solved == true && i < 9) {
            if(!bottom[i%3][i/3].equals("green")) {
                return false;
            }
            ++i;
        }
        i = 0;
        
        while(solved == true && i < 9) {
            if(!back[i%3][i/3].equals("yellow")) {
                return false;
            }
            ++i;
        }
        i = 0;
            
        return true;
    }
    
    
    /**
     * returns the order of a set of rotations
     * @param s the set of rotations
     * @return the order of the set
     */
    public int orderOf(String s) {
        char x;
        int numMoves;
        
        for(int i = 0; i < s.length(); ++i) {
            x = s.charAt(i);
            switch(x) {
                case 'F':
                    this.F();
                    break;
                case 'L':
                    this.L();
                    break;
                case 'R':
                    this.R();
                    break;
                case 'B':
                    this.B();
                    break;
                case 'T':
                    this.T();
                    break;
                case 'D':
                    this.D();
                    break;
            }
        }
        if(this.isSolved()) {
            return 0;
        }
        
        numMoves = 1;
        
        while(!this.isSolved()) {
            for(int i = 0; i < s.length(); ++i) {
                x = s.charAt(i);
                switch(x) {
                    case 'F':
                        this.F();
                        break;
                    case 'L':
                        this.L();
                        break;
                    case 'R':
                        this.R();
                        break;
                    case 'B':
                        this.B();
                        break;
                    case 'T':
                        this.T();
                        break;
                    case 'D':
                        this.D();
                        break;
                }
            }
            ++numMoves;
        }
        return numMoves;
    }
    
    /**
     * returns the order of a set of rotations for one subcube
     * @param s the set of rotations
     * @param x, y, z cords of subcube
     * @return the order of the set
     */
    public int orderOfPeice(String s, int x, int y, int z) {
        char c;
        int numMoves;
        
        for(int i = 0; i < s.length(); ++i) {
            c = s.charAt(i);
            switch(c) {
                case 'F':
                    this.F();
                    break;
                case 'L':
                    this.L();
                    break;
                case 'R':
                    this.R();
                    break;
                case 'B':
                    this.B();
                    break;
                case 'T':
                    this.T();
                    break;
                case 'D':
                    this.D();
                    break;
            }
        }
        if(this.isPeiceSolved(x, y, z)) {
            return 0;
        }
        
        numMoves = 1;
        
        while(!this.isPeiceSolved(x, y, z)) {
            for(int i = 0; i < s.length(); ++i) {
                c = s.charAt(i);
                switch(c) {
                    case 'F':
                        this.F();
                        break;
                    case 'L':
                        this.L();
                        break;
                    case 'R':
                        this.R();
                        break;
                    case 'B':
                        this.B();
                        break;
                    case 'T':
                        this.T();
                        break;
                    case 'D':
                        this.D();
                        break;
                }
            }
            ++numMoves;
        }
        return numMoves;
    }
    
    /**
     * finds the order f each peice for given move s.
     * @return an array of each subcube's order on s
     */
    public int[][][] orderOfEachPeice(String s){
        
        char c;
        int numMoves = 0;
        int[][][] ret = new int[3][3][3];
        for(int x = 0; x < 3; ++x) {
            for(int y = 0; y < 3; ++y) {
                for(int z = 0; z < 3; ++z) {
                    if((x == 1 && y == 1) || (x == 1 && z == 1) || (y == 1 && z == 1)) {
                        ret[x][y][z] = 0;
                    }
                    else {
                        ret[x][y][z] = -1;
                    }
                }
            }
        }
        
        do {
            for(int i = 0; i < s.length(); ++i) {
                c = s.charAt(i);
                switch(c) {
                    case 'F':
                        this.F();
                        break;
                    case 'L':
                        this.L();
                        break;
                    case 'R':
                        this.R();
                        break;
                    case 'B':
                        this.B();
                        break;
                    case 'T':
                        this.T();
                        break;
                    case 'D':
                        this.D();
                        break;
                }
            }
            for(int x = 0; x < 3; ++x) {
                for(int y = 0; y < 3; ++y) {
                    for(int z = 0; z < 3; ++z) {
                        if(ret[x][y][z] == -1 && this.isPeiceSolved(x, y, z)) {
                            ret[x][y][z] = numMoves;
                        }
                    }
                }
            }
            ++numMoves;
        } while (!this.isSolved());
        
        
        return ret;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("front:\n");
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                sb.append(front[j][2-i] + ", ");
            }
            sb.append("\n");
        }
        sb.append("\n");
        
        sb.append("left:\n");
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                sb.append(left[j][2-i] + ", ");
            }
            sb.append("\n");
        }
        sb.append("\n");
        
        sb.append("top:\n");
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                sb.append(top[j][2-i] + ", ");
            }
            sb.append("\n");
        }
        sb.append("\n");
        
        sb.append("right:\n");
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                sb.append(right[j][2-i] + ", ");
            }
            sb.append("\n");
        }
        sb.append("\n");
        
        sb.append("bottom:\n");
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                sb.append(bottom[j][2-i] + ", ");
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }
}
