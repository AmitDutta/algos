package leetcodeoj;

public class Problem223 {
   // rectangle overlap..not that easy to grasp initially
   public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
      int area = (C-A)*(D-B) + (G-E)*(H-F);
      if (E >= C || A >= G || F >= D || B >= H) return area;
      int length = Math.min(G, C) - Math.max(A, E);
      int width = Math.min(D, H) - Math.max(B, F);
      return area - (length * width);
   }
}
