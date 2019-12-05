import java.util.LinkedList;
import java.util.Queue;

/*
        二叉树的性质总结

1:二叉树的终端节点的个数是双分支节点的数目+1；
    即n0=n2+1;
2:二叉树的第i层至多有2的(i-1)次方个结点
3：深度为h的二叉树至多有2的h次方-1个结点
 满二叉树是二叉树中的每一层结点个数都是满的，都是2的（i-1）次方
 深度为h的满二叉树，结点个数为2的i次方-1个；
完全二叉树：除了最后一层，其余都是满的，最后一层或者是满的，或者是最右边缺少连续的若干个结点
完全二叉树的深度：有n个结点，2的h次方-1<n && 2的(h+1)次方-1>n,则h就是完全二叉树的深度。
注意------满二叉树也是完全二叉树

平衡二叉树:二叉树中结点的左右孩子的深度相差不能大于1；

二叉树的存储结构[顺序存储，链式存储]两种

二叉搜索树(二叉排序树)：从根节点开始，只要有左孩子，就比其父节点的值小，只要有右孩子，就比其父节点的val大

    二叉搜索树的 中序遍历为有序的


 */
class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val=val;
        this.right=null;
        this.left=null;
    }
}
public class Main {
    //二叉树的遍历
    //先序遍历
    private static void PreOrder(Node root){
        if(root!=null){
            System.out.println(root.val);
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }
    //中序遍历
    private static void InOrder(Node root){
        if(root!=null){
            InOrder(root.left);
            System.out.println(root.val);
            InOrder(root.right);
        }
    }
    //后序遍历
    private  static void PostOrder(Node root){
        if(root!=null){
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.println(root.val);
        }
    }
    //层次遍历
    private static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node>queue=new LinkedList<>();
        Node p=null;

        queue.add(root);
        while(!queue.isEmpty()){
            p=queue.poll();
            System.out.println(p.val);
            if(p.left!=null){
                queue.add(p.left);
            }
            if(p.right!=null){
                queue.add(p.right);
            }
        }
    }
    //求二叉树的深度
    private  static int depthTree(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(depthTree(root.right),depthTree(root.left))+1;
    }
    //是否为平衡二叉树
    private static boolean Isbalance(Node root){
        if(root==null){
            return true;
        }
        int leftdep=depthTree(root.left);
        int rightdep=depthTree(root.right);
        if(Math.abs(leftdep-rightdep)>1){
            return false;
        }
        return Isbalance(root.left)&&Isbalance(root.right);
    }
    //求二叉树的结点数
    private static int countTree(Node root){
        if(root==null){
            return 0;
        }
        return countTree(root.left)+countTree(root.right)+1;
    }

}
