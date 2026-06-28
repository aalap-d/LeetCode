class Robot {
    int w;
    int h;
    int p;
    int t;
    boolean m;

    public Robot(int width, int height) {
        w = width;
        h = height;
        p = 2 * (w - 1) + 2 * (h - 1);
        t = 0;
        m = false;
    }

    public void step(int n) {
        if (n > 0) 
        m = true;
        t = (t + n) % p;
    }

    public int[] getPos() {
        if (t == 0)
         return new int[]{0, 0};
        if (t <= w - 1)
         return new int[]{t, 0};
        if (t <= w + h - 2)
         return new int[]{w - 1, t - w + 1};
        if (t <= 2 * w + h - 3)
         return new int[]{2 * w + h - 3 - t, h - 1};
        return new int[]{0, p - t};
    }

    public String getDir() {
        if (t == 0) return m ? "South" : "East";
        if (t <= w - 1) return "East";
        if (t <= w + h - 2) return "North";
        if (t <= 2 * w + h - 3) return "West";
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */