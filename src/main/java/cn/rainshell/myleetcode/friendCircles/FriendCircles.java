package cn.rainshell.myleetcode.friendCircles;

import com.google.gson.Gson;

/**
 * 547. 朋友圈
 * 1，DFS
 * 2，BFS
 * 3，union-find
 *
 * 3并查集思路：
 *  主要是解决图论中「动态连通性」问题。比如说编译器判断同一个变量的不同引用，比如社交网络中的朋友圈计算等等。
 *  使用森林（若干棵树）来表示图的动态连通性，用数组来具体实现这个森林。
 *  路径优化非常巧妙，这样find就能以 O(1) 的时间找到某一节点的根节点，相应的，connected和union复杂度都下降为 O(1)。
 * @author jason
 * @date 2020/9/8
 */
public class FriendCircles {

    public int findCircleNum(int[][] M) {

        UF uf = new UF(M.length);
        for(int i=0;i<M.length;i++) {
            for(int j=0;j < i;j++) {
                if(M[i][j] == 1) {
                    uf.union(i,j);
                }
            }
        }
        return uf.count;
    }

    class UF {
        // 有多少个联通分量
        private int count;
        // 森林
        private int[] parent;
        // 一个树的重量，为了把小树接到大树的下面
        private int[] size;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            // 把每棵树的根节点设置为自己的下标
            for (int i=0;i<n;i++) {
                parent[i]=i;
                size[i]=1;
            }
        }

        /**
         * 联通两个节点
         * @param p
         * @param q
         */
        public void union(int p, int q) {
            int pRoot = findParent(p);
            int qRoot = findParent(q);
            if(pRoot == qRoot) {
                return;
            }
            // 把小树接到大树下，防止头重脚轻
            if(size[pRoot]>size[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }
            this.count--;
        }

        // 查找父亲节点的下标，其中做了缩短路径的优化
        private int findParent(int i) {
            while(parent[i] != i) {
                // 缩短到跟根节点的路径，很巧妙，这样在查找的时候都会以O（1）
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        /**
         * 查看两个节点是否联通
         * @param p
         * @param q
         * @return
         */
        public boolean connected(int p, int q) {
            int pRoot = findParent(p);
            int qRoot = findParent(q);
            return pRoot == qRoot;
        }
        // 多少个联通分量
        public int count() {
            return count;
        }
    }

    public static void main(String[] args) {
//        int [][] a = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        int [][] a = new int[][]{{1,1,1},{1,1,1},{1,1,1}};
        FriendCircles friendCircles = new FriendCircles();
        System.out.println(new Gson().toJson(friendCircles.findCircleNum(a)));
    }
}
