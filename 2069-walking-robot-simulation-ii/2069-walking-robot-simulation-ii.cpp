class Robot {
    int dir = 0;
    int m, n;
    int i, j;
public:
    Robot(int width, int height) {
        i = 0;
        j = 0;
        m = height;
        n = width;
    }
    
    void step(int num) {
        num = num % (2 * (n - 1) + 2 * (m - 1));
        if (i == 0 && j == 0) dir = 3; // this line was missing from contest submission
        
        while (num > 0) {
            if (dir == 0) {
                if (j + num < n) {
                    j += num;
                    num = 0;
                } else {
                    dir = 1;
                    num -= n - 1 - j;
                    j = n - 1;
                }
            } else if (dir == 1) {
                if (i + num < m) {
                    i += num;
                    num = 0;
                } else {
                    dir = 2;
                    num -= m - 1 - i;
                    i = m - 1;
                }
            } else if (dir == 2) {
                if (j >= num) {
                    j -= num;
                    num = 0;
                } else {
                    num -= j;
                    j = 0;
                    dir = 3;
                }
            } else {
                if (i >= num) {
                    i -= num;
                    num = 0;
                } else {
                    dir = 0;
                    num -= i;
                    i = 0;
                }
            }
        }
    }
    
    vector<int> getPos() {
        return vector<int>{j, i};
    }
    
    string getDir() {
        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
};

/**
 * Your Robot object will be instantiated and called as such:
 * Robot* obj = new Robot(width, height);
 * obj->step(num);
 * vector<int> param_2 = obj->getPos();
 * string param_3 = obj->getDir();
 */