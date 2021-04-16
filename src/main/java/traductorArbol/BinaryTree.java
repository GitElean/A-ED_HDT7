/***
 * Universidad del Valle de Guatemala
 * Estructuras de datos
 * Hoja de trabajo #7
 * Abril 2021
 * @Author: Elean Rivas 19062
 * BinaryTree class
 */

package traductorArbol;

public class BinaryTree<R> {

    //Ejemplo tomado del libro de Java Structures


    protected R value;
    protected BinaryTree<R> root;
    protected BinaryTree<R> left, right;

    public BinaryTree(){
        value = null;
        root = null;
        left = right = this;
    }



    public BinaryTree(R val){
        value = val;
    }

    public BinaryTree<R> root(){
        return root;
    }

    public BinaryTree<R> left(){
        return left;
    }

    public BinaryTree<R> right(){
        return right;
    }

    protected void setRoot(BinaryTree<R> newRoot)
    // post: re-parents this node to parent reference, or null
    {
        if (newRoot!=null) {
            root = newRoot;
        }
    }

    public void setRight(BinaryTree<R> newRight){
        if (newRight != null){
            right = newRight;
            right.setRoot(this);
        }
    }

    public void setLeft(BinaryTree<R> newLeft){
        if (newLeft != null){
            right = newLeft;
            right.setRoot(this);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BinaryTree<R> tree) {
        if (tree == null)
        { return; }
        inOrder(tree.left);
        inOrder(tree.right);
    }

    public boolean isLeftChild() {
        if(root==null) {
            return false;
        }else if(root.left()==this){
            return true;
        }else {
            return false;
        }
    }

    public boolean isRightChild() {
        if(root==null) {
            return false;
        }else if(root.right()==this){
            return true;
        }else {
            return false;
        }
    }


    public boolean isLeaf() {
        return left == null && right == null;
    }


    public boolean isRoot() {
        return root == null;
    }


    public R val()
    {
        return value;
    }
    public void setValue(R val)
     {
        value = val;
    }

    public boolean hasLeftChild() {
        if(left==null) {
            return false;
        }else{
            return true;
        }
    }
    public boolean hasRightChild() {
        if(right==null) {
            return false;
        }else{
            return true;
        }
    }

}
